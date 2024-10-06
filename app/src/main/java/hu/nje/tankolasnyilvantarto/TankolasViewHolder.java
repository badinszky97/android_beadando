package hu.nje.tankolasnyilvantarto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.sql.Timestamp;

class TankolasViewHolder extends RecyclerView.ViewHolder {
    private final TextView mennyiseg;
    private final TextView idopont;
    private final TextView megjegyzes;

    private TankolasViewHolder(View itemView) {
        super(itemView);
        mennyiseg = itemView.findViewById(R.id.labelMennyiseg);
        idopont = itemView.findViewById(R.id.labelDatum);
        megjegyzes = itemView.findViewById(R.id.labelMegjegyzes);
    }

    public void bind(Tankolas ujElem) {

        megjegyzes.setText(ujElem.getWord());
        Timestamp ujidopont = new Timestamp(ujElem.iDatum);
        idopont.setText(ujidopont.toString());
        mennyiseg.setText(String.valueOf(ujElem.iMennyiseg));
    }

    static TankolasViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new TankolasViewHolder(view);
    }
}
