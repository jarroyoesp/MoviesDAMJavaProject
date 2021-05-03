package com.svalero.splashscreen_26_oct_o.beans;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Movie {
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String OVERVIEW = "overview";
    private static final String POSTER_PATH = "poster_path";

    private int id;
    // CUIDADO EL NOMBRE DE LA VARIABLE TIENE QUE SER EL MISMO QUE EN EL JSON O USAR @SerializedName("NOMBRE EN EL JSON")
    @SerializedName("title")
    private String titulo;
    @SerializedName("overview")
    private String sinopsis;
    @SerializedName("poster_path")
    private String image;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    // YA NO ES NECESARIO

    public static ArrayList<Movie> getArrayListFromJSON(JSONArray lstMovies){
        ArrayList<Movie> lista = null;
        try {
            if(lstMovies!=null && lstMovies.length() > 0 ){
                lista = new ArrayList<Movie>();
            }
            for (int i = 0; i < lstMovies.length(); i++) {
                JSONObject json_data = lstMovies.getJSONObject(i);
                Movie movie = new Movie();

                movie.setId(json_data.getInt(ID));
                movie.setTitulo(json_data.getString(TITLE));
                movie.setSinopsis(json_data.getString(OVERVIEW));
                movie.setImage(json_data.getString(POSTER_PATH));

                lista.add(movie);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
