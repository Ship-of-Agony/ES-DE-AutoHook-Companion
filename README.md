# 🎮 ES-DE AutoHook Companion

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white" alt="Android" />
  <img src="https://img.shields.io/badge/Language-Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white" alt="Kotlin" />
  <img src="https://img.shields.io/badge/Target_Device-Dual--Screen_Handhelds-FF4500?style=for-the-badge" alt="Dual-Screen" />
  <img src="https://img.shields.io/badge/License-MIT-blue?style=for-the-badge" alt="License" />
</p>

A lightweight, completely **headless Android accessibility hook** tailored for dual-screen handheld devices (such as the AYN Thor). 

Whenever you launch **EmulationStation Desktop Edition (ES-DE)** on the primary display, **ES-DE AutoHook Companion** intercepts the event and automatically routes the **ES-DE Companion** app directly to the secondary screen (Display 1).

---

## ⚡ Highlights

* 👻 **Headless Operation:** Zero launcher icons, zero UI bloat, and zero clutter in your app drawer.
* 🔋 **Ultra-Low Overhead:** Pure event-driven background service that only activates when ES-DE launches.
* 🖥️ **Targeted Multi-Display Launching:** Uses Android's `DisplayManager` and `ActivityOptions` to explicitly assign the companion app to secondary framebuffers.
* 🔄 **Clean State Management:** Automatically resets its launch trigger whenever you exit ES-DE.

---

## 📦 Package Routing

| Target | Package Name | Role |
| :--- | :--- | :--- |
| **Frontend** | `org.es_de.frontend` | Main display launcher triggering the hook |
| **Companion** | `com.esde.companion` | Secondary display companion app |

---

## 🚀 Installation & Setup

### 1. Install the APK
Download the latest `app-release.apk` from the [Releases](https://github.com/Ship-of-Agony/ES-DE-AutoHook-Companion/releases) section and install it on your device.

### 2. Enable Accessibility Service
Because this app operates silently in the background, you must grant accessibility permissions once:

1. Open Android **Settings** ⚙️.
2. Go to **Accessibility** (or **System → Accessibility**).
3. Tap **Downloaded Services** (or **Installed Apps**).
4. Select **ES-DE AutoHook Companion**.
5. Toggle the service **ON** and accept the system prompt.

---

## 🛠️ Build from Source

### Prerequisites
* Android Studio (Ladybug / Meerkat or newer)
* Android SDK 35
* Java 17+

## 📄 License

This project is licensed under the MIT License.
