package hu.nje.tankolasnyilvantarto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class FogyasztasiAdatokListAdatper extends RecyclerView.Adapter<FogyasztasiAdatokListAdatper.ViewHolder>{
    private FogyasztasiAdat[] listdata;

    // RecyclerView recyclerView;
    public FogyasztasiAdatokListAdatper(FogyasztasiAdat[] listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.fogyasztasi_adatok_recycle_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final FogyasztasiAdat myListData = listdata[position];
        holder.fogyasztas.setText(String.valueOf(listdata[position].getFogyasztas()) + " l/100km");
        holder.datum.setText(String.valueOf(listdata[position].getDatum()));
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView fogyasztas;
        public TextView datum;

        public ViewHolder(View itemView) {
            super(itemView);
            this.fogyasztas = itemView.findViewById(R.id.labelFogyasztasiAdatFogyasztas);
            this.datum = itemView.findViewById(R.id.labelFogyasztasiAdatDatum);

        }
    }
}