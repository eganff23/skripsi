package com.example.newdinamis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VerbAdapter extends RecyclerView.Adapter<VerbAdapter.VerbViewHolder> {
    private List<Verb> verbList;

    public VerbAdapter(List<Verb> verbList) {
        this.verbList = verbList;
    }

    @NonNull
    @Override
    public VerbViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_verb, parent, false);
        return new VerbViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerbViewHolder holder, int position) {
        Verb verb = verbList.get(position);
        holder.verbNameTextView.setText(verb.getVerbName());
    }

    @Override
    public int getItemCount() {
        return verbList.size();
    }

    public static class VerbViewHolder extends RecyclerView.ViewHolder {
        TextView verbNameTextView;

        public VerbViewHolder(@NonNull View itemView) {
            super(itemView);
            verbNameTextView = itemView.findViewById(R.id.verbNameTextView);
        }
    }
}
