package com.example.mac1.myapplication;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class RequestLoginM extends StringRequest {
    private static final String LOGGIN_REQUEST_URL="http://10.0.0.6/Login.php";
    private Map<String,String> params;
    public RequestLoginM( String nomusuario, String contrasena, Response.Listener<String> listener){
        super(Request.Method.POST, LOGGIN_REQUEST_URL,listener,null);
        params=new HashMap<>();
        params.put("nomusuario",nomusuario);
        params.put("contrasena",contrasena);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
