package com.example.bdpetcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button button;
Spinner spinner;
    String[] country = {"India", "USA", "Japan", "Singapore", "China", "Other"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spinner = findViewById(R.id.spiiner);
        button=findViewById(R.id.button);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>( MainActivity2.this, android.R.layout.simple_spinner_dropdown_item,country
        );
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String value= adapterView.getItemAtPosition(i).toString();
        Toast.makeText(MainActivity2.this,value,Toast.LENGTH_SHORT).show();
        if (value=="India"){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent apple = new Intent(MainActivity2.this, Others.class);
                    startActivity(apple);
                }
            });


        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
});


    }
}