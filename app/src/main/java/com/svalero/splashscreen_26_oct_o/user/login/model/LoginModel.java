package com.svalero.splashscreen_26_oct_o.user.login.model;

import android.content.Intent;
import android.os.Handler;

import com.svalero.splashscreen_26_oct_o.RegisterRelativeLayout;
import com.svalero.splashscreen_26_oct_o.beans.User;
import com.svalero.splashscreen_26_oct_o.user.login.contract.LoginContract;

public class LoginModel {
    final boolean resp = true;
    private static final String URL =
            "http://localhost:42644/2_Netflix_JavascriptParametros/" +
                    "Controller?ACTION=USUARIO.LOGIN&" +
                    "EMAIL=samuel@gmail.com&" +
                    "PASS=1234";

    public void loginUserWS(final User user,
                            final LoginContract.Model.OnLoginUserListener
                                    onLoginUserListener){
        // Lanzar un proceso en 2º plano que se active a los 4sg
        // package--> Manejar hilos
        final Handler handler = new Handler();
        handler.postDelayed(
                new Runnable() { // Interface
                    @Override
                    public void run() {
                        // Cargar la 2ª pantalla
                        if(resp){
                            /*Seguir aquí con MVP*/
                            onLoginUserListener.onFinished(user);
                            /*Intent navegar = new Intent(
                                    loginActivity.getBaseContext(),
                                    RegisterRelativeLayout.class);
                            loginActivity.startActivity(navegar);*/
                        }else{
                            onLoginUserListener.onFailure("Error de Servidor. ");
                        }
                    }
                }
                , 4000
        );
    }
}
