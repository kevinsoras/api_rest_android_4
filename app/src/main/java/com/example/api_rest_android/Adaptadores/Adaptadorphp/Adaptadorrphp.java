package com.example.api_rest_android.Adaptadores.Adaptadorphp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.api_rest_android.Entidades.usuario;
import com.example.api_rest_android.R;

import java.util.ArrayList;

public class Adaptadorrphp extends BaseAdapter {

    ArrayList<usuario> ingre=new ArrayList<usuario>();
    Context c;


    public Adaptadorrphp(Context c,ArrayList<usuario> ingre){

        this.c=c;

        this.ingre=ingre;



    }


    @Override
    public int getCount() {
        return ingre.size();
    }

    @Override
    public Object getItem(int i) {
        return ingre.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater =(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row= inflater.inflate(R.layout.listview_item,null);

        TextView tvnombre= (TextView)row.findViewById(R.id.textviewnombre);
        TextView tvapellido= (TextView)row.findViewById(R.id.textviewapellido);
        TextView tvdni= (TextView)row.findViewById(R.id.textviewdni);

        tvnombre.setText(ingre.get(i).getNombres());
        tvapellido.setText(ingre.get(i).getApellidos());
        tvdni.setText(String.valueOf(ingre.get(i).getDni()));



        return row;

    }


}
