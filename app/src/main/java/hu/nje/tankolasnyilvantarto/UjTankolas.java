package hu.nje.tankolasnyilvantarto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class UjTankolas extends Fragment {
    Button hozzaadGomb;
    EditText ujMennyiseg;
    EditText ujDatum;
    EditText ujIdopont;
    EditText ujMegjegyzes;
    public UjTankolas() {
        // Required empty public constructor
    }

    public static UjTankolas newInstance(String param1, String param2) {
        UjTankolas fragment = new UjTankolas();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_uj_tankolas, container, false);
        MainActivity mainactivity = (MainActivity)getActivity();
        ujMennyiseg = view.findViewById(R.id.ujTankolasFrgMennyiseg);
        ujDatum = view.findViewById(R.id.ujTankolasFrgDatum);
        ujIdopont = view.findViewById(R.id.ujTankolasFrgIdopont);
        ujMegjegyzes = view.findViewById(R.id.ujTankolasFrgMeghegyzes);

        hozzaadGomb = view.findViewById(R.id.ujTankolasFrgHozzaad);
        hozzaadGomb.setOnClickListener( v -> {

            Tankolas ujElem = new Tankolas("megjegyzes", 100,200);

        });
        return view;
    }
}