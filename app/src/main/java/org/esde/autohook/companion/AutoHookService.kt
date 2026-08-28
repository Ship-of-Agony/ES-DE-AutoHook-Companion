package org.esde.autohook.companion

import android.accessibilityservice.AccessibilityService
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.hardware.display.DisplayManager
import android.view.Display
import android.view.accessibility.AccessibilityEvent

class AutoHookService : AccessibilityService() {

    private var isCompanionLaunched = false

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (event == null) return

        val prefs = getSharedPreferences("autohook_prefs", Context.MODE_PRIVATE)
        val isEnabled = prefs.getBoolean("is_enabled", true)
        if (!isEnabled) return

        if (event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            val packageName = event.packageName?.toString() ?: return

            if (packageName == "org.es_de.frontend") {
                if (!isCompanionLaunched) {
                    launchCompanionOnSecondaryDisplay()
                    isCompanionLaunched = true
                }
            } else if (packageName != "com.esde.companion") {
                isCompanionLaunched = false
            }
        }
    }

    private fun launchCompanionOnSecondaryDisplay() {
        val displayManager = getSystemService(Context.DISPLAY_SERVICE) as? DisplayManager ?: return
        val displays = displayManager.displays

        var targetDisplayId = Display.DEFAULT_DISPLAY
        for (display in displays) {
            if (display.displayId != Display.DEFAULT_DISPLAY) {
                targetDisplayId = display.displayId
                break
            }
        }

        val launchIntent = packageManager.getLaunchIntentForPackage("com.esde.companion")
        if (launchIntent != null) {
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
            val options = ActivityOptions.makeBasic()
            options.launchDisplayId = targetDisplayId
            startActivity(launchIntent, options.toBundle())
        }
    }

    override fun onInterrupt() {
        isCompanionLaunched = false
    }
}