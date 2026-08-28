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

        if (event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            val currentPkg = event.packageName?.toString() ?: return

            if (currentPkg == esDePackage && !isCompanionLaunched) {
                isCompanionLaunched = true
                launchCompanionOnSecondDisplay()
            } else if (currentPkg != esDePackage && currentPkg != companionPackage) {
                isCompanionLaunched = false
            }
        }
    }

    private fun launchCompanionOnSecondDisplay() {
        val displayManager = getSystemService(Context.DISPLAY_SERVICE) as DisplayManager
        val displays = displayManager.displays

        val mainDisplayId = Display.DEFAULT_DISPLAY
            displays.firstOrNull { it.displayId != mainDisplayId }?.displayId ?: mainDisplayId
        } else {
            mainDisplayId
        }

        val launchIntent = packageManager.getLaunchIntentForPackage(companionPackage)
        if (launchIntent != null) {

            val options = ActivityOptions.makeBasic()

            startActivity(launchIntent, options.toBundle())
        }
    }

    override fun onInterrupt() {
        isCompanionLaunched = false
    }
}