package com.wahitftry.with_me

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView: WebView = findViewById(R.id.webview)
        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        val progressText: TextView = findViewById(R.id.progressText)

        webView.webViewClient = WebViewClient()
        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                if (newProgress < 100) {
                    webView.visibility = WebView.GONE
                    progressBar.visibility = ProgressBar.VISIBLE
                    progressText.visibility = TextView.VISIBLE
                    progressBar.progress = newProgress
                    progressText.text = "$newProgress%"
                } else {
                    webView.visibility = WebView.VISIBLE
                    progressBar.visibility = ProgressBar.GONE
                    progressText.visibility = TextView.GONE
                }
            }
        }
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://deepnote.com/app/wahitftry/Mahira-Artificial-General-Intelligence-6c171d39-f4ef-47a7-9ccc-3879b8ca65db?__embedded=true")
    }
}