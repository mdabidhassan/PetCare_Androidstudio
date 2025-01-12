package com.example.bdpetcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Catsolution extends AppCompatActivity {
    CardView dailycare,foodhabit,disease,vaccine,firstaid,ownercare,videos,others;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catsolution);
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }else {

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }


ownercare=findViewById(R.id.ownercare);
      vaccine=findViewById(R.id.vaccine);
       firstaid=findViewById(R.id.firstaid);
        dailycare=findViewById(R.id.dailycare);
        foodhabit=findViewById(R.id.fooodhabit);
        disease=findViewById(R.id.disease);

        disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Catsolution.this,Catdisease.class);
                startActivity(intent);
            }
        });
        ownercare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Catsolution.this,Ownercare.class);
                startActivity(intent);
            }
        });

      firstaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Catsolution.this,FirstAid.class);
                startActivity(intent);
            }
        });

        vaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Catsolution.this,Vaccine.class);
                startActivity(intent);
            }
        });

        foodhabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Catsolution.this, Foodhabit.class);
                startActivity(intent);
            }
        });
        dailycare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Catsolution.this, DailycareActivity.class);
                startActivity(intent);
            }
        });

    }
}