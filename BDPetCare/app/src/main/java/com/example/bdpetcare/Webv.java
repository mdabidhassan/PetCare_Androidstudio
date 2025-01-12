package com.example.bdpetcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Webv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webv);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        // find the WebView control in the layout
        WebView webView = (WebView) findViewById(R.id.webView);

        // enable JavaScript in the WebView
        webView.getSettings().setJavaScriptEnabled(true);

        // set a custom WebViewClient to control the WebView's behavior
        webView.setWebViewClient(new WebViewClient());

        // load the website in the WebView
        webView.loadUrl(url);
    }
}