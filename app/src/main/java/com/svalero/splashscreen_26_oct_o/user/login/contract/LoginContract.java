package com.svalero.splashscreen_26_oct_o.user.login.contract;

import com.svalero.splashscreen_26_oct_o.beans.User;

import java.util.ArrayList;

public interface LoginContract {
    interface View{

    }
    interface Presenter{

    }
    interface Model{
        /*Programación Reactiva*/
        interface OnLoginUserListener{
            void onFinished(User user);
            void onFailure(String error);
        }
    }
}
