package com.example.bdpetcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.interstitial.InterstitialAd;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class FOSTERLOG extends AppCompatActivity {

    LottieAnimationView lotte,lotteint;
    public String num="";
    AdView addview,add;
    ImageView back;

    InterstitialAd mInterstitialAd;

    ListView pdf;
    HashMap<String,String> hashmap=new HashMap<>();
    ArrayList<HashMap<String,String>> arraylist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fosterlog);

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }else {

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }

        lotteint=findViewById(R.id.lotteinternet);
        lotte=findViewById(R.id.lotte);
        pdf=findViewById(R.id.list);

        back=findViewById(R.id.shoplink);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FOSTERLOG.this,MainActivity.class);
                startActivity(intent);
            }
        });




        String url="https://petcarebd.xyz/petcarebd/foster.json";

        JsonArrayRequest jsnarry =new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                lotteint.setVisibility(View.GONE);
                lotte.setVisibility(View.GONE);
                pdf.setVisibility(View.VISIBLE);
                try {
                    for (int x=0;x<response.length();x++){


                        JSONObject object= response.getJSONObject(x);
                        String name=object.getString("name");
                        String place=object.getString("place");
                        String number=object.getString("number");
                        String service=object.getString("service");

                        //Toast.makeText(getActivity(), ""+number, Toast.LENGTH_SHORT).show();

                        hashmap=new HashMap<>();
                        hashmap.put("name",name);
                        hashmap.put("place",place);
                        hashmap.put("number",number);
                        hashmap.put("service",service);

                        arraylist.add(hashmap);




                    }


                    if(arraylist.size()>0) {
                       Madapter madapter=new Madapter();
                        pdf.setAdapter(madapter);

                    }




                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }



        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                lotteint.setVisibility(View.VISIBLE);
                lotte.setVisibility(View.GONE);
            }
        });


        RequestQueue queue= Volley.newRequestQueue(FOSTERLOG.this);
        queue.add(jsnarry);















    }

    private class Madapter extends BaseAdapter {


        LinearLayout lay2nd;
        ImageView infimage,call;
        TextView name, number, descrip;


        @Override
        public int getCount() {
            return arraylist.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inf = getLayoutInflater();
            View mview = inf.inflate(R.layout.fosterlayout, viewGroup, false);
            name=mview.findViewById(R.id.infname);
            number=mview.findViewById(R.id.infde3);
            descrip=mview.findViewById(R.id.infdetail2);
            infimage=mview.findViewById(R.id.infimage);
            call=mview.findViewById(R.id.call);

            HashMap<String,String> hashmap=arraylist.get(i);
            String Name= hashmap.get("name");
            String Number= hashmap.get("number");
            String Place= hashmap.get("place");
            String service=hashmap.get("service");

            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    num = Number;
                    callPhoneNumber();
                }
            });

            name.setText(Name);
            number.setText(service);
            descrip.setText(Place);

            return mview;
        }

    } @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        if(requestCode == 101)
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                callPhoneNumber();
            }
        }
    }

    public void callPhoneNumber()
    {
        try
        {
            if(Build.VERSION.SDK_INT > 22)
            {
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 101);
                    return;
                }

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+num));
                startActivity(callIntent);

            }
            else {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+num ));
                startActivity(callIntent);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }}