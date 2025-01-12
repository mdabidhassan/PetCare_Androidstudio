package com.example.bdpetcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
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
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Information extends AppCompatActivity {
    public String num="";
    AdView addview,add;
    LottieAnimationView lotte,lotteint;
    InterstitialAd mInterstitialAd;
ImageView back;
    ListView pdf;
    HashMap<String,String> hashmap=new HashMap<>();
    ArrayList<HashMap<String,String>> arraylist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

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
               Intent intent= new Intent(Information.this,MainActivity.class);
               startActivity(intent);
           }
       });



        String url="https://petcarebd.xyz/petcarebd/information.json";

        JsonArrayRequest jsnarry =new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                lotteint.setVisibility(View.GONE);
                lotte.setVisibility(View.GONE);
                pdf.setVisibility(View.VISIBLE);
                try {
                    for (int x=0;x<response.length();x++){


                        JSONObject object= response.getJSONObject(x);
                        String info=object.getString("info");
                        String image=object.getString("image");
                        String title=object.getString("title");


                        //Toast.makeText(getActivity(), ""+number, Toast.LENGTH_SHORT).show();

                        hashmap=new HashMap<>();
                        hashmap.put("info",info);
                        hashmap.put("image",image);
                        hashmap.put("title",title);
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


        RequestQueue queue= Volley.newRequestQueue(Information.this);
        queue.add(jsnarry);




    }

    private class Madapter extends BaseAdapter {

CardView cardview;
        LinearLayout lay2nd;
        ImageView infimage,call,image;
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
            View mview = inf.inflate(R.layout.informationlayout, viewGroup, false);
            name=mview.findViewById(R.id.info);
            image=mview.findViewById(R.id.image);
            descrip=mview.findViewById(R.id.title);
           cardview=mview.findViewById(R.id.activity);


            HashMap<String,String> hashmap=arraylist.get(i);
            String ninfo= hashmap.get("info");
            String ntitle= hashmap.get("title");
            String nimage= hashmap.get("image");

            Picasso.get()
                    .load(nimage)
                    .placeholder(R.drawable.cat)
                    .error(R.drawable.cat).into(image);

            name.setText(ninfo);

            descrip.setText(ntitle);


           cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    INFOPRODES.TITLE=ninfo;
                    Bitmap mbitmap= ((BitmapDrawable)image.getDrawable()).getBitmap();
                   INFOPRODES.bitmap=mbitmap;
                    INFOPRODES.INFO =ninfo;

                    Intent intent=new Intent(Information.this,INFOPRODES.class);
                    startActivity(intent);
                }
            });





            return mview;
        }




    }}