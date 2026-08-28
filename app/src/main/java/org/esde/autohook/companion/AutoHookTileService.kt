package org.esde.autohook.companion

import android.content.Context
import android.graphics.drawable.Icon
import android.os.Build
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService

class AutoHookTileService : TileService() {

    override fun onStartListening() {
        super.onStartListening()
        updateTileState()
    }

    override fun onClick() {
        super.onClick()
        val prefs = getSharedPreferences("autohook_prefs", Context.MODE_PRIVATE)
        val currentState = prefs.getBoolean("is_enabled", true)
        val newState = !currentState

        prefs.edit().putBoolean("is_enabled", newState).apply()
        updateTileState()
    }

    private fun updateTileState() {
        val prefs = getSharedPreferences("autohook_prefs", Context.MODE_PRIVATE)
        val isEnabled = prefs.getBoolean("is_enabled", true)

        qsTile?.apply {
            state = if (isEnabled) Tile.STATE_ACTIVE else Tile.STATE_INACTIVE
            label = "AutoHook"
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                subtitle = if (isEnabled) "Auto-Launch" else "Disabled"
            }
            icon = Icon.createWithResource(this@AutoHookTileService, R.drawable.ic_tile_hook)
            updateTile()
        }
    }
}