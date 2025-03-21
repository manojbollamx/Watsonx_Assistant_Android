package com.ibm.watson

import android.content.Context
import android.webkit.WebView
import android.webkit.WebViewClient

object WebViewSingleton {
    var webView: WebView? = null

    fun getWebView(context: Context): WebView {
        if (webView == null) {
            webView = WebView(context.applicationContext).apply {
                settings.javaScriptEnabled = true
                settings.domStorageEnabled = true
                webViewClient = WebViewClient()
                loadUrl("file:///android_asset/watson.html")
            }
        }
        return webView!!
    }
}