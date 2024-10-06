package hu.nje.tankolasnyilvantarto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.Date;
import java.util.List;

public class FogyasztasiAdatok extends Fragment {
    FogyasztasiAdat[] fogyasztasok;
    public FogyasztasiAdatok() {
        // Required empty public constructor
    }

    public static FogyasztasiAdatok newInstance() {
        FogyasztasiAdatok fragment = new FogyasztasiAdatok();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fogyasztasi_adatok, container, false);
        MainActivity mainActivity = (MainActivity)getActivity();

        List<Tankolas> tankolasok = mainActivity.mTankolasViewModel.getAllWords().getValue();



        if(tankolasok.size() > 2)
        {
            fogyasztasok = new FogyasztasiAdat[tankolasok.size()-1];
            for(int i = 1;i<tankolasok.size();i++)
            {
                int km_kulonbseg = tankolasok.get(i).iKm - tankolasok.get(i-1).iKm;
                int menny = tankolasok.get(i).iMennyiseg;
                float fogyasztas = tankolasok.get(i).iMennyiseg  * 100 / (float)km_kulonbseg;

                Date date = new Date(tankolasok.get(i).lDatum);
                fogyasztasok[i-1] = new FogyasztasiAdat(date.toString(), fogyasztas);
            }
        }


        /*fogyasztasok = new FogyasztasiAdat[]{
                new FogyasztasiAdat("a",1f)
        };*/


        RecyclerView recyclerView = view.findViewById(R.id.fogyasztasiAdatokLista);
        FogyasztasiAdatokListAdatper adapter = new FogyasztasiAdatokListAdatper(fogyasztasok);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);


        return view;
    }
}