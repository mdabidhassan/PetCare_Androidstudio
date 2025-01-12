package com.example.bdpetcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Video extends AppCompatActivity {

    ListView canadalist;
    HashMap<String, String> hashmap = new HashMap<>();
    ArrayList<HashMap<String, String>> arraylist = new ArrayList<>();
    public String num = "";
    ProgressBar probar;
ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }else {

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }
        back=findViewById(R.id.shoplink);
        canadalist = findViewById(R.id.canadalist);
        probar=findViewById(R.id.probar);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Video.this,MainActivity.class);
                startActivity(intent);
            }
        });

        String url = "https://petcarebd.xyz/petcarebd/video";

        JsonArrayRequest jsnarry = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                probar.setVisibility(View.GONE);

                try {
                    for (int x = 0; x < response.length(); x++) {


                        JSONObject object = response.getJSONObject(x);
                        String name = object.getString("name");
                        String version = object.getString("version");

                        hashmap = new HashMap<>();
                        hashmap.put("name", name);
                        hashmap.put("version", version);
                        arraylist.add(hashmap);


                    }
//
                    Madapter madapter = new Madapter();
                    canadalist.setAdapter(madapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });


        RequestQueue queue = Volley.newRequestQueue(Video.this);
        queue.add(jsnarry);


    }

    //on call...........................................................


    //on call......................................
    private class Madapter extends BaseAdapter {

        LayoutInflater inflater;

        ImageView canadaimage;
        TextView canadatext;
        LinearLayout canadalay;


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
            inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View mview = inflater.inflate(R.layout.inflite, viewGroup, false);
            canadalay = mview.findViewById(R.id.canadalinear);
            canadaimage = mview.findViewById(R.id.canadaimage);
            canadatext = mview.findViewById(R.id.canadatext);


            HashMap<String, String> hashmap = arraylist.get(i);
            String Name = hashmap.get("name");
            String Version = hashmap.get("version");
            String image = "https://img.youtube.com/vi/" + Version + "/0.jpg";


            Picasso.get()
                    .load(image)
                    .placeholder(R.drawable.catcare).into(canadaimage);


            canadatext.setText(Name);


            canadalay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ALLvideo.video = "https://www.youtube.com/embed/" + Version;


                    Intent intent = new Intent(Video.this, ALLvideo.class);
                    startActivity(intent);
                }
            });


            return mview;


        }

    }
}