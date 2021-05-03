package com.svalero.splashscreen_26_oct_o.retrofit;

import com.svalero.splashscreen_26_oct_o.beans.Movie;
import com.svalero.splashscreen_26_oct_o.beans.MoviesAPIResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TheMovieApiInterface {

    @GET("movie/popular?api_key=d9c4177bb1cc819d43088d25fbe2474c&language=en-US&page=1")
    Call<MoviesAPIResult> getMovies();

    @GET("movie/top_rated?api_key=d9c4177bb1cc819d43088d25fbe2474c&language=en-US&page=1")
    Call<MoviesAPIResult> getTopRated();

}
