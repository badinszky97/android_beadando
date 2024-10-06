package hu.nje.tankolasnyilvantarto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class ElozoTankolasok extends Fragment {
    FloatingActionButton hozzaadGomb;
    public ElozoTankolasok() {
        // Required empty public constructor
    }


    public static ElozoTankolasok newInstance() {
        ElozoTankolasok fragment = new ElozoTankolasok();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        MainActivity mainActivity = (MainActivity)getActivity();
        View view = inflater.inflate(R.layout.fragment_elozo_tankolasok, container, false);

        hozzaadGomb=view.findViewById(R.id.uj_tankolasgomb);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        final TankolasListAdapter adapter = new TankolasListAdapter(new TankolasListAdapter.WordDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mainActivity.getBaseContext()));
        mainActivity.mTankolasViewModel = new ViewModelProvider(this).get(TankolasViewModel.class);

        mainActivity.mTankolasViewModel.getAllWords().observe(getViewLifecycleOwner(), words -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(words);
        });
        hozzaadGomb.setOnClickListener( v -> {
            List<Tankolas> asd = adapter.getCurrentList();
            ShowMeassage("asd");
        });
        return view;
    }

    private void ShowMeassage(String message)
    {
        MainActivity mainActivity = (MainActivity)getActivity();
        mainActivity.UjTankolasFragment();
    }
}