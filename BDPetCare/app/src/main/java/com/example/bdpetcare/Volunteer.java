package com.example.bdpetcare;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


public class Volunteer extends Fragment {
    LottieAnimationView lotte,lotteint;
    public String num="";
    AdView addview,add;

    InterstitialAd mInterstitialAd;

    ListView pdf;
    HashMap<String,String> hashmap=new HashMap<>();
    ArrayList<HashMap<String,String>> arraylist=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_volunteer, container, false);
        if(container!=null){
            container.removeAllViews();
        }

        lotteint=view.findViewById(R.id.lotteinternet);
        lotte=view.findViewById(R.id.lotte);

        pdf=view.findViewById(R.id.list);



        String url="https://petcarebd.xyz/petcarebd/volunteer.json";

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


                        //Toast.makeText(getActivity(), ""+number, Toast.LENGTH_SHORT).show();

                        hashmap=new HashMap<>();
                        hashmap.put("name",name);
                        hashmap.put("place",place);
                        hashmap.put("number",number);


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


        RequestQueue queue= Volley.newRequestQueue(getActivity().getApplicationContext());
        queue.add(jsnarry);












        return  view;

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
            View mview = inf.inflate(R.layout.volunteer, viewGroup, false);
            name=mview.findViewById(R.id.infname);
            descrip=mview.findViewById(R.id.division);
            call=mview.findViewById(R.id.call);

            HashMap<String,String> hashmap=arraylist.get(i);
            String Name= hashmap.get("name");
            String Number= hashmap.get("number");
            String Place= hashmap.get("place");


            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    num = Number;
                    callPhoneNumber();
                }
            });

            name.setText(Name);
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
                if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, 101);
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