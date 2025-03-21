package com.ibm.watson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.JavascriptInterface
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class HelpBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var webViewContainer: ViewGroup

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_help_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webViewContainer = view.findViewById(R.id.webViewContainer)
        val webView = WebViewSingleton.getWebView(requireContext())
        (webView.parent as? ViewGroup)?.removeView(webView)
        webViewContainer.addView(webView)
        webView.addJavascriptInterface(WebAppInterface(this), "Android")
    }

    // Function to close Bottom Sheet
    fun closeBottomSheet() {
        dismiss()
    }

    class WebAppInterface(private val fragment: HelpBottomSheetFragment) {
        @JavascriptInterface
        fun onCloseButtonClicked() {
            fragment.closeBottomSheet()
        }
    }
}
