package com.example.mac1.myapplication;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MaestroLogginActivity extends AppCompatActivity {
   TextView txtRegistrar;
   EditText txt_usuarioPP,txt_contraseñaP;
    Button btn_ingresarM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maestro_loggin);

        txtRegistrar=findViewById(R.id.tview_registrarP);
        txtRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegistro= new Intent(MaestroLogginActivity.this,ActivityRegistroMaestro.class);
                MaestroLogginActivity.this.startActivity(intentRegistro);
            }
        });
        txt_usuarioPP=findViewById(R.id.txt_usuarioP);
        txt_contraseñaP=findViewById(R.id.txt_passwordP);

        btn_ingresarM=findViewById(R.id.button_ingresar);
        btn_ingresarM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String nomusuario=txt_usuarioPP.getText().toString();
                final String contrasena=txt_contraseñaP.getText().toString();

                Response.Listener<String> responseListener=new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse=new JSONObject(response);
                            boolean success=jsonResponse.getBoolean("success");
                            if(success){
                                Intent intent =new Intent(MaestroLogginActivity.this,activity_docente_menu.class);
                                MaestroLogginActivity.this.startActivity(intent);
                            }else{
                                android.app.AlertDialog.Builder builder= new android.app.AlertDialog.Builder(MaestroLogginActivity.this);
                                builder.setMessage("error en el loggin")
                                        .setNegativeButton("Retry",null)
                                        .create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                RequestLoginM requestLoginM=new RequestLoginM(nomusuario,contrasena,responseListener);
                RequestQueue queue= Volley.newRequestQueue(MaestroLogginActivity.this);
                queue.add(requestLoginM);
            }
        });
    }


}
