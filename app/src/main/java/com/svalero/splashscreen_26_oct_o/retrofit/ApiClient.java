package com.svalero.splashscreen_26_oct_o.retrofit;

import android.content.ClipData;
import android.content.Context;

import com.svalero.splashscreen_26_oct_o.beans.Movie;
import com.svalero.splashscreen_26_oct_o.beans.MoviesAPIResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private Retrofit retrofit;
    private Context context;

    private static final String BASE_URL = "https://api.themoviedb.org/3/";

    public ApiClient(Context context) {
        this.context = context;

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // AÑADIREMOS AQUÍ los METODOS PARA LLAMAR AL BACKEND
    public Call<MoviesAPIResult> getMovies() {
        TheMovieApiInterface service = retrofit.create(TheMovieApiInterface.class);
        return service.getMovies();
    }
}