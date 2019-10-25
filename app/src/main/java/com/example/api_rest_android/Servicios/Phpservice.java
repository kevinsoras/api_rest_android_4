package com.example.api_rest_android.Servicios;

import com.example.api_rest_android.Entidades.usuario;
import com.example.api_rest_android.Modelo.Modeloservice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Phpservice {


    @GET("read.php/")
    Call<List<usuario>> getusers();

    @POST("create.php/")
    Call<usuario> addusers(@Body usuario user);

    @POST("update.php/")
    Call<usuario> editusers(@Body usuario user);

    @POST("delete.php/")
    Call<usuario> deleteuser(@Body usuario user);

//spring


    
    @GET("usuarios/")
    Call<List<usuario>> getusersspring();

    @POST("usuarios/")
    Call<usuario> addusersspring(@Body usuario user);

    @PUT("usuarios/{id_usuario}")
    Call<usuario> editusersspring(@Path("id_usuario") int id_usuario,@Body usuario user);

    @DELETE("usuarios/{id_usuario}")
    Call<usuario> deleteuserspring(@Path("id_usuario") int id_usuario);

//    @PUT("update/{id}")
    //  Call<usuario> updateusero(@Path("id") int id,@Body usuario user)





    //node js
    @GET("/")
    Call<List<usuario>> getusersnodejs();

    @POST("/")
    Call<usuario> addusersnodejs(@Body usuario user);

    @PUT("/{id_usuario}")
    Call<usuario> editusersnodejs(@Path("id_usuario") int id_usuario,@Body usuario user);

    @DELETE("/{id_usuario}")
    Call<usuario> deleteusernodejs(@Path("id_usuario") int id_usuario);

    //python
    @GET("getAll/")
    Call<List<usuario>> getuserspython();

    @POST("addUser/")
    Call<usuario> adduserspython(@Body usuario user);

    @PUT("editUser/{id_usuario}")
    Call<usuario> edituserspython(@Path("id_usuario") int id_usuario,@Body usuario user);

    @DELETE("deleteUser/{id_usuario}")
    Call<usuario> deleteuserpython(@Path("id_usuario") int id_usuario);

//    @PUT("update/{id}")
    //  Call<usuario> updateusero(@Path("id") int id,@Body usuario user)




    //ejemplo si viene por arriba
//    @PUT("update/{id}")
  //  Call<usuario> updateusero(@Path("id") int id,@Body usuario user)

}
