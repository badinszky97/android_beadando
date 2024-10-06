package hu.nje.tankolasnyilvantarto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FogyasztasiAdatok extends Fragment {
    FogyasztasiAdat[] myListData;
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

        myListData = new FogyasztasiAdat[] {
                new FogyasztasiAdat("1",1.0f),
                new FogyasztasiAdat("2",2.0f),
                new FogyasztasiAdat("3",3.0f),
                new FogyasztasiAdat("4",4.0f),
                new FogyasztasiAdat("5",5.0f),


        };

        RecyclerView recyclerView = view.findViewById(R.id.fogyasztasiAdatokLista);
        FogyasztasiAdatokListAdatper adapter = new FogyasztasiAdatokListAdatper(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);


        return view;
    }
}