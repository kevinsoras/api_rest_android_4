package com.example.api_rest_android.Apiutils;

import com.example.api_rest_android.Servicios.Phpservice;
import com.example.api_rest_android.remote.RetrofitClient;

public class apiutilisspring {



    private apiutilisspring(){
    };

    public static final String API_URL = "http://10.0.2.2:8080/api/";

    public static Phpservice getUserService(){
        return RetrofitClient.getClient(API_URL).create(Phpservice.class);
    }



}
