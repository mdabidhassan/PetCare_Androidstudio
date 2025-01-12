package com.example.bdpetcare;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;


public class MainHome extends Fragment {

    CardView dailycare,foodhabit,disease,vaccine,firstaid,ownercare,videos,others;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_main_home, container, false);
        if (container != null) {
            container.removeAllViews();

        }
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            requireActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            requireActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            requireActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
           requireActivity(). getWindow().setStatusBarColor(Color.TRANSPARENT);

        }else {

            requireActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }
        videos=view.findViewById(R.id.videos);
        others=view.findViewById(R.id.others);
        ownercare=view.findViewById(R.id.ownercare);
        vaccine=view.findViewById(R.id.vaccine);
        firstaid=view.findViewById(R.id.firstaid);
        dailycare=view.findViewById(R.id.dailycare);
        foodhabit=view.findViewById(R.id.fooodhabit);
        disease=view.findViewById(R.id.disease);


        disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getActivity().getApplication(),Catdisease.class);
                startActivity(intent);
            }
        });
        ownercare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(getActivity().getApplication(),Ownercare.class);
                startActivity(intent);
            }
        });

        firstaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getActivity().getApplication(),FirstAid.class);
                startActivity(intent);
            }
        });

        vaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getActivity().getApplication(),Vaccine.class);
                startActivity(intent);
            }
        });

        foodhabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getActivity().getApplication(), Foodhabit.class);
                startActivity(intent);
            }
        });
        dailycare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getActivity().getApplication(), DailycareActivity.class);
                startActivity(intent);
            }
        });


        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(getActivity().getApplication(),Others.class);
                startActivity(intent);
            }
        });
     videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getActivity().getApplication(),Video.class);
                startActivity(intent);
            }
        });



        return view;

    }


}