package com.example.api_rest_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class menupropuesta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menupropuesta);
        Intent asd=new Intent(getApplicationContext(),Menu.class);
        startActivity(asd);

    }
}
