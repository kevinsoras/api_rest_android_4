package com.example.api_rest_android.Modelo;

import com.example.api_rest_android.Entidades.usuario;

import java.util.ArrayList;

public class Modeloservice {

    private ArrayList<usuario> usuarioresultado;

    public ArrayList<usuario> getUsuarioresultado() {
        return usuarioresultado;
    }

    public void setUsuarioresultado(ArrayList<usuario> usuarioresultado) {
        this.usuarioresultado = usuarioresultado;
    }
}
