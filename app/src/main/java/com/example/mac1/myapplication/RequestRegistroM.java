package com.example.mac1.myapplication;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


class RequestRegistroM extends StringRequest {
    private static final String REGISTER_REQUEST_URL="http://10.0.0.6/Register.php";
    private Map<String,String> params;
    public RequestRegistroM(int idProfesor, String nombre, String appaterno, String apmaterno, String fechanacimiento, String nomusuario, String contrasena, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL,listener,null);
        params=new HashMap<>();
        params.put("idProfesor",idProfesor+"");
        params.put("nombre",nombre);
        params.put("appaterno",appaterno);
        params.put("apmaterno",apmaterno);
        params.put("fechanacimiento",fechanacimiento);
        params.put("nomusuario",nomusuario);
        params.put("contrasena",contrasena);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}