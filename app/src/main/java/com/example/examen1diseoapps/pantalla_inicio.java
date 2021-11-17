package com.example.examen1diseoapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class pantalla_inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
        new CountDownTimer(2000,1000) {
            @Override
            public void onTick(long l) {
            }
            @Override
            public void onFinish() {
                startActivity(new Intent(pantalla_inicio.this, MainActivity.class));

            }
        }.start();
    }
}