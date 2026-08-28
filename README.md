<a href="https://apps.obtainium.imranr.dev/redirect?r=obtainium://app/%7B%22id%22%3A%22org.esde.autohook.companion%22%2C%22url%22%3A%22https%3A%2F%2Fgithub.com%2FShip-of-Agony%2FES-DE-AutoHook-Companion%22%2C%22author%22%3A%22Ship-of-Agony%22%2C%22name%22%3A%22ES-DE%20AutoHook%20Companion%22%2C%22preferredApkIndex%22%3A0%2C%22additionalSettings%22%3A%22%7B%5C%22includePrereleases%5C%22%3Afalse%2C%5C%22fallbackToOlderReleases%5C%22%3Atrue%2C%5C%22filterReleaseTitlesByRegEx%5C%22%3A%5C%22%5C%22%2C%5C%22filterReleaseNotesByRegEx%5C%22%3A%5C%22%5C%22%2C%5C%22verifyLatestTag%5C%22%3Afalse%2C%5C%22sortMethodChoice%5C%22%3A%5C%22date%5C%22%2C%5C%22useLatestAssetDateAsReleaseDate%5C%22%3Afalse%2C%5C%22releaseTitleAsVersion%5C%22%3Afalse%2C%5C%22trackOnly%5C%22%3Afalse%2C%5C%22versionExtractionRegEx%5C%22%3A%5C%22%5C%22%2C%5C%22matchGroupToUse%5C%22%3A%5C%22%5C%22%2C%5C%22versionDetection%5C%22%3Atrue%2C%5C%22releaseDateAsVersion%5C%22%3Afalse%2C%5C%22useVersionCodeAsOSVersion%5C%22%3Afalse%2C%5C%22apkFilterRegEx%5C%22%3A%5C%22%5C%22%2C%5C%22invertAPKFilter%5C%22%3Afalse%2C%5C%22autoApkFilterByArch%5C%22%3Atrue%2C%5C%22appName%5C%22%3A%5C%22%5C%22%2C%5C%22appAuthor%5C%22%3A%5C%22%5C%22%2C%5C%22shizukuPretendToBeGooglePlay%5C%22%3Afalse%2C%5C%22allowInsecure%5C%22%3Afalse%2C%5C%22exemptFromBackgroundUpdates%5C%22%3Afalse%2C%5C%22skipUpdateNotifications%5C%22%3Afalse%2C%5C%22about%5C%22%3A%5C%22%5C%22%2C%5C%22refreshBeforeDownload%5C%22%3Afalse%2C%5C%22includeZips%5C%22%3Afalse%2C%5C%22zippedApkFilterRegEx%5C%22%3A%5C%22%5C%22%7D%22%2C%22overrideSource%22%3Anull%7D">
  <img 
    src="https://github.com/ImranR98/Obtainium/blob/main/assets/graphics/badge_obtainium.png?raw=true" 
    alt="Add to Obtainium" 
    width="182" />
</a>

![Version](https://img.shields.io/badge/version-1.1.0-blue)
![Android](https://img.shields.io/badge/Android-8%2B-green)


# 🎮 ES-DE AutoHook Companion

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white" alt="Android" />
  <img src="https://img.shields.io/badge/Language-Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white" alt="Kotlin" />
  <img src="https://img.shields.io/badge/Target_Device-Dual--Screen_Handhelds-FF4500?style=for-the-badge" alt="Dual-Screen" />
  <img src="https://img.shields.io/badge/License-MIT-blue?style=for-the-badge" alt="License" />
</p>

A lightweight, completely **headless Android accessibility hook** tailored for dual-screen handheld devices (such as the AYN Thor). 

Whenever you launch **EmulationStation Desktop Edition (ES-DE)** on the primary display, **ES-DE AutoHook Companion** intercepts the event and automatically routes the [**ES-DE Companion**](https://github.com/RobZombie9043/es-de-companion) app directly to the secondary screen (Display 1).

---

## ⚡ Highlights

* 👻 **Headless Operation:** Zero launcher icons and zero clutter in your home launcher while retaining full branding in system menus and Obtainium.
* 🎛️ **Quick Settings Toggle:** Turn auto-launching ON or OFF at any time directly from your notification panel without diving into settings.
* 🔋 **Ultra-Low Overhead:** Pure event-driven background service that only activates when ES-DE launches.
* 🖥️ **Targeted Multi-Display Launching:** Uses Android's `DisplayManager` and `ActivityOptions` to explicitly assign the companion app to secondary framebuffers.
* 🔄 **Clean State Management:** Automatically resets its launch trigger whenever you exit ES-DE.

---

## 📦 Package Routing

| Target | Package Name | Role |
| :--- | :--- | :--- |
| **ES-DE Frontend** | `org.es_de.frontend` | Main display launcher triggering the hook |
| [**ES-DE Companion**](https://github.com/RobZombie9043/es-de-companion) | `com.esde.companion` | Secondary display companion app by RobZombie9043 |

---

## 🚀 Installation & Setup

### 1. Install the APK
Download the latest `app-release.apk` from the [Releases](https://github.com/Ship-of-Agony/ES-DE-AutoHook-Companion/releases) section (or install/update directly via Obtainium).

### 2. Enable the Accessibility Service
Because this app operates silently in the background, you must enable the accessibility service once:

1. Open Android **Settings** ⚙️.
2. Go to **Accessibility** (or **System → Accessibility**).
3. Tap **Downloaded Services** (or **Installed Apps**).
4. Select **ES-DE AutoHook Companion**.
5. Toggle the switch to **ON** and confirm the prompt.

---

## 🎛️ Quick Settings Tile (Quick Toggle)

You can easily pause and resume the automatic companion launch without turning off the accessibility service:

<p align="center">
  <b>Active (Auto-Launch)</b> ↔️ <b>Inactive (Disabled)</b>
</p>

### How to add the Quick Settings Tile:
1. Swipe down twice from the top of the screen to open the full **Quick Settings / Notification Panel**.
2. Tap the **Edit / Pencil icon** ✏️ to customize your tiles.
3. Scroll down to find the **AutoHook** tile.
4. Drag and drop the **AutoHook** tile into your active quick settings area.
5. Tap **Back** or exit edit mode.

### Usage:
* **Tap once:** Toggles between **`Auto-Launch`** (active) and **`Disabled`** (paused).
* When disabled, ES-DE will open normally without triggering the secondary screen companion.

---

## 🗑️ Uninstallation

Since **ES-DE AutoHook Companion** runs headlessly without an app icon on your home screen, uninstall it using one of the following methods:

### Method 1: Android System Settings
1. Open Android **Settings** ⚙️.
2. Go to **Apps** (or **Apps & Notifications → See all apps**).
3. Search for and select **ES-DE AutoHook Companion**.
4. Tap **Uninstall**.

### Method 2: Via Obtainium
If you installed the app using Obtainium:
1. Open **Obtainium**.
2. Tap on **ES-DE AutoHook Companion**.
3. Tap the **Trash/Uninstall** icon at the top right.

### Method 3: Via ADB (Command Line)
Connect your device to a PC with USB Debugging enabled and run:

```bash
adb uninstall org.esde.autohook.companion
```

## 📄 License

This project is licensed under the MIT License.
