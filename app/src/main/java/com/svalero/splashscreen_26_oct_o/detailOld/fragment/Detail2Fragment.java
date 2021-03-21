package com.svalero.splashscreen_26_oct_o.detailOld.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.svalero.splashscreen_26_oct_o.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Detail2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Detail2Fragment extends Fragment {

    private static String TAG = Detail2Fragment.class.getSimpleName();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Detail2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Detail2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Detail2Fragment newInstance() {
        Detail2Fragment fragment = new Detail2Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "[onCreate]");
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "[onCreateView]");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail2, container, false);
    }
}