package com.example.demoappkotlin.WebView

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import com.example.demoappkotlin.R
import com.example.demoappkotlin.utils.LOGINURL
import com.example.demoappkotlin.utils.SIGNUPURL
import com.example.demoappkotlin.utils.WEBVIEWURL

class WebViewActivity : AppCompatActivity() {
    lateinit var webView: WebView
    lateinit var btnLoginPage: Button
    lateinit var btnSignUpPage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        webView = findViewById(R.id.webView)
        webViewSetup()
        btnLoginPage = findViewById(R.id.btnLoginPage)
        btnSignUpPage = findViewById(R.id.btnSignUpPage)
        btnLoginPage.setOnClickListener {
            webView.apply {
                webViewClient = WebViewClient()
                loadUrl(LOGINURL)
                settings.javaScriptEnabled = true
            }
        }
        btnSignUpPage.setOnClickListener {
            webView.apply {
                webViewClient = WebViewClient()
                loadUrl(SIGNUPURL)
                settings.javaScriptEnabled = true
            }
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) webView.goBack() else super.onBackPressed()
    }

    @SuppressLint("NewApi")
    private fun webViewSetup() {
        webView.apply {
            loadUrl(WEBVIEWURL)
            webViewClient = WebViewClient()
            settings.safeBrowsingEnabled = true
        }
    }
}
