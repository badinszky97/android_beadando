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

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UjTankolas extends Fragment {

    private TankolasViewModel mTankolasViewModel;


    Button hozzaadGomb;
    EditText ujMennyiseg;
    EditText ujEv;
    EditText ujHonap;
    EditText ujNap;
    EditText ujOra;
    EditText ujPerc;
    EditText ujMegjegyzes;
    EditText ujKm;
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

        ujMegjegyzes = view.findViewById(R.id.ujTankolasFrgMeghegyzes);
        ujEv = view.findViewById(R.id.editEv);
        ujHonap = view.findViewById(R.id.editHonap);
        ujNap = view.findViewById(R.id.editNap);
        ujOra = view.findViewById(R.id.editOra);
        ujPerc = view.findViewById(R.id.editPerc);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd/HH/mm");
        Date date = new Date();
        String maiDatum=formatter.format(date);
        String[] arrOfStr = maiDatum.split("/");
        ujEv.setText(arrOfStr[0]);
        ujHonap.setText(arrOfStr[1]);
        ujNap.setText(arrOfStr[2]);
        ujOra.setText(arrOfStr[3]);
        ujPerc.setText(arrOfStr[4]);
        ujMegjegyzes.setText(" ");

        ujKm = view.findViewById(R.id.ujTankolasFrgKm);

        hozzaadGomb = view.findViewById(R.id.ujTankolasFrgHozzaad);

        mTankolasViewModel = new ViewModelProvider(this).get(TankolasViewModel.class);

        hozzaadGomb.setOnClickListener( v -> {


            if(DatumValos() != "")
            {
                java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(DatumValos());
                Tankolas ujtank = new Tankolas(ujMegjegyzes.getText().toString(), Integer.parseInt(ujMennyiseg.getText().toString()), timestamp.getTime(), Integer.parseInt(ujKm.getText().toString()) );
                mTankolasViewModel.insert(ujtank);
                mainactivity.UjElozoTankolasokFragment();
            }
            else {
                Toast.makeText(getContext(),"Rossz dátum",Toast.LENGTH_SHORT).show();
            }

        });
        return view;
    }

    public String DatumValos() {
        try {

            int ev = Integer.parseInt(ujEv.getText().toString());
            int honap = Integer.parseInt(ujHonap.getText().toString());
            int nap = Integer.parseInt(ujNap.getText().toString());

            int ora = Integer.parseInt(ujOra.getText().toString());
            int perc = Integer.parseInt(ujPerc.getText().toString());

            String idopontString = String.valueOf(ev) + "-" + String.valueOf(honap) + "-" + String.valueOf(nap) + " " + String.valueOf(ora) + ":" + String.valueOf(perc) + ":00";
            java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(idopontString);
            return idopontString;
        }
        catch(Exception e) {
            return "";
        }
    }

}