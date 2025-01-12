package com.example.bdpetcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Catdisease extends AppCompatActivity {
    CardView catflu,thanda,kanerrog,virusrog,dadrog,ukun,paracitamol;
    AdView adview,adview2;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catdisease);

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }else {

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }

        catflu=findViewById(R.id.catflu);
      thanda=findViewById(R.id.thanda);
        kanerrog=findViewById(R.id.kanerrog);
       virusrog=findViewById(R.id.viralrog);
        dadrog=findViewById(R.id.dadrog);
        ukun=findViewById(R.id.ukon);
        paracitamol=findViewById(R.id.paracitamol);


        back=findViewById(R.id.shoplink);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Catdisease.this,MainActivity.class);
                startActivity(intent);
            }
        });







        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        adview = findViewById(R.id.adView);


        AdRequest adRequest = new AdRequest.Builder().build();
        adview.loadAd(adRequest);










        catflu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Catdisease.this,Catflu.class);
                startActivity(intent);
            }
        });

      thanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Catdisease.this,THANDA.class);
                startActivity(intent);
            }
        });
       kanerrog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Catdisease.this,Kanerrog.class);
                startActivity(intent);
            }
        });

        paracitamol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Catdisease.this,Paracitamol.class);
                startActivity(intent);
            }
        });

        dadrog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Catdisease.this,Dadrog.class);
                startActivity(intent);
            }
        });

        ukun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Catdisease.this,UKUN.class);
                startActivity(intent);
            }
        });

        catflu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Catdisease.this,Catflu.class);
                startActivity(intent);
            }
        });

        virusrog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Catdisease.this,Viralrog.class);
                startActivity(intent);
            }
        });





    }
}