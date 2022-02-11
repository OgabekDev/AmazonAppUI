package dev.ogabek.amazonappui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.amazonappui.R;
import dev.ogabek.amazonappui.model.Essential;

public class EssentialAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Essential> items;

    public EssentialAdapter(List<Essential> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_essential, parent, false);
        return new EssentialViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Essential essential = items.get(position);

        if (holder instanceof EssentialViewHolder) {
            ((EssentialViewHolder) holder).image.setImageResource(essential.getImage());
            ((EssentialViewHolder) holder).title.setText(essential.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private static class EssentialViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;

        public EssentialViewHolder(View view) {
            super(view);

            title = view.findViewById(R.id.tv_title);
            image = view.findViewById(R.id.iv_image);


        }
    }
}
