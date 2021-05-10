package com.svalero.splashscreen_26_oct_o.retrofit;

import com.svalero.splashscreen_26_oct_o.beans.Movie;
import com.svalero.splashscreen_26_oct_o.beans.MoviesAPIResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TheMovieApiInterface {

    // https://api.themoviedb.org/3/movie/popular?api_key=d9c4177bb1cc819d43088d25fbe2474c&language=en-US&page=1
    // https://api.themoviedb.org/3/movie/Aladin/actors
    // https://api.themoviedb.org/3/movie/BobEsponja/actors
    @GET("movie/popular")
    Call<MoviesAPIResult> getMovies(@Query("api_key") String apiKey,
                                    @Query("language") String language,
                                    @Query("page") int page);

    @GET("movie/top_rated?api_key=d9c4177bb1cc819d43088d25fbe2474c&language=en-US&page=1")
    Call<MoviesAPIResult> getTopRated();

}
