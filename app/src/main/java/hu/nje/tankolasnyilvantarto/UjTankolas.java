package hu.nje.tankolasnyilvantarto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UjTankolas extends Fragment {

    private TankolasViewModel mTankolasViewModel;


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

        mTankolasViewModel = new ViewModelProvider(this).get(TankolasViewModel.class);

        hozzaadGomb.setOnClickListener( v -> {


            if(isValidDate(ujDatum.getText() + " " + ujIdopont.getText()))
            {
                String megjegyzes = String.valueOf(ujMegjegyzes.getText());
                String mennyiseg = String.valueOf(ujMennyiseg.getText());
                int datum = 1;
                SimpleDateFormat konvertaltDatum = convertStringToDate(ujDatum.getText() + " " + ujIdopont.getText());
                Tankolas ujElem = new Tankolas("megjegyzesa", 101,201);

                mTankolasViewModel.insert(ujElem);
                mainactivity.UjElozoTankolasokFragment();
            }
            else {
                Toast.makeText(getContext(),"Rossz dátum",Toast.LENGTH_SHORT).show();
            }

        });
        return view;
    }

    public static boolean isValidDate(String beDatun) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(beDatun.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    private SimpleDateFormat convertStringToDate(String beDatum){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(beDatum.trim());
        } catch (ParseException pe) {
            return new SimpleDateFormat();
        }
        return dateFormat;
    }

}