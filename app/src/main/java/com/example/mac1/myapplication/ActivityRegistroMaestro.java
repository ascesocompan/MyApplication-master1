package com.example.mac1.myapplication;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class ActivityRegistroMaestro extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener{

    EditText idP, nombreP, apellidoPp, apellidoMp, fnacP, usuarioP, Text10;
    Button registrarP;
    ProgressDialog progreso;
    RequestQueue request1;
    JsonObjectRequest JSONOBJECTREQUEST;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_maestro);
    }
//hola    //jdjddds.
    //@SuppressLint("ResourceType")
    /*@Override .
    public View onCreateView(LayoutInflater inflater, ViewGroup container
                             ) {
        View vista=inflater.inflate(R.layout.activity_registro_maestro, container, false);
        idP= (EditText) vista.findViewById(R.id.txt_idP);
        nombreP= (EditText) vista.findViewById(R.id.txt_nombreP);
        apellidoPp= (EditText) vista.findViewById(R.id.txt_apellidoPp);
        apellidoMp= (EditText) vista.findViewById(R.id.txt_apellidoMp);
        fnacP= (EditText) vista.findViewById(R.id.txt_fnacP);
        usuarioP= (EditText) vista.findViewById(R.id.txt_usuarioP);
        Text10= (EditText) vista.findViewById(R.id.editText10);
        registrarP=  vista.findViewById(R.id.button_registrarP);

        request1= Volley.newRequestQueue(getApplicationContext());
        return vista;
        registrarP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarwebservice();
            }
        });
    }*/

    private void cargarwebservice() {
        progreso=new ProgressDialog(getApplicationContext());
        progreso.setMessage("Cargando...");
        progreso.show();

        String url="http:// 192.168.0.127/conexionbd/registro.php?idprofesor="+idP.getText().toString()+"&nombre="+ nombreP.getText().toString()+
                "&appaterno="+apellidoPp.getText().toString()+"&apmaterno="+apellidoMp.getText().toString()+
                "&fechanacimiento="+fnacP.getText().toString()+"&nomusuario="+usuarioP.getText().toString()+"&contrasena="+Text10.getText().toString();
        url= url.replace("","%20");
        JSONOBJECTREQUEST= new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        request1.add(JSONOBJECTREQUEST);
    }

    public void onClick(View view) {

    }

    @Override
    public void onErrorResponse(VolleyError error) {
progreso.hide();
        Toast.makeText(getApplicationContext(),"se a producido un error"+error.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getApplicationContext(),"se a registrado exitosamente", Toast.LENGTH_SHORT).show();
        progreso.hide();
        idP.setText("");
        nombreP.setText("");
        apellidoPp.setText("");
        apellidoMp.setText("");
        fnacP.setText("");
        usuarioP.setText("");
        Text10.setText("");

    }
}
