package com.svalero.splashscreen_26_oct_o.detail.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.svalero.splashscreen_26_oct_o.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailNavigation1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailNavigation1Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private DetailListener listener;

    public DetailNavigation1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (DetailListener) getActivity();
        } catch (Exception e) {
            Log.e("DetailFragment", "Activity tiene que implementar DetailListener");
        }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailNavigation1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailNavigation1Fragment newInstance(String param1, String param2) {
        DetailNavigation1Fragment fragment = new DetailNavigation1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_navigation1, container, false);



        return view;
    }

    void onSuccess() {
        listener.onCompraHecha();
    }

    public interface DetailListener {
        void onCompraHecha();
    }
}