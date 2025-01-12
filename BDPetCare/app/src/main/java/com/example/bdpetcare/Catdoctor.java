package com.example.bdpetcare;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
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


public class Catdoctor extends Fragment {

    Button button;
    Spinner spinner;
    String[] country = {"Barishal", "Dhaka", "Sylhet", "Khulna", "Chattogram", "Rangpur"};
    LottieAnimationView lotte,lotteint;
    ArrayList<HashMap<String,String>> array=new ArrayList<>();
    HashMap<String ,String>hashmap;
    NestedScrollView nested;

    ProgressBar blankprobar;
    RecyclerView recyclerView;
    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String DIALOG_SHOWN_KEY = "dialogShown";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_catdoctor, container, false);
        if (container != null) {
            container.removeAllViews();

        }


        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            requireActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            requireActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            requireActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            requireActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);

        }else {

            requireActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }


        SharedPreferences preferences =getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        boolean dialogShown = preferences.getBoolean(DIALOG_SHOWN_KEY, false);

        lotteint=view.findViewById(R.id.lotteinternet);
nested=view.findViewById(R.id.nested);
        recyclerView=view.findViewById(R.id.recycle2);
      lotte=view.findViewById(R.id.lotte);

        if (!dialogShown) {
            // Show the dialog
            showDialog();

            // Update SharedPreferences to indicate that the dialog has been shown
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(DIALOG_SHOWN_KEY, true);
            editor.apply();
        }





        String url="https://petcarebd.xyz/petcarebd/fulldoc.php";

        JsonArrayRequest jsnarry =new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
lotteint.setVisibility(View.GONE);
                lotte.setVisibility(View.GONE);
                nested.setVisibility(View.VISIBLE);
                try {
                    for (int x=0;x<response.length();x++){


                        JSONObject object= response.getJSONObject(x);
                        String name=object.getString("name");
                        String docimage=object.getString("docimage");
                        String docfee=object.getString("docfee");
                        String docdetails=object.getString("docdetails");
                        String doclink=object.getString("doclink");
                        String active=object.getString("active");
                        String category=object.getString("category");



                        hashmap=new HashMap<>();
                        hashmap.put("name",name);
                        hashmap.put("docimage",docimage);
                        hashmap.put("docfee",docfee);
                        hashmap.put("docdetails",docdetails);
                        hashmap.put("doclink",doclink);
                        hashmap.put("category",category);
                        hashmap.put("active",active);
                        array.add(hashmap);




                    }


                    if(array.size()>0) {
                      adpter ad=new adpter();
                        recyclerView.setAdapter(ad);
                        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity().getApplication(),2);
                        recyclerView.setLayoutManager(gridLayoutManager);

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





        //............................................................................................//



        return view;
    }



    private class adpter extends RecyclerView.Adapter<adpter.newholder>{




        private class newholder extends RecyclerView.ViewHolder{


            ImageView brandimage;
            TextView name,fee,category,active;

            public newholder(@NonNull View itemView) {

                super(itemView);

                name=itemView.findViewById(R.id.name);
                brandimage=itemView.findViewById(R.id.image);
                fee=itemView.findViewById(R.id.fee);
               category=itemView.findViewById(R.id.catagory);
                active=itemView.findViewById(R.id.active);


            }
        }



        @NonNull
        @Override
        public adpter.newholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



            LayoutInflater inf = getLayoutInflater();
            View hey = inf.inflate(R.layout.layoutdoctor,parent,false );


            return new adpter.newholder(hey);
        }

        @Override
        public void onBindViewHolder(@NonNull adpter.newholder holder, int position) {



            HashMap<String, String> hashmap = array.get(position);
            String nname = hashmap.get("name");
            String ndocimage = hashmap.get("docimage");
            String ndocfee =  hashmap.get("docfee");
            String ndocdetails =hashmap.get("docdetails");
            String ndoclink =hashmap.get("doclink");
            String ncategory =hashmap.get("category");
            String nactive =hashmap.get("active");



            if  (nactive.equals("OFFLINE")) {
                // Change the button color to red (or any color you prefer)
                holder.active.setBackgroundColor(getResources().getColor(R.color.your_color_resourcew));
            } else if (nactive.equals("ONLINE") ){
                holder.active.setBackgroundColor(getResources().getColor(R.color.your_color_resource));
            }


            Picasso.get()

                    .load(ndocimage)
                    .placeholder(R.drawable.catcare)
                    .error(R.drawable.cleancat).into(holder.brandimage);

            holder.name.setText(nname);
            holder.fee.setText(ndocfee);
            holder.category.setText(ncategory);


            holder.active.setText(nactive);

            holder.brandimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Docprodes.Docname=nname;
                    Bitmap mbitmap= ((BitmapDrawable)holder.brandimage.getDrawable()).getBitmap();
                    Docprodes.bitmap=mbitmap;
                  Docprodes.Docfee= ndocfee;
                    Docprodes.Doclink=ndoclink;
                    Docprodes.Docdetails=ndocdetails;





                    startActivity(new Intent(getActivity().getApplication(),Docprodes.class));
                }
            });




        }

        @Override
        public int getItemCount() {
            return array.size();
        }



    }
    private void showDialog() {


        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder
                .setTitle("MESSAGE")
                .setMessage("আপনাদের সুবিধার্থে  শিঘ্রই আমরা রেজিস্ট্রারড ভেট হায়ার করবো। তবে আপনাদের পেটদের সাময়িক সমস্যায় পাশে থাকার জন্য আমাদের ইনটার্ন এবং ভলেন্টিয়াররা একটিভ রয়েছেন। যেকোন প্রয়োজনে হতাশ না হয়ে তাদের সাথে যোগাযোগ করুন")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Do something when OK is clicked

                    }
                });

        // Create and show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}