package com.example.bdpetcare;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class Account extends Fragment {
    LinearLayout privacy,information,foster,wild;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    View view =    inflater.inflate(R.layout.fragment_account, container, false);
        if (container != null) {
            container.removeAllViews();

        }
        privacy=view.findViewById(R.id.privacy);
       information=view.findViewById(R.id.information);
       foster=view.findViewById(R.id.foster);
        wild=view.findViewById(R.id.wild);



        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(),Webv.class);

                intent.putExtra("url","https://sites.google.com/view/bdpetcarepolicy/home");
                startActivity(intent);

            }
        });

       information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(),Information.class);

                startActivity(intent);

            }
        });


        foster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(),FOSTERLOG.class);

                startActivity(intent);

            }
        });


        wild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(),Wlccu.class);

                startActivity(intent);

            }
        });

        return view;
    }
}