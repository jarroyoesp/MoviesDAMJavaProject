package com.svalero.splashscreen_26_oct_o.movies.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.svalero.splashscreen_26_oct_o.R;
import com.svalero.splashscreen_26_oct_o.beans.Movie;
import com.svalero.splashscreen_26_oct_o.detail.activity.DetailNavigationActivity;
import com.svalero.splashscreen_26_oct_o.detailOld.activity.DetailActivity;
import com.svalero.splashscreen_26_oct_o.detailParallax.DetailParallaxActivity;

import java.util.ArrayList;

public class MovieAdapter
        extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private ArrayList<Movie> lstMovies;

    /*Tantos elementos como objetos
            quiera mostrar en la fila*/
    public static class MovieViewHolder
            extends RecyclerView.ViewHolder{
        public ImageView img; //0x565854
        public TextView titulo; // 0x457855
        public TextView director; // 0x487889
        public CardView cardView; // 0x487889

        public MovieViewHolder(View v){
            super(v);
            img = (ImageView) v.findViewById(R.id.imgMovie);
            titulo = (TextView) v.findViewById(R.id.txtTitulo);
            director = (TextView) v.findViewById(R.id.txtDirector);
            cardView = v.findViewById(R.id.item_movie_cardview);
        }
    }

    public MovieAdapter(ArrayList<Movie> lstMovies) {
        this.lstMovies = lstMovies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                int viewType) {
        View v = LayoutInflater.
                        from(parent.getContext())
                .inflate(R.layout.row_movie_new,
                        parent,
                        false);
        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder,
                                 int position) {
            // Enlace=pintado
        // holder.img
            // Vídeo de Picasso o Glide
        final Movie movie = lstMovies.get(position);

        holder.titulo.setText(movie.getTitulo());
        holder.director.setText(movie.getTitulo());

        // Picasso.with(context).load(movie.getImage()).
        //  into(holder.img);
        // AÑADIR LIBRERÍA implementation 'com.squareup.picasso:picasso:2.71828'
        // https://image.tmdb.org/t/p/original/eLT8Cu357VOwBVTitkmlDEg32Fs.jpg
        String urlBase = "https://image.tmdb.org/t/p/original";
        //Picasso.get().load(urlBase + movie.getImage()).into(holder.img);
        Picasso.get().load(urlBase + movie.getImage()).into(holder.img);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detalle = new Intent(holder.cardView.getContext(), DetailParallaxActivity.class);

                String urlBase = "https://image.tmdb.org/t/p/original";
                Bundle extras = new Bundle();
                extras.putString(DetailParallaxActivity.ARG_EXTRAS_TITLE, movie.getTitulo());
                extras.putString(DetailParallaxActivity.ARG_EXTRAS_IMAGE, urlBase + movie.getImage());

                detalle.putExtras(extras);

                holder.cardView.getContext().startActivity(detalle);
            }
        });

    }

    @Override
    public int getItemCount() {
        return lstMovies.size();
    }


}
