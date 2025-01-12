package com.example.bdpetcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class ALLvideo extends AppCompatActivity {
    WebView web;
    ProgressBar probar2;
    public static String video="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allvideo);
        probar2=findViewById(R.id.progressBar2);
        probar2.setVisibility(View.VISIBLE);

        web=findViewById(R.id.web);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl(video);
        probar2.setVisibility(View.GONE);



    }
}