package com.svalero.splashscreen_26_oct_o.user.login.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.svalero.splashscreen_26_oct_o.BuildConfig;
import com.svalero.splashscreen_26_oct_o.R;
import com.svalero.splashscreen_26_oct_o.RegisterRelativeLayout;
import com.svalero.splashscreen_26_oct_o.beans.User;
import com.svalero.splashscreen_26_oct_o.movies.lstMovies.view.LstMoviesActivity;
import com.svalero.splashscreen_26_oct_o.user.login.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity {
    private static final int SCREEN = 2;

    private Button btnEnviar;
    private TextInputLayout textInputLayoutEmail;
    private EditText edtEmail;
    private EditText edtPassword;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_new);
        //3º--> Inicializar
        initComponents();
        //
        // 4º--> Presentador (Controller)
        loginPresenter = new LoginPresenter(this);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.login(
                        edtEmail.getText().toString(),
                        edtPassword.getText().toString()
                );
            }
        });
    }
    private void initComponents(){
        btnEnviar = findViewById(R.id.activity_login_button_enviar);
        textInputLayoutEmail = findViewById(R.id.activity_login_textinput_layout_email);
        edtEmail = findViewById(R.id.edtEmail);
        edtEmail.setText(BuildConfig.API_URL);
        edtPassword = findViewById(R.id.edtPassword);

        textInputLayoutEmail.setError("Error de Login");
    }



    public void success(User user){
        textInputLayoutEmail.setError(null);
        Toast.makeText(this, "Usuario Correcto",
                Toast.LENGTH_SHORT).show();
        Intent navegar = new Intent(getBaseContext(), LstMoviesActivity.class);
        startActivity(navegar);
    }

    public void error(String err){
        textInputLayoutEmail.setError(err);
    }
}