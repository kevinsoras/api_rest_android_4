package com.example.api_rest_android.Apiutils;

import com.example.api_rest_android.Servicios.Phpservice;
import com.example.api_rest_android.remote.RetrofitClient;

public class apiutilsphp {



    private apiutilsphp(){
    };

    public static final String API_URL = "http://10.0.2.2/rest-php-android/api/usuario_metodos/";

    public static Phpservice getUserService(){
        return RetrofitClient.getClient(API_URL).create(Phpservice.class);
    }
}
