# Watson Assistant Bottom Sheet Integration (Android)

This project demonstrates how to integrate **IBM Watson Assistant** inside an **Android BottomSheetDialogFragment** using a **WebView**, with full session persistence across open/close actions.

## 🧠 Features

- 📱 Single-Activity + Fragment-based architecture
- 🧩 Bottom sheet UI with `BottomSheetDialogFragment`
- 🌐 Watson Assistant loaded via WebView
- 💬 Chat session **persists** across bottom sheet dismissals
- 🧤 Handles Watson chat close button (custom override via JS)
- 🔁 WebView session retained without reloading chat or losing messages

---

## 📌 Goal

The goal of this app was to create a **help panel** powered by Watson Assistant that slides up as a **bottom sheet**, allowing users to chat, and **close/reopen the sheet without losing chat history**.

---

## 🛠️ How It Works

### 1. **Architecture**

- `MainActivity`: Hosts the initial `HelpFragment`
- `HelpFragment`: Contains a "Help" button
- `HelpBottomSheetFragment`: Contains a WebView loading the Watson Assistant chat (from `watson.html`)
- `watson.html`: Loads Watson Assistant using `watsonAssistantChatOptions` and injects a custom close button handler via JS

### 2. **Session Persistence**

- The WebView is **only initialized once** and **not destroyed** when the bottom sheet is dismissed.
- WebView's `JavaScriptEnabled` and `DOMStorageEnabled` settings are turned on.
- `loadUrl("file:///android_asset/watson.html")` ensures a consistent, local HTML entry point.
- The Watson Assistant chat itself handles session persistence internally via cookies/local storage.

### 3. **Intercepting the Watson Close Button**

- The Watson WebChat's close button is identified using the class selector:
  ```css
  #WACContainer.WACContainer .cds--btn--ghost
  ```
- A custom JavaScript function overrides its click handler to call a native Android method:
  ```js
  Android.onCloseButtonClicked();
  ```
- This is hooked up using `addJavascriptInterface()` in Kotlin:
  ```kotlin
  webView.addJavascriptInterface(WebAppInterface(this), "Android")
  ```

---

## 📂 Key Files

- `HelpFragment.kt`: Hosts the help button and launches the bottom sheet
- `HelpBottomSheetFragment.kt`: Displays the WebView and handles Watson chat logic
- `watson.html`: Custom wrapper around Watson Assistant Chat UI (loaded inside WebView)

---

## 🚀 To Run

1. Clone the repo
2. Add your Watson Assistant `integrationID`, `region`, and `serviceInstanceID` in `watson.html`
3. Place `watson.html` in `src/main/assets/`
4. Build & run the app on an Android device or emulator

---

## ✅ Outcome

- Smooth Watson chat experience in a native Android app
- Chat persists even when user closes and reopens the bottom sheet
- Fully functional close button that dismisses the sheet without clearing WebView memory

---

## 📸 Screenshots

> (Optional: Add screenshots showing chat open, closed, and reopened with preserved messages)

---

## 🧠 Built With

- Kotlin
- AndroidX
- BottomSheetDialogFragment
- IBM Watson Assistant WebChat
- JavaScript Interface

---

## 💬 Author

Made with ☕ and 🔧 by manojbollam@ibm.com

