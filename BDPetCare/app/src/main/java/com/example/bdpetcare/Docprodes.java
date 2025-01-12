package com.example.bdpetcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Docprodes extends AppCompatActivity {
    TextView docname,docdetails,docfee;
    ImageView docimage,back;
    Button doclink;

    public String num="";

    public static String Docname ="";
    public static Bitmap bitmap=null;

    public static String Docfee="";

    public static String Doclink ="";
    public static String Docdetails ="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docprodes);
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }else {

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }

        doclink=findViewById(R.id.doclink)   ;
        back=findViewById(R.id.back);

        docimage=findViewById(R.id.docimage);
        docfee=findViewById(R.id.docfee);
       docdetails=findViewById(R.id.docdetails);
        docname=findViewById(R.id.docname);


        docfee.setText(Docfee);

       docdetails.setText(Docdetails);
        docname.setText(Docname);


        if(bitmap!=null)docimage.setImageBitmap(bitmap);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Docprodes.this,MainActivity.class);
                startActivity(intent);
            }
        });



        doclink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = Doclink;

                // Create an Intent with the ACTION_VIEW action
                Intent intent = new Intent(Intent.ACTION_VIEW);

                // Set the data of the Intent to the specified URL
                intent.setData(Uri.parse(url));

                // Start the activity using the created Intent
                startActivity(intent);
            }
        });





    }
}