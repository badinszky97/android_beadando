package hu.nje.tankolasnyilvantarto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Kezdolap extends Fragment {

    public Kezdolap() {
        // Required empty public constructor
    }

    public static Kezdolap newInstance(String param1, String param2) {
        Kezdolap fragment = new Kezdolap();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_kezdolap, container, false);
        MainActivity mainactivity = (MainActivity)getActivity();
        Button exitButton = view.findViewById(R.id.exitButton);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainactivity.finish();
                System.exit(0);

            }
        });

        return view;
    }
}