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

public class baseAdapter extends BaseAdapter {
    private Context c;
    private List<isitime> isitimes;

    private static class ViewHolder {
        ImageView img_time;
        TextView namaa;
        TextView desk;
        TextView examp;
    }

    public baseAdapter(Activity activity, List<isitime> isitimes) {
        this.c = activity.getBaseContext();
        this.isitimes = isitimes;
    }

    @Override
    public int getCount() {
        return isitimes.size();
    }

    @Override
    public Object getItem(int i) {
        return isitimes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater)
                c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.list_time, viewGroup, false);
            holder.img_time = view.findViewById(R.id.img_time);
            holder.namaa = view.findViewById(R.id.namaa);
            holder.desk = view.findViewById(R.id.desk);
            holder.examp = view.findViewById(R.id.examp);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        isitime p = isitimes.get(i);

        holder.img_time.setImageResource(p.getImg_time());
        holder.namaa.setText(p.getNamaa());
        holder.desk.setText(p.getDesk());
        holder.examp.setText(p.getExamp());
        return view;
    }
}
