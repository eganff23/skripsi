package com.example.easylearnenglish.puzzle;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.easylearnenglish.R;

import java.util.List;

public class card_Adapter extends BaseAdapter {
    private final Context context;
    private final List<card> cards;
    private final OnCardClickListener listener;

    public card_Adapter(Context context, List<card> cards, OnCardClickListener listener) {
        this.context = context;
        this.cards = cards;
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public Object getItem(int position) {
        return cards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (view == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,500));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setPadding(8,8,8,8);
        } else {
            imageView = (ImageView) view;
        }

        final card card = cards.get(i);
        if (card.isFlipped() || card.isMatched()) {
            imageView.setImageResource(card.getImageResId());
        } else {
            imageView.setImageResource(R.drawable.c_back);
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCardClick(i);
            }
        });

        return imageView;
    }
    public interface OnCardClickListener {
        void onCardClick(int i);

    }
}
