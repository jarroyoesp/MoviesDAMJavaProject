package com.svalero.splashscreen_26_oct_o.user.login.presenter;

import android.content.Intent;
import android.os.Handler;

import com.svalero.splashscreen_26_oct_o.RegisterRelativeLayout;
import com.svalero.splashscreen_26_oct_o.beans.User;
import com.svalero.splashscreen_26_oct_o.user.login.contract.LoginContract;
import com.svalero.splashscreen_26_oct_o.user.login.model.LoginModel;
import com.svalero.splashscreen_26_oct_o.user.login.view.LoginActivity;

public class LoginPresenter {
    // LoginController=>
    // LoginPresenter=>
    // Negociador =>
    private LoginActivity loginActivity;
    private LoginModel loginModel;
    public LoginPresenter(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
        this.loginModel = new LoginModel();
    }
    private boolean isValidacionCorrecta = true;
    public void login(String email,
                      String password){
        // 1º=> Validar datos de entrada
            // Clase Validaciones, (estática)

        if(isValidacionCorrecta){
            // 2º=> Consultar el API para Login
                User user = new User();
                user.setEmail(email);
                user.setPassword(password);
            loginModel.loginUserWS(user,
                    new LoginContract.Model.OnLoginUserListener() {
                @Override
                public void onFinished(User user) {
                    loginActivity.success(user);
                }

                @Override
                public void onFailure(String error) {
                    loginActivity.error(error);
                }
            });
        }

        // 3º=> Responder user (correcto) o user (incorrecto)
        // 4º=> Cambiar de pantalla
        // Cargar la 2ª pantalla

    }
}
/*
// MVC => MVP Model View Presenter

* */
