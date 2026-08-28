package org.esde.autohook.companion

import android.accessibilityservice.AccessibilityService
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.hardware.display.DisplayManager
import android.view.Display
import android.view.accessibility.AccessibilityEvent

class AutoHookService : AccessibilityService() {

    private val esDePackage = "org.es_de.frontend"
    private val companionPackage = "com.esde.companion"
    private var isCompanionLaunched = false

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (event == null) return

        // 1. Prüfen, ob der Hook über die Quick Settings Tile aktiv ist
        val prefs = getSharedPreferences("autohook_prefs", Context.MODE_PRIVATE)
        val isEnabled = prefs.getBoolean("is_enabled", true)
        if (!isEnabled) {
            isCompanionLaunched = false
            return
        }

        // 2. Fensterwechsel überwachen
        if (event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            val currentPkg = event.packageName?.toString() ?: return

            if (currentPkg == esDePackage && !isCompanionLaunched) {
                isCompanionLaunched = true
                launchCompanionOnSecondDisplay()
            } else if (currentPkg != esDePackage && currentPkg != companionPackage) {
                // Zurücksetzen, wenn eine andere App (z.B. Launcher) im Vordergrund ist
                isCompanionLaunched = false
            }
        }
    }

    private fun launchCompanionOnSecondDisplay() {
        val displayManager = getSystemService(Context.DISPLAY_SERVICE) as DisplayManager
        val displays = displayManager.displays

        // Zweites Display ermitteln (falls vorhanden, sonst Fallback auf Standard)
        val mainDisplayId = Display.DEFAULT_DISPLAY
        val targetDisplayId = if (displays.size > 1) {
            displays.firstOrNull { it.displayId != mainDisplayId }?.displayId ?: mainDisplayId
        } else {
            mainDisplayId
        }

        val launchIntent = packageManager.getLaunchIntentForPackage(companionPackage)
        if (launchIntent != null) {
            launchIntent.addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TOP
            )

            val options = ActivityOptions.makeBasic()
            options.launchDisplayId = targetDisplayId

            startActivity(launchIntent, options.toBundle())
        }
    }

    override fun onInterrupt() {
        isCompanionLaunched = false
    }

    override fun onDestroy() {
        super.onDestroy()
        isCompanionLaunched = false
    }
}