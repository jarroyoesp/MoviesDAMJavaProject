package com.svalero.splashscreen_26_oct_o.movies.lstMovies.presenter;

import android.content.Context;

import com.svalero.splashscreen_26_oct_o.beans.Movie;
import com.svalero.splashscreen_26_oct_o.movies.lstMovies.contract.LstMoviesContract;
import com.svalero.splashscreen_26_oct_o.movies.lstMovies.model.LstMoviesModel;
import com.svalero.splashscreen_26_oct_o.movies.lstMovies.view.LstMoviesActivity;

import java.util.ArrayList;

public class LstMoviesPresenter
        implements LstMoviesContract.Presenter
{
    private LstMoviesModel lstMoviesModel;
    private LstMoviesContract.View vista;

    public LstMoviesPresenter(LstMoviesContract.View vista) {
        this.vista = vista;
        this.lstMoviesModel = new LstMoviesModel();
    }


    @Override
    public void getMovies(Context context) {
            lstMoviesModel.getMoviesWS(context, new LstMoviesContract.Model.OnLstMoviesListener() {
                @Override
                public void resolve(ArrayList<Movie> movies) {
                    vista.success(movies);
                }
                @Override
                public void reject(String error) {
                    vista.error("Problemas al traer los datos.");
                }
            });

    }
}
