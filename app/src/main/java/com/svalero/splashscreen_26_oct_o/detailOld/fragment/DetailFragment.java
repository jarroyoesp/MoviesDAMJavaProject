package com.svalero.splashscreen_26_oct_o.detailOld.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.svalero.splashscreen_26_oct_o.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    private static final String TAG = DetailFragment.class.getSimpleName();

    private static final String ARG_EXTRAS_TITLE = "ARG_EXTRAS_TITLE";

    private String mTitle;

    private OnDetailExternalListener listener;

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DetailFragment.
     */
    public static DetailFragment newInstance(String title) {
        Log.d(TAG, "[DetailFragment] Title: "+ title);
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_EXTRAS_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "[onCreate]");
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(ARG_EXTRAS_TITLE);
        }

        try {
            listener = (OnDetailExternalListener) getActivity();
        } catch (Exception e) {
            Log.e(TAG, "Activity debe implementar OnDetailListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "[onCreateView] Title" + mTitle);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        // Introducir listeners a los elementos de la vista
        Button buttonMoreInfo = view.findViewById(R.id.fragment_detail_button_more_info);
        buttonMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickMoreInfoExternal();
            }
        });


        TextView textViewTitle = view.findViewById(R.id.fragment_detail_textview_title);
        textViewTitle.setText(mTitle);
        return view;
    }
}