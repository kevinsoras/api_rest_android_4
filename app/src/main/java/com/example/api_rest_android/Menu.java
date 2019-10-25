package com.example.api_rest_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {

    private ImageView python;
    private ImageView nodejs;
    private ImageView php;
    private ImageView spring;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        python=(ImageView)findViewById(R.id.imageViewpython);
        nodejs=(ImageView)findViewById(R.id.imageViewnodejs);
        php=(ImageView)findViewById(R.id.imageViewphp);
        spring=(ImageView)findViewById(R.id.imageViewspring);


        spring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pas=new Intent(getApplicationContext(),MainActivity.class);
                pas.putExtra("numeroprograma","3");
                startActivity(pas);

            }
        });

        nodejs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pas=new Intent(getApplicationContext(),MainActivity.class);
                pas.putExtra("numeroprograma","2");
                startActivity(pas);

            }
        });

        //numeroprograma=1 es php
        //numeroprograma=2 es nodejs
        //numeroprograma=3 es spring
        //numeroprograma=4 es python
        php.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pas=new Intent(getApplicationContext(),MainActivity.class);
                pas.putExtra("numeroprograma","1");
                startActivity(pas);

            }
        });
        python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pas=new Intent(getApplicationContext(),MainActivity.class);
                pas.putExtra("numeroprograma","4");
                startActivity(pas);

            }
        });

    }
}
