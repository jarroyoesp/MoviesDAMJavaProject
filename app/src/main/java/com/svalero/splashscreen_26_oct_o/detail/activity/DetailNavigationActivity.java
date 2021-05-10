package com.svalero.splashscreen_26_oct_o.detail.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.svalero.splashscreen_26_oct_o.R;
import com.svalero.splashscreen_26_oct_o.detail.fragment.DetailNavigation1Fragment;
import com.svalero.splashscreen_26_oct_o.detailOld.activity.DetailActivity;
import com.svalero.splashscreen_26_oct_o.detailOld.fragment.Detail2Fragment;
import com.svalero.splashscreen_26_oct_o.detailOld.fragment.DetailFragment;

public class DetailNavigationActivity extends AppCompatActivity implements DetailNavigation1Fragment.DetailListener {

    private static String TAG = DetailNavigationActivity.class.getSimpleName();

    private BottomNavigationView mBottomNavigationView;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_navigation);
        fragmentManager = getSupportFragmentManager();

        mBottomNavigationView = findViewById(R.id.activity_detail_navigation_bottomnavview);

        initBottomNavigation();
        showFragment1();
    }

    private void initBottomNavigation() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_nav_1:
                        Log.d(TAG, "[onNavigationItemSelected] menu_nav_1");
                        showFragment1();
                        break;
                    case R.id.menu_nav_2:
                        Log.d(TAG, "[onNavigationItemSelected] menu_nav_2");
                        showFragment2();
                        break;
                    default:

                }

                // Devolver true para que os seleccione el elemento Clickado
                return true;
            }
        });
    }

    private void showFragment1() {
        Log.d(TAG, "[showFragment1]");
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        DetailFragment detailFragment = DetailFragment.newInstance("Title falso");
        transaction.add(R.id.activity_detail_navigation_layout_main, detailFragment);
        transaction.commit();
    }

    private void showFragment2() {
        Log.d(TAG, "[showFragment2]");
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        Detail2Fragment detail2Fragment = Detail2Fragment.newInstance();
        transaction.add(R.id.activity_detail_navigation_layout_main, detail2Fragment);
        transaction.commit();
    }

    @Override
    public void onCompraHecha() {
        getSupportFragmentManager().popBackStack();
        // Mostrar snackbar
    }
}