package hu.nje.tankolasnyilvantarto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ElozoTankolasok extends Fragment {

    public ElozoTankolasok() {
        // Required empty public constructor
    }


    public static ElozoTankolasok newInstance(String param1, String param2) {
        ElozoTankolasok fragment = new ElozoTankolasok();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_elozo_tankolasok, container, false);
        return view;
    }
}