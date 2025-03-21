package com.ibm.watson

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.fragment.app.Fragment

class WebViewFragment : Fragment() {
    private var isChatOpen = false  // Track chat window state

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_webview, container, false)

        val webView = view.findViewById<WebView>(R.id.webView)
        val helpButton = view.findViewById<Button>(R.id.helpButton)
        val chatContainer = view.findViewById<View>(R.id.chatContainer)

        // Enable JavaScript and DOM Storage
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

        // Load Watson Assistant Web Chat
        webView.webViewClient = WebViewClient()
        webView.loadUrl("file:///android_asset/watson.html")

        // Handle Help Button Click
        helpButton.setOnClickListener {
            if (isChatOpen) {
                chatContainer.visibility = View.GONE  // Hide chat window
            } else {
                chatContainer.visibility = View.VISIBLE  // Show chat window
            }
            isChatOpen = !isChatOpen
        }

        return view
    }
}