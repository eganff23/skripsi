package com.example.easylearnenglish;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class listadapter extends BaseAdapter {
    private Context context;
    private List<benda> bendas;

    private static class ViewHolder {
        ImageView gambar;
        TextView benda;
        ImageView gambar2;
        TextView benda2;
        ImageView gambar3;
        TextView benda3;

    }

    public listadapter(Activity activity, List<benda> bendas) {
        this.context = activity.getBaseContext();
        this.bendas = bendas;

    }
    @Override
    public int getCount() {
        return bendas.size();
    }

    @Override
    public Object getItem(int i) {
        return bendas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view ==null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.list_item, viewGroup, false);

            holder.gambar = view.findViewById(R.id.gambar);
            holder.benda = view.findViewById(R.id.benda);
            holder.gambar2 = view.findViewById(R.id.gambar2);
            holder.benda2 = view.findViewById(R.id.benda2);
            holder.gambar3 = view.findViewById(R.id.gambar3);
            holder.benda3 = view.findViewById(R.id.benda3);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();

        }
        benda p = bendas.get(i);

        holder.gambar.setImageResource(p.getGambar());
        holder.benda.setText(p.getBenda());
        holder.gambar2.setImageResource(p.getGambar2());
        holder.benda2.setText(p.getBenda2());
        holder.gambar3.setImageResource(p.getGambar3());
        holder.benda3.setText(p.getBenda3());

        return view;
    }
}
