package com.example.api_rest_android.Apiutils;

import com.example.api_rest_android.Servicios.Phpservice;
import com.example.api_rest_android.remote.RetrofitClient;

public class apiutilisnodejs {




    private apiutilisnodejs(){
    };

    public static final String API_URL = "http://192.168.243.2:3000";

    public static Phpservice getUserService(){
        return RetrofitClient.getClient(API_URL).create(Phpservice.class);
    }



}
