package com.example.mac1.myapplication;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
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

import org.json.JSONException;
import org.json.JSONObject;

public class ActivityRegistroMaestro extends AppCompatActivity implements View.OnClickListener {

    EditText idP, nombreP, apellidoPp, apellidoMp, fnacP, usuarioP, contrasenaP;
    Button registrarP;
    ProgressDialog progreso;
    RequestQueue request1;
    JsonObjectRequest JSONOBJECTREQUEST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_maestro);

        idP= findViewById(R.id.txt_idP);
        nombreP= findViewById(R.id.txt_nombreP);
        apellidoPp= findViewById(R.id.txt_apellidoPp);
        apellidoMp= findViewById(R.id.txt_apellidoMp);
        fnacP= findViewById(R.id.txt_fnacP);
        usuarioP= findViewById(R.id.txt_usuarioP);
        contrasenaP= findViewById(R.id.txt_contrasena);
        registrarP= findViewById(R.id.button_registrarP);

        registrarP.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final int idProfesor=Integer.parseInt(idP.getText().toString());
        final String nombre=nombreP.getText().toString();
        final String appaterno=apellidoPp.getText().toString();
        final String apmaterno=apellidoMp.getText().toString();
        final String fechanacimiento=fnacP.getText().toString();
        final String nomusuario=usuarioP.getText().toString();
        final String contrasena=contrasenaP.getText().toString();

        Response.Listener<String> respoListener= new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonResponse= new JSONObject(response);
                    boolean succes=jsonResponse.getBoolean("success");

                    if(succes){
                        Intent intent= new Intent(ActivityRegistroMaestro.this,MaestroLogginActivity.class);
                        ActivityRegistroMaestro.this.startActivity(intent);
                    }else{
                        AlertDialog.Builder builder= new AlertDialog.Builder(ActivityRegistroMaestro.this);
                        builder.setMessage("error en el registro")
                                .setNegativeButton("Retry",null)
                                .create().show();
                    }
                }catch(JSONException e){
                    e.printStackTrace();
                }
            }
        };

        RequestRegistroM requestRegistroM= new RequestRegistroM(idProfesor,nombre,appaterno,apmaterno,fechanacimiento,nomusuario,contrasena,respoListener);
        RequestQueue queue=Volley.newRequestQueue(ActivityRegistroMaestro.this);
        queue.add(requestRegistroM);
    }





}
