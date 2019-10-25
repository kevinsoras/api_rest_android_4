package com.example.api_rest_android.Adaptadores.Adaptadorphp;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.api_rest_android.R;

public class Adaptadordialog extends AppCompatDialogFragment {

static private String nom="";
static private String apell="";
    static private String dnis="";

    private EditText nombre;
    private EditText apellido;
    private EditText editTextdni;
private int tipo=0;
    private datosalida listener;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());

        LayoutInflater inflater= getActivity().getLayoutInflater();
        final View view=inflater.inflate(R.layout.listitem,null);

        builder.setView(view).setTitle("Datos usuario").setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                String nombres=nombre.getText().toString();
                String apellidos=apellido.getText().toString();
                String dnis=editTextdni.getText().toString();

                listener.obtener(nombres,apellidos,dnis);

            }
        });

        nombre=view.findViewById(R.id.edtnombre);
        apellido=view.findViewById(R.id.edtapellido);
        editTextdni=view.findViewById(R.id.edtdni);

        nombre.setText(nom);
        apellido.setText(apell);
        editTextdni.setText(dnis);

        if(tipo==0){
            editTextdni.setVisibility(View.GONE);

        }else {
        }

        return builder.create();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener=(datosalida) context;

        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+"deberias implementar exampledialog");
        }
    }

    public interface  datosalida{

        void obtener(String nombre,String apellido,String dni);
    }

    public void datosentrada(String nombre,String apellido,String dni,int tipo){
this.tipo=tipo;
nom=nombre;
        apell=apellido;
        dnis=dni;
        Log.e("PRUEBA","LLEGADNI"+dnis);

    }



}
