package com.example.easylearnenglish.materi;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.easylearnenglish.R;

import java.util.List;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private List<benda> bendaList;
    private MediaPlayer mediaPlayer;

    public GridAdapter(Context context, List<benda> bendaList) {
        this.context = context;
        this.bendaList = bendaList;
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public int getCount() {
        return bendaList.size();
    }

    @Override
    public Object getItem(int i) {
        return bendaList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View gridViewItem = view;

        if (gridViewItem == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridViewItem = inflater.inflate(R.layout.grid_object, null);
        }

        ImageView imageView = gridViewItem.findViewById(R.id.imageView);
        TextView textView = gridViewItem.findViewById(R.id.textView);

        imageView.setImageResource(bendaList.get(i).getImageResource());
        textView.setText(bendaList.get(i).getName());

        final int soundResource = bendaList.get(i).getSoundResource();
        gridViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
                mediaPlayer = MediaPlayer.create(context, soundResource);
                mediaPlayer.start();
            }
        });
        return gridViewItem;
    }
}