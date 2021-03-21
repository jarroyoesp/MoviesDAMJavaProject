package com.svalero.splashscreen_26_oct_o;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class RegisterRelativeLayout extends AppCompatActivity {
    private static final int SCREEN = 3;
    private Button btnEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_relative_layout);
        //3º--> Inicializar
        initComponents();

        //
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cargar la 3ª pantalla
                Intent navegar = new Intent(
                        getBaseContext(), LoginContraintLayout.class);
                startActivity(navegar);
            }
        });
    }
    private void initComponents(){
        btnEnviar = findViewById(R.id.btnEnviarConstraint);
        LinearLayout capa2 = findViewById(R.id.capa2);
        //capa2.setEnabled(true);
    }
}