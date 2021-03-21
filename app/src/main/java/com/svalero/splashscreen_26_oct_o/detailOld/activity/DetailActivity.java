package com.svalero.splashscreen_26_oct_o.detailOld.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.svalero.splashscreen_26_oct_o.R;
import com.svalero.splashscreen_26_oct_o.detailOld.fragment.Detail2Fragment;
import com.svalero.splashscreen_26_oct_o.detailOld.fragment.DetailFragment;
import com.svalero.splashscreen_26_oct_o.detailOld.fragment.OnDetailExternalListener;

public class DetailActivity extends AppCompatActivity implements OnDetailExternalListener {
    private static String TAG = DetailActivity.class.getSimpleName();

    public static String ARG_EXTRA_TITLE = "ARG_EXTRA_TITLE";

    private String title = "";

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initFragmentManager();
        getExtras();

        addDetailFragment();
    }

    private void initFragmentManager() {
        mFragmentManager = getSupportFragmentManager();
    }

    private void getExtras() {
        title = getIntent().getExtras().getString(ARG_EXTRA_TITLE);
        Log.d(TAG, "[getExtras] Title " + title);
    }

    private void addDetailFragment() {
        Log.d(TAG, "[addDetailFragment]");
        // Manager de fragments
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        DetailFragment detailFragment = DetailFragment.newInstance(title);
        fragmentTransaction.add(R.id.activity_detail_layout_main, detailFragment);
        // En el primer fragment que se añade desde el código no usar addToBackStack
        // fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void addDetailFragment2() {
        Log.d(TAG, "[addDetailFragment2]");
        // Manager de fragments
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        Detail2Fragment detail2Fragment = Detail2Fragment.newInstance();
        fragmentTransaction.replace(R.id.activity_detail_layout_main, detail2Fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onClickMoreInfoExternal() {
        Toast.makeText(getApplicationContext(), "OnCLickActivity", Toast.LENGTH_LONG).show();
        addDetailFragment2();
    }
}