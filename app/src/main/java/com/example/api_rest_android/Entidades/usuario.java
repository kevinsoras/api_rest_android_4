package com.example.api_rest_android.Entidades;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class usuario {
    @SerializedName("id_usuario")
    @Expose
    private int id_usuario;
    @SerializedName("nombres")
    @Expose
    private String nombres;
    @SerializedName("apellidos")
    @Expose
    private String apellidos;
    @SerializedName("dni")
    @Expose
    private int dni;





    public usuario() {
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
}

