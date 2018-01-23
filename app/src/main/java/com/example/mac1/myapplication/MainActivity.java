package com.example.mac1.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
 //Actualizacion HOLASIQUETAL MALDITA SEA AGARRA
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case  R.id.buttonDocente:
                Intent intent = new Intent(MainActivity.this, MaestroLogginActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonAlumno:
                Intent intent2 = new Intent(MainActivity.this, AlumnoLogginActivity.class);
                startActivity(intent2);
                break;

            default:
                break;
        }
    }

}
