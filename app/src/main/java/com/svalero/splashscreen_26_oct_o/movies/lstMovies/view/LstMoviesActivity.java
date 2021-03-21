package com.svalero.splashscreen_26_oct_o.movies.lstMovies.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.svalero.splashscreen_26_oct_o.R;
import com.svalero.splashscreen_26_oct_o.RegisterRelativeLayout;
import com.svalero.splashscreen_26_oct_o.beans.Movie;
import com.svalero.splashscreen_26_oct_o.beans.User;
import com.svalero.splashscreen_26_oct_o.movies.adapter.MovieAdapter;
import com.svalero.splashscreen_26_oct_o.movies.lstMovies.contract.LstMoviesContract;
import com.svalero.splashscreen_26_oct_o.movies.lstMovies.presenter.LstMoviesPresenter;

import java.util.ArrayList;

public class LstMoviesActivity
        extends AppCompatActivity
        implements LstMoviesContract.View {

    private RecyclerView recycler;
    private LstMoviesPresenter lstMoviesPresenter;
    private RecyclerView.LayoutManager lManager;

    private View layoutError;
    private TextView textViewError;
    private Button buttonRetry;

    private ProgressBar progressBarLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_movies);

        recycler = (RecyclerView) findViewById(R.id.recyclerMovies);
        layoutError = findViewById(R.id.activity_lst_movies_layout_error);
        textViewError = findViewById(R.id.activity_lst_movies_tv_error);
        buttonRetry = findViewById(R.id.activity_lst_movies_button_retry);
        progressBarLoading = findViewById(R.id.activity_lst_movies_progressbar_loading);

        progressBarLoading.setVisibility(View.VISIBLE);

        lstMoviesPresenter = new LstMoviesPresenter(this);
        lstMoviesPresenter.getMovies(this);

        setListeners();
    }

    private void setListeners() {
        buttonRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBarLoading.setVisibility(View.VISIBLE);
                hideError();

                lstMoviesPresenter.getMovies(LstMoviesActivity.this);
            }
        });
    }

    @Override
    public void success(ArrayList<Movie> movies) {
        showDataInRecyclerView(movies);
    }

    @Override
    public void error(String message) {
        showError(message);
    }

    private void showDataInRecyclerView(ArrayList<Movie> movies) {
        progressBarLoading.setVisibility(View.GONE);

        recycler.setVisibility(View.VISIBLE);
        layoutError.setVisibility(View.GONE);


        // Obtener el Recycler
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        // 1º) Tipo Lista
        // 2º) Tipo Grid
        lManager = new LinearLayoutManager(this);

        recycler.setLayoutManager(lManager);
        // Crear un nuevo adaptador
        MovieAdapter adapter = new MovieAdapter(movies);

        recycler.setAdapter(adapter);
    }

    private void showError(String message) {
        progressBarLoading.setVisibility(View.GONE);

        recycler.setVisibility(View.GONE);
        layoutError.setVisibility(View.VISIBLE);

        textViewError.setText(message);

    }

    private void hideError() {
        layoutError.setVisibility(View.GONE);
    }

}