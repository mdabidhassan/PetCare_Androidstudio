package com.example.bdpetcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;
    LinearLayout linear,lincat,lingoods;
    InterstitialAd mInterstitialAd;
    Button button;
    Spinner spinner;
    String[] country = {"Barishal", "Dhaka", "Sylhet", "Khulna", "Chattogram", "Rangpur"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }else {

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }
        MobileAds.initialize(MainActivity.this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        loadfull();




        navigationView=findViewById(R.id.nav);

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();

        ft.add(R.id.feame,new MainHome());
        ft.commit();

        // nav.................................................................
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.profile) {



                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.add(R.id.feame, new MainHome());
                    ft.commit();



                }else if (item.getItemId()==R.id.medicine) {

                    FragmentManager fm=getSupportFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.add(R.id.feame,new BUYmedi());
                    ft.commit();


                } else if (item.getItemId()==R.id.Doctor) {

                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.add(R.id.feame, new Catdoctor());
                    ft.commit();
                   // final Handler handler = new Handler();
                   // handler.postDelayed(new Runnable() {
                     //   @Override
                      //  public void run() {
                            //Code here

                      //  }
                    //},1000);

                }else if (item.getItemId()==R.id.FOSTER) {

                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.add(R.id.feame, new Volunteer());
                    ft.commit();


                } else if (item.getItemId()==R.id.ACCOUNT) {

                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.add(R.id.feame, new Account());
                    ft.commit();
                   // Intent intent = new Intent(MainActivity.this,Webv.class);

                   //intent.putExtra("url","https://sites.google.com/view/hellopolicy/home");
                   // startActivity(intent);

                }


                return true;
            }
        });

//nav...end..........................................................................




       // spinner = findViewById(R.id.spiiner);

        //ArrayAdapter<String> adapter=new ArrayAdapter<String>( MainActivity.this, R.layout.resource_item,country
       // );
      //  adapter.setDropDownViewResource(R.layout.resource_item);
      //  spinner.setAdapter(adapter);

        //spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          //  @Override
          //  public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

               // String value= adapterView.getItemAtPosition(i).toString();
                //if (value=="Barishal"){


                            //FragmentManager fm = getSupportFragmentManager();
                          //  FragmentTransaction ft = fm.beginTransaction();
                           // ft.add(R.id.feame, new Dhakadoc());
                           // ft.commit();




                //} else if (value=="Dhaka") {

                           // FragmentManager fm = getSupportFragmentManager();
                          //  FragmentTransaction ft = fm.beginTransaction();
                          //  ft.add(R.id.feame, new Dhakadoc());
                           // ft.commit();


              //  } else if (value=="Sylhet") {


                          //  Toast.makeText(MainActivity.this,"soon will be open",Toast.LENGTH_SHORT).show();


                //} else if (value=="Barishal") {



                            //Toast.makeText(MainActivity.this,"soon will be open",Toast.LENGTH_SHORT).show();


                //}
               // else if (value=="Khulna") {



                           // Toast.makeText(MainActivity.this,"soon will be open",Toast.LENGTH_SHORT).show();


               // }else if (value=="Chattogram") {



                           // Toast.makeText(MainActivity.this,"soon will be open",Toast.LENGTH_SHORT).show();



              //  }
               // else if (value=="Rangpur") {



                           // Toast.makeText(MainActivity.this,"soon will be open",Toast.LENGTH_SHORT).show();



              //  }
           // }

           // @Override
           // public void onNothingSelected(AdapterView<?> adapterView) {

           // }
       // });





            }
    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired
    private long mBackPressed;

    // When user click bakpress button this method is called
    @Override
    public void onBackPressed() {
        // When user press back button

        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        } else {

            Toast.makeText(getBaseContext(), "Press again to exit",
                    Toast.LENGTH_SHORT).show();
            if (mInterstitialAd != null) {
                mInterstitialAd.show(MainActivity.this);
            }
        }

        mBackPressed = System.currentTimeMillis();



    } // end of onBackpressed method

    //#############################################
    private void loadfull(){


        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(MainActivity.this,"ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                            @Override
                            public void onAdClicked() {
                                // Called when a click is recorded for an ad.

                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                // Called when ad is dismissed.
                                // Set the ad reference to null so you don't show the ad a second time.

                                mInterstitialAd = null;



                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                // Called when ad fails to show.

                                mInterstitialAd = null;
                            }

                            @Override
                            public void onAdImpression() {
                                // Called when an impression is recorded for an ad.

                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                // Called when ad is shown.

                            }
                        });


                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        mInterstitialAd = null;
                    }
                });





    }
}