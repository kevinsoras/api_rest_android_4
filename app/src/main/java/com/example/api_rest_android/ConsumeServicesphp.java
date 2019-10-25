package com.example.api_rest_android;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class ConsumeServicesphp extends AsyncTask<Void,Void,String> {

    //variables del hilo
    private Context httpContex;
    ProgressDialog progressDialog;
    public String resultadoapi="";
    public String linkrequestAPI="";

    public ConsumeServicesphp(Context ctx,String linkApi){
        this.httpContex=ctx;
        this.linkrequestAPI=linkApi;

    }


    @Override
    protected String doInBackground(Void... voids) {
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog=ProgressDialog.show(httpContex,"Procesando solicitud","Por favor espere ");
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        progressDialog.dismiss();
        resultadoapi=s;
        Toast.makeText(httpContex,resultadoapi,Toast.LENGTH_SHORT).show();

    }
}
