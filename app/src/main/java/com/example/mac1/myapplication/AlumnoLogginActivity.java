package com.example.mac1.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AlumnoLogginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_loggin);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case  R.id.tview_registrarA:
                Intent intent = new Intent(AlumnoLogginActivity.this, ActivityRegistroAlumno.class);
                startActivity(intent);
                break;
            case R.id.button_ingresarA:
                Intent intent1 = new Intent(AlumnoLogginActivity.this, activity_alumno_menu.class);
                startActivity(intent1);
                break;

        }
    }
}
