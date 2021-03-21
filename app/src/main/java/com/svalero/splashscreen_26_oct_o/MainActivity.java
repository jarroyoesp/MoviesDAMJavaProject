package com.svalero.splashscreen_26_oct_o;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.svalero.splashscreen_26_oct_o.user.login.view.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private static final int SCREEN = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lanzar un proceso en 2º plano que se active a los 4sg
        // package--> Manejar hilos
        final Handler handler = new Handler();
        handler.postDelayed(
                new Runnable() { // Interface
                    @Override
                    public void run() {

                        // Cargar la 2ª pantalla
                        Intent navegar = new Intent(
                                getBaseContext(), LoginActivity.class);
                        startActivity(navegar);
                    }
                }
                , 1000
        );
    }
}