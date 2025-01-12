package com.example.bdpetcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class DailycareActivity extends AppCompatActivity {
    AdView adview,adview2;
    CardView porishkar,gosol,sitejotno,goromejotno,manushiksastho,sastho,khabarniom;
    InterstitialAd mInterstitialAd;
    ImageView daily;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailycare);
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }else {

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }



daily=findViewById(R.id.shoplink);
        porishkar=findViewById(R.id.porishkar);
     gosol=findViewById(R.id.gosol);
       sitejotno=findViewById(R.id.sitejotno);
     goromejotno=findViewById(R.id.goromejotno);
        khabarniom=findViewById(R.id.khabarniom);

        sastho=findViewById(R.id.sastho);
       manushiksastho=findViewById(R.id.manushiksastho);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        adview2 = findViewById(R.id.adView2);

        AdRequest adRequest = new AdRequest.Builder().build();

        adview2.loadAd(adRequest);









        daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DailycareActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


       manushiksastho.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(DailycareActivity.this,manushiksastho.class);
               startActivity(intent);
           }
       });



        sastho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DailycareActivity.this, Sastho.class);
                startActivity(intent);
            }
        });



        khabarniom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DailycareActivity.this, khabarniom.class);
                startActivity(intent);
            }
        });


        goromejotno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DailycareActivity.this, goromejotno.class);
                startActivity(intent);
            }
        });




       sitejotno.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(DailycareActivity.this, Sitejotno.class);
               startActivity(intent);
           }
       });


        porishkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DailycareActivity.this, Petcare.class);
                startActivity(intent);
            }
        });

        gosol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DailycareActivity.this, Gosolo.class);
                startActivity(intent);
            }
        });




    }


}