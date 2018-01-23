package com.example.mac1.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MaestroLogginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maestro_loggin);
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case  R.id.tview_registrarP:
                Intent intent = new Intent(this, ActivityRegistroMaestro.class);
                startActivity(intent);
                break;
            case R.id.button_ingresar:
                Intent intent2 = new Intent(this, activity_docente_menu.class);
                startActivity(intent2);
                break;

            default:
                break;
    }
}
}