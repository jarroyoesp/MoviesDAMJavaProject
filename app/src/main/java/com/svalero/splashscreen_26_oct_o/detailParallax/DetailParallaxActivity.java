package com.svalero.splashscreen_26_oct_o.detailParallax;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.svalero.splashscreen_26_oct_o.R;

public class DetailParallaxActivity extends AppCompatActivity {
    public static final String ARG_EXTRAS_TITLE = "ARG_EXTRAS_TITLE";
    public static final String ARG_EXTRAS_IMAGE = "ARG_EXTRAS_IMAGE";

    private String mTitle;
    private String mImageURL;

    private Toolbar mToolbar;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_parallax);
        getExtras();
        configView();
    }

    private void getExtras() {
        mTitle = getIntent().getExtras().getString(ARG_EXTRAS_TITLE);
        mImageURL = getIntent().getExtras().getString(ARG_EXTRAS_IMAGE);
    }

    private void configView(){
        mImageView = findViewById(R.id.toolbar_imageview);
        Picasso.get().load(mImageURL).into(mImageView);


        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(mTitle);

        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}