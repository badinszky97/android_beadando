package hu.nje.tankolasnyilvantarto;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class TankolasListAdapter extends ListAdapter<Tankolas, TankolasViewHolder> {

    public TankolasListAdapter(@NonNull DiffUtil.ItemCallback<Tankolas> diffCallback) {
        super(diffCallback);
    }

    @Override
    public TankolasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return TankolasViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(TankolasViewHolder holder, int position) {
        Tankolas current = getItem(position);
        holder.bind(current.getWord());
    }

    static class WordDiff extends DiffUtil.ItemCallback<Tankolas> {

        @Override
        public boolean areItemsTheSame(@NonNull Tankolas oldItem, @NonNull Tankolas newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Tankolas oldItem, @NonNull Tankolas newItem) {
            return oldItem.getWord().equals(newItem.getWord());
        }
    }
}
