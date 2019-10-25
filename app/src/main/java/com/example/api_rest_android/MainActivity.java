package com.example.api_rest_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.api_rest_android.Adaptadores.Adaptadorphp.Adaptadordialog;
import com.example.api_rest_android.Adaptadores.Adaptadorphp.Adaptadorrphp;
import com.example.api_rest_android.Apiutils.apiutilisnodejs;
import com.example.api_rest_android.Apiutils.apiutilispython;
import com.example.api_rest_android.Apiutils.apiutilisspring;
import com.example.api_rest_android.Apiutils.apiutilsphp;
import com.example.api_rest_android.Entidades.usuario;
import com.example.api_rest_android.Servicios.Phpservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements Adaptadordialog.datosalida{
    private ListView listauser;
    private Button btnagregar;
    private TextView sal;
    private Retrofit retrofit;
    private Adaptadorrphp adaptadorrphp;
    static int numeroprograma=0;
    //numeroprograma=1 es php
    //    //numeroprograma=2 es nodejs
    //    //numeroprograma=3 es spring
    //    //numeroprograma=4 es python
    private String nom;
    private String apell;
    private String dni="0";
    private String nomdefinitivo;
    private String apellidodefinitivo;
    private String dnidefinitivo;
    private int tipodeenvio=0;
    private String id_usuarioglobal="";
    static List<usuario> list = new ArrayList<usuario>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent pru=new Intent(getApplicationContext(),MainActivity.class);
        listauser=(ListView) findViewById(R.id.listar_usuario);
        btnagregar=(Button) findViewById(R.id.agregarusuario);
        numeroprograma= Integer.parseInt(getIntent().getStringExtra("numeroprograma"));
        Log.e("PRUEBA","NUMERO DE PRUEBA"+numeroprograma);
        Log.e("PRUEBA", "antes de entrar");

        listarusuario();

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirdialogo();


            }
        });


        listauser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                id_usuarioglobal=String.valueOf(list.get(i).getId_usuario());
                nom=list.get(i).getNombres();
                apell=list.get(i).getApellidos();
                dni=String.valueOf(list.get(i).getDni());
                Log.e("PRUEBA","DNI"+dni);
                abrirdialogoentrada();
            }
        });

        listauser.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                 final int posicion=i;

                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Espera!")
                        .setMessage("¿Deseas eliminar este usuario ?")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                usuario us=new usuario();
                                us.setId_usuario(list.get(posicion).getId_usuario());
                                us.setNombres(list.get(posicion).getNombres());
                                us.setApellidos(list.get(posicion).getApellidos());
                                us.setDni(list.get(posicion).getDni());

                                deleteUser(us);
                                listarusuario();

                                dialogInterface.dismiss();

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });


                builder.create();
                builder.show();






            return true;
            }
        });





    }
    public void listarusuario(){
        switch (numeroprograma){
            case 1:
                Phpservice phpservice;

                phpservice= null;
                phpservice= apiutilsphp.getUserService();

                Call<List<usuario>> call=phpservice.getusers();

                call.enqueue(new Callback<List<usuario>>() {
                    @Override
                    public void onResponse(Call<List<usuario>> call, Response<List<usuario>> response) {

                        if (response.isSuccessful()){
                            ArrayList<usuario> user=new ArrayList<usuario>();
                            list =response.body();
                            user=(ArrayList<usuario>) list;
                            Log.e("PRUEBA", "ya listo"+list.size());
                            Log.e("PRUEBA", "ya listo"+user.size());

                            adaptadorrphp = new Adaptadorrphp(MainActivity.this,user);
                            listauser.setAdapter(adaptadorrphp);


                        }
                    }

                    @Override
                    public void onFailure(Call<List<usuario>> call, Throwable t) {
                        Log.e("PRUEBA", "ERROR"+t.getMessage());

                    }
                });

                break;
            case 2:
                Phpservice phpservice2;

                phpservice2= apiutilisnodejs.getUserService();

                Call<List<usuario>> call1=phpservice2.getusersnodejs();

                call1.enqueue(new Callback<List<usuario>>() {
                    @Override
                    public void onResponse(Call<List<usuario>> call1, Response<List<usuario>> response) {

                        if (response.isSuccessful()){
                            ArrayList<usuario> user=new ArrayList<usuario>();
                            list =response.body();
                            user=(ArrayList<usuario>) list;
                            Log.e("PRUEBA", "ya listo"+list.size());
                            Log.e("PRUEBA", "ya listo"+user.size());

                            adaptadorrphp = new Adaptadorrphp(MainActivity.this,user);
                            listauser.setAdapter(adaptadorrphp);


                        }
                    }

                    @Override
                    public void onFailure(Call<List<usuario>> call1, Throwable t) {
                        Log.e("PRUEBA", "ERROR node js"+t.getMessage());

                    }
                });




                break;
            case 3:

                Log.e("PRUEBA","ENTRA SPRING");
                Phpservice phpservices;

                phpservices= null;

                phpservices= apiutilisspring.getUserService();

                Call<List<usuario>> call2=phpservices.getusersspring();

                call2.enqueue(new Callback<List<usuario>>() {
                    @Override
                    public void onResponse(Call<List<usuario>> call2, Response<List<usuario>> response) {

                        if (response.isSuccessful()){
                            ArrayList<usuario> user=new ArrayList<usuario>();
                            list =response.body();
                            user=(ArrayList<usuario>) list;
                            Log.e("PRUEBA", "ya listo"+list.size());
                            Log.e("PRUEBA", "ya listo"+user.size());

                            adaptadorrphp = new Adaptadorrphp(MainActivity.this,user);
                            listauser.setAdapter(adaptadorrphp);


                        }
                    }

                    @Override
                    public void onFailure(Call<List<usuario>> call2, Throwable t) {
                        Log.e("PRUEBA", "ERROR"+t.getMessage());

                    }
                });



                break;
            case 4:
                Phpservice phpservice4;

                phpservice4= apiutilispython.getUserService();

                Call<List<usuario>> call3=phpservice4.getuserspython();

                call3.enqueue(new Callback<List<usuario>>() {
                    @Override
                    public void onResponse(Call<List<usuario>> call3, Response<List<usuario>> response) {

                        if (response.isSuccessful()){
                            ArrayList<usuario> user=new ArrayList<usuario>();
                            list =response.body();
                            user=(ArrayList<usuario>) list;
                            Log.e("PRUEBA", "ya listo"+list.size());
                            Log.e("PRUEBA", "ya listo"+user.size());

                            adaptadorrphp = new Adaptadorrphp(MainActivity.this,user);
                            listauser.setAdapter(adaptadorrphp);


                        }
                    }

                    @Override
                    public void onFailure(Call<List<usuario>> call3, Throwable t) {
                        Log.e("PRUEBA", "ERROR"+t.getMessage());

                    }
                });


                break;
        }


    }


    public void abrirdialogo(){
        tipodeenvio=1;
        Adaptadordialog recetaAdaptadorDialog=new Adaptadordialog();

        recetaAdaptadorDialog.show(getSupportFragmentManager(),"Dialogo ejemplo");
        recetaAdaptadorDialog.datosentrada("","","",1);

    }
    public void abrirdialogoentrada(){
        tipodeenvio=0;
        Adaptadordialog recetaAdaptadorDialog=new Adaptadordialog();
        recetaAdaptadorDialog.datosentrada(nom,apell,dni,0);

        recetaAdaptadorDialog.show(getSupportFragmentManager(),"Dialogo ejemplo");
    }

    public void addUser(usuario u){

        switch (numeroprograma) {
            case 1:
                Phpservice phpservice;

                phpservice= apiutilsphp.getUserService();

                Call<usuario> call = phpservice.addusers(u);
                call.enqueue(new Callback<usuario>() {
                    @Override
                    public void onResponse(Call<usuario> call, Response<usuario> response) {
                        if (response.isSuccessful()) {
                            listarusuario();
                        }
                    }

                    @Override
                    public void onFailure(Call<usuario> call, Throwable t) {
                        Log.e("ERROR: ", t.getMessage());
                    }
                });
                break;
            case 2:
                Phpservice phpservice2;

                phpservice2= apiutilisnodejs.getUserService();

                Call<usuario> call1 = phpservice2.addusersnodejs(u);
                call1.enqueue(new Callback<usuario>() {
                    @Override
                    public void onResponse(Call<usuario> call1, Response<usuario> response) {
                        if (response.isSuccessful()) {
                            listarusuario();
                        }
                    }

                    @Override
                    public void onFailure(Call<usuario> call1, Throwable t) {
                        Log.e("ERROR: ", t.getMessage());
                    }
                });

                break;
            case 3:
                Phpservice phpservice3;

                phpservice3= apiutilisspring.getUserService();

                Call<usuario> call2 = phpservice3.addusersspring(u);
                call2.enqueue(new Callback<usuario>() {
                    @Override
                    public void onResponse(Call<usuario> call2, Response<usuario> response) {
                        if (response.isSuccessful()) {
                            listarusuario();
                        }
                    }

                    @Override
                    public void onFailure(Call<usuario> call2, Throwable t) {
                        Log.e("ERROR: ", t.getMessage());
                    }
                });
                break;
            case 4:
                Phpservice phpservice4;

                phpservice4= apiutilispython.getUserService();

                Call<usuario> call3 = phpservice4.adduserspython(u);
                call3.enqueue(new Callback<usuario>() {
                    @Override
                    public void onResponse(Call<usuario> call3, Response<usuario> response) {
                        if (response.isSuccessful()) {
                            listarusuario();
                        }
                    }

                    @Override
                    public void onFailure(Call<usuario> call3, Throwable t) {
                        Log.e("ERROR: ", t.getMessage());
                    }
                });
                break;


        }
    }
    public void deleteUser(usuario u){

        switch (numeroprograma) {
            case 1:
                Phpservice phpservice;

                phpservice= apiutilsphp.getUserService();


                Call<usuario> call = phpservice.deleteuser(u);
                call.enqueue(new Callback<usuario>() {
                    @Override
                    public void onResponse(Call<usuario> call, Response<usuario> response) {
                        if(response.isSuccessful()){
                            listarusuario();

                        }
                    }

                    @Override
                    public void onFailure(Call<usuario> call, Throwable t) {
                        Log.e("ERROR: ", t.getMessage());
                    }
                });
                break;
            case 2:
                Phpservice phpservice2;

                phpservice2= apiutilisnodejs.getUserService();


                Call<usuario> call1 = phpservice2.deleteusernodejs(u.getId_usuario());
                call1.enqueue(new Callback<usuario>() {
                    @Override
                    public void onResponse(Call<usuario> call1, Response<usuario> response) {
                        if(response.isSuccessful()){
                            listarusuario();

                        }
                    }

                    @Override
                    public void onFailure(Call<usuario> call1, Throwable t) {
                        Log.e("ERROR: ", t.getMessage());
                    }
                });

                break;
            case 3:
                Phpservice phpservice3;

                phpservice3= apiutilisspring.getUserService();

                Call<usuario> call2 = phpservice3.deleteuserspring(u.getId_usuario());
                call2.enqueue(new Callback<usuario>() {
                    @Override
                    public void onResponse(Call<usuario> call2, Response<usuario> response) {
                        if(response.isSuccessful()){
                            listarusuario();

                        }
                    }

                    @Override
                    public void onFailure(Call<usuario> call2, Throwable t) {
                        Log.e("ERROR: ", t.getMessage());
                    }
                });
                break;
            case 4:
                Phpservice phpservice4;

                phpservice4= apiutilispython.getUserService();
                Call<usuario> call3 = phpservice4.deleteuserpython(u.getId_usuario());
                call3.enqueue(new Callback<usuario>() {
                    @Override
                    public void onResponse(Call<usuario> call3, Response<usuario> response) {
                        if(response.isSuccessful()){
                            listarusuario();

                        }
                    }

                    @Override
                    public void onFailure(Call<usuario> call3, Throwable t) {
                        Log.e("ERROR: ", t.getMessage());
                    }
                });
                break;


        }


    }
    public void updateUser(usuario u){

        switch (numeroprograma) {
            case 1:
                Phpservice phpservice;

                phpservice= apiutilsphp.getUserService();

                Call<usuario> call = phpservice.editusers( u);
                call.enqueue(new Callback<usuario>() {
                    @Override
                    public void onResponse(Call<usuario> call, Response<usuario> response) {
                        if(response.isSuccessful()){

                            listarusuario();

                        }
                    }

                    @Override
                    public void onFailure(Call<usuario> call, Throwable t) {
                        Log.e("ERROR: ", t.getMessage());
                    }
                });
                break;
            case 2:
                Phpservice phpservice2;

                phpservice2= apiutilisnodejs.getUserService();

                int id_usuario_momentaneo=u.getId_usuario();
                u.setId_usuario(0);
                Call<usuario> call1 = phpservice2.editusersnodejs( id_usuario_momentaneo,u);
                call1.enqueue(new Callback<usuario>() {
                    @Override
                    public void onResponse(Call<usuario> call1, Response<usuario> response) {
                        if(response.isSuccessful()){

                            listarusuario();

                        }
                    }

                    @Override
                    public void onFailure(Call<usuario> call1, Throwable t) {
                        Log.e("ERROR: ", t.getMessage());
                    }
                });
                break;
            case 3:
                Phpservice phpservice3;

                phpservice3= apiutilisspring.getUserService();

                int id_usuario_momentaneo1=u.getId_usuario();
                u.setId_usuario(0);
                Call<usuario> call12 = phpservice3.editusersspring( id_usuario_momentaneo1,u);
                call12.enqueue(new Callback<usuario>() {
                    @Override
                    public void onResponse(Call<usuario> call12, Response<usuario> response) {
                        if(response.isSuccessful()){

                            listarusuario();

                        }
                    }

                    @Override
                    public void onFailure(Call<usuario> call12, Throwable t) {
                        Log.e("ERROR: ", t.getMessage());
                    }
                });
                break;
            case 4:
                Phpservice phpservice4;

                phpservice4= apiutilispython.getUserService();

                int id_usuario_momentaneo2=u.getId_usuario();
                u.setId_usuario(0);
                Call<usuario> call123 = phpservice4.edituserspython( id_usuario_momentaneo2,u);
                call123.enqueue(new Callback<usuario>() {
                    @Override
                    public void onResponse(Call<usuario> call123, Response<usuario> response) {
                        if(response.isSuccessful()){

                            listarusuario();

                        }
                    }

                    @Override
                    public void onFailure(Call<usuario> call123, Throwable t) {
                        Log.e("ERROR: ", t.getMessage());
                    }
                });
                break;


        }





    }


    @Override
    public void obtener(String nombre, String apellido,String dni) {
        nomdefinitivo=nombre;
        apellidodefinitivo=apellido;
        dnidefinitivo=dni;
        if (tipodeenvio==1){
            Log.e("PRUEBA","CREAR");
            usuario us=new usuario();
            us.setId_usuario(0);
            us.setNombres(nomdefinitivo);
            us.setApellidos(apellidodefinitivo);
            us.setDni(Integer.parseInt(dnidefinitivo));

            addUser(us);
            listarusuario();
        }else{
            Log.e("PRUEBA","EDITAR");
            usuario us=new usuario();
            us.setId_usuario(Integer.parseInt(id_usuarioglobal));
            us.setNombres(nomdefinitivo);
            us.setApellidos(apellidodefinitivo);
            us.setDni(Integer.parseInt(dnidefinitivo));

            updateUser(us);
            listarusuario();


        }





    }
    @Override
    public void onBackPressed()
    {
        // Añade más funciones si fuese necesario

        Intent aasd=new Intent(getApplicationContext(),menupropuesta.class);
        startActivity(aasd);

    }
}
