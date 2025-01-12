package com.example.bdpetcare;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.airbnb.lottie.Lottie;
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


public class BUYmedi extends Fragment {
  LottieAnimationView lotte,lotteint;
    NestedScrollView nested;
    ArrayList<HashMap<String,String>> array=new ArrayList<>();
    ArrayList<HashMap<String,String>> array2=new ArrayList<>();
    ArrayList<HashMap<String,String>> array3=new ArrayList<>();
    HashMap<String ,String>hashmap;


    Button button;
    RecyclerView    recyclerViewfood,recyclerViewmedi,recyclerViewacce;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_b_u_ymedi, container, false);

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

   lotte=view.findViewById(R.id.lotte);
        lotteint=view.findViewById(R.id.lotteinternet);
       nested=view.findViewById(R.id.nested);

        recyclerViewfood=view.findViewById(R.id.recyclefood);
        recyclerViewmedi=view.findViewById(R.id.recyclemedi);
        recyclerViewacce=view.findViewById(R.id.recycleacce);



        String url="https://petcarebd.xyz/petcarebd/food.json";

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
                        String version=object.getString("image");
                        String details=object.getString("details");
                        String shoplink=object.getString("shoplink");
                        String price=object.getString("price");
                        String offer=object.getString("discount");


                        hashmap=new HashMap<>();
                        hashmap.put("name",name);
                        hashmap.put("version",version);
                        hashmap.put("details",details);
                        hashmap.put("Shoplink",shoplink);
                        hashmap.put("offer",offer);
                        hashmap.put("price",price);
                        array.add(hashmap);




                    }


                    if(array.size()>0) {
                        adpter ad=new adpter();
                        recyclerViewfood.setAdapter(ad);
                        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity().getApplication(),3);
                        recyclerViewfood.setLayoutManager(gridLayoutManager);

                    }




                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }



        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                lotte.setVisibility(View.VISIBLE);
                lotteint.setVisibility(View.VISIBLE);


            }
        });

//..2.................................................................................................................//
        RequestQueue queue= Volley.newRequestQueue(getActivity().getApplicationContext());
        queue.add(jsnarry);


        String url2="https://petcarebd.xyz/petcarebd/medecine.json";

        JsonArrayRequest jsnarrymedi =new JsonArrayRequest(Request.Method.GET, url2, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
               lotte.setVisibility(View.GONE);
               lotteint.setVisibility(View.GONE);
                try {
                    for (int x=0;x<response.length();x++){


                        JSONObject object= response.getJSONObject(x);
                        String name=object.getString("name");
                        String version=object.getString("image");
                        String details=object.getString("details");
                        String shoplink=object.getString("shoplink");
                        String price=object.getString("price");
                        String offer=object.getString("discount");


                        hashmap=new HashMap<>();
                        hashmap.put("name",name);
                        hashmap.put("version",version);
                        hashmap.put("details",details);
                        hashmap.put("Shoplink",shoplink);
                        hashmap.put("offer",offer);
                        hashmap.put("price",price);
                        array2.add(hashmap);




                    }



                    if(array2.size()>0) {
                        adptermedi adm=new adptermedi();
                        recyclerViewmedi.setAdapter(adm);
                        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity().getApplication(),3);
                        recyclerViewmedi.setLayoutManager(gridLayoutManager);

                    }




                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }



        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                lotte.setVisibility(View.GONE);
                lotteint.setVisibility(View.VISIBLE);

            }
        });



        queue.add(jsnarrymedi);

//...............................................................................//

        String urlacce="https://petcarebd.xyz/petcarebd/accesories.json";

        JsonArrayRequest jsnarryacce =new JsonArrayRequest(Request.Method.GET, urlacce, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
               lotte.setVisibility(View.GONE);
                lotteint.setVisibility(View.GONE);
                try {
                    for (int x=0;x<response.length();x++){


                        JSONObject object= response.getJSONObject(x);
                        String name=object.getString("name");
                        String version=object.getString("image");
                        String details=object.getString("details");
                        String shoplink=object.getString("shoplink");
                        String price=object.getString("price");
                        String offer=object.getString("discount");


                        hashmap=new HashMap<>();
                        hashmap.put("name",name);
                        hashmap.put("version",version);
                        hashmap.put("details",details);
                        hashmap.put("Shoplink",shoplink);
                        hashmap.put("offer",offer);
                        hashmap.put("price",price);
                        array3.add(hashmap);




                    }


                    if(array3.size()>0) {
                        adpteracce adme=new adpteracce();
                        recyclerViewacce.setAdapter(adme);
                        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity().getApplication(),3);
                        recyclerViewacce.setLayoutManager(gridLayoutManager);

                    }




                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }



        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               lotte.setVisibility(View.GONE);
                lotteint.setVisibility(View.VISIBLE);

            }
        });



        queue.add(jsnarryacce);




        return view;



    }

//,...3........................................................................//

    private class adpter extends RecyclerView.Adapter<adpter.newholder>{




        private class newholder extends RecyclerView.ViewHolder{


            ImageView brandimage;
            TextView price,offer, name,details;

            public newholder(@NonNull View itemView) {

                super(itemView);

                name=itemView.findViewById(R.id.name);
                brandimage=itemView.findViewById(R.id.image);
                details=itemView.findViewById(R.id.details);
                price=itemView.findViewById(R.id.price);
                offer=itemView.findViewById(R.id.discount);

            }
        }



        @NonNull
        @Override
        public adpter.newholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



            LayoutInflater inf = getLayoutInflater();
            View hey = inf.inflate(R.layout.itemlist,parent,false );


            return new adpter.newholder(hey);
        }

        @Override
        public void onBindViewHolder(@NonNull adpter.newholder holder, int position) {



            HashMap<String, String> hashmap = array.get(position);
            String nname = hashmap.get("name");
            String nimage = hashmap.get("version");
            String ndetails = hashmap.get("details");
            String nprice= hashmap.get("price");
            String offer=hashmap.get("offer");
            String code=hashmap.get("code");
            String shoplink=hashmap.get("Shoplink");
            String stock=hashmap.get("stock");


            Picasso.get()

                    .load(nimage)
                    .placeholder(R.drawable.catcare)
                    .error(R.drawable.cleancat).into(holder.brandimage);

            holder.name.setText(nname);
            holder.details.setText(ndetails);
            holder.price.setText(nprice);
            holder.offer.setText(offer);

            holder.brandimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                 Prodes.TITLE=nname;
                    Bitmap mbitmap= ((BitmapDrawable)holder.brandimage.getDrawable()).getBitmap();
                  Prodes.bitmap=mbitmap;
                   Prodes.PROCODE= code;
                  Prodes.SHOPlink=shoplink;
                   Prodes.STOCK=stock;
                    Prodes.OFFERN=offer;





                    startActivity(new Intent(getActivity().getApplication(),Prodes.class));
                }
            });




        }

        @Override
        public int getItemCount() {
            return array.size();
        }



    }
    //..............................................................................//1

    private class adptermedi extends RecyclerView.Adapter<adptermedi.newholder>{




        private class newholder extends RecyclerView.ViewHolder{


            ImageView brandimage;
            TextView price,offer, name,details;

            public newholder(@NonNull View itemView) {

                super(itemView);

                name=itemView.findViewById(R.id.name);
                brandimage=itemView.findViewById(R.id.image);
                details=itemView.findViewById(R.id.details);
                price=itemView.findViewById(R.id.price);
                offer=itemView.findViewById(R.id.discount);

            }
        }



        @NonNull
        @Override
        public adptermedi.newholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



            LayoutInflater inf = getLayoutInflater();
            View hey = inf.inflate(R.layout.itemlist,parent,false );


            return new adptermedi.newholder(hey);
        }

        @Override
        public void onBindViewHolder(@NonNull adptermedi.newholder holder, int position) {



            HashMap<String, String> hashmap = array2.get(position);
            String nname = hashmap.get("name");
            String nimage = hashmap.get("version");
            String ndetails = hashmap.get("details");
            String nprice= hashmap.get("price");
            String offer=hashmap.get("offer");
            String code=hashmap.get("code");
            String shoplink=hashmap.get("Shoplink");
            String stock=hashmap.get("stock");


            Picasso.get()

                    .load(nimage)
                    .placeholder(R.drawable.catcare)
                    .error(R.drawable.cleancat).into(holder.brandimage);

            holder.name.setText(nname);
            holder.details.setText(ndetails);
            holder.price.setText(nprice);
            holder.offer.setText(offer);

            holder.brandimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Prodes.TITLE=nname;
                    Bitmap mbitmap= ((BitmapDrawable)holder.brandimage.getDrawable()).getBitmap();
                    Prodes.bitmap=mbitmap;
                    Prodes.PROCODE= code;
                    Prodes.SHOPlink=shoplink;
                    Prodes.STOCK=stock;
                    Prodes.OFFERN=offer;





                    startActivity(new Intent(getActivity().getApplication(),Prodes.class));
                }
            });




        }

        @Override
        public int getItemCount() {
            return array2.size();
        }



    }

//...............................................................................//2

    private class adpteracce extends RecyclerView.Adapter<adpteracce.newholder>{




        private class newholder extends RecyclerView.ViewHolder{


            ImageView brandimage;
            TextView price,offer, name,details;

            public newholder(@NonNull View itemView) {

                super(itemView);

                name=itemView.findViewById(R.id.name);
                brandimage=itemView.findViewById(R.id.image);
                details=itemView.findViewById(R.id.details);
                price=itemView.findViewById(R.id.price);
                offer=itemView.findViewById(R.id.discount);

            }
        }



        @NonNull
        @Override
        public adpteracce.newholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



            LayoutInflater inf = getLayoutInflater();
            View hey = inf.inflate(R.layout.itemlist,parent,false );


            return new adpteracce.newholder(hey);
        }

        @Override
        public void onBindViewHolder(@NonNull adpteracce.newholder holder, int position) {



            HashMap<String, String> hashmap = array3.get(position);
            String nname = hashmap.get("name");
            String nimage = hashmap.get("version");
            String ndetails = hashmap.get("details");
            String nprice= hashmap.get("price");
            String offer=hashmap.get("offer");
            String code=hashmap.get("code");
            String shoplink=hashmap.get("Shoplink");
            String stock=hashmap.get("stock");


            Picasso.get()

                    .load(nimage)
                    .placeholder(R.drawable.catcare)
                    .error(R.drawable.cleancat).into(holder.brandimage);

            holder.name.setText(nname);
            holder.details.setText(ndetails);
            holder.price.setText(nprice);
            holder.offer.setText(offer);

            holder.brandimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Prodes.TITLE=nname;
                    Bitmap mbitmap= ((BitmapDrawable)holder.brandimage.getDrawable()).getBitmap();
                    Prodes.bitmap=mbitmap;
                    Prodes.PROCODE= code;
                    Prodes.SHOPlink=shoplink;
                    Prodes.STOCK=stock;
                    Prodes.OFFERN=offer;





                    startActivity(new Intent(getActivity().getApplication(),Prodes.class));
                }
            });




        }

        @Override
        public int getItemCount() {
            return array3.size();
        }



    }


}