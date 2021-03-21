package com.svalero.splashscreen_26_oct_o.movies.lstMovies.model;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;

import androidx.annotation.Nullable;

import com.svalero.splashscreen_26_oct_o.beans.Movie;
import com.svalero.splashscreen_26_oct_o.beans.MoviesAPIResult;
import com.svalero.splashscreen_26_oct_o.movies.lstMovies.contract.LstMoviesContract;
import com.svalero.splashscreen_26_oct_o.retrofit.ApiClient;
import com.svalero.splashscreen_26_oct_o.retrofit.TheMovieApiInterface;
import com.svalero.splashscreen_26_oct_o.utils.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstMoviesModel
        implements LstMoviesContract.Model {

    @Override
    public void getMoviesWS(Context context, final OnLstMoviesListener onLstMoviesListener) {
        ApiClient apiClient = new ApiClient(context);
        final Call<MoviesAPIResult> batch = apiClient.getMovies();

        batch.enqueue(new Callback<MoviesAPIResult>() {
            @Override
            public void onResponse(@Nullable Call<MoviesAPIResult> call, @Nullable Response<MoviesAPIResult> response) {
                if (response != null && response.body() != null) {
                    onLstMoviesListener.resolve(new ArrayList<Movie>(response.body().getResults()));
                }
            }

            @Override
            public void onFailure(@Nullable Call<MoviesAPIResult> call, @Nullable Throwable t) {
                t.printStackTrace();
                onLstMoviesListener.reject(t.getLocalizedMessage());
            }
        });
    }
}
