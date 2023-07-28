package com.example.easylearnenglish.materi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.easylearnenglish.R;

import java.util.ArrayList;
import java.util.List;

public class object extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // Mengatur tampilan menjadi fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        GridView gridView = findViewById(R.id.grid_object);
        GridAdapter adapter = new GridAdapter(this, createBendaList());
        gridView.setAdapter(adapter);
    }

    private List<benda> createBendaList() {
        List<benda> bendaList = new ArrayList<>();
        bendaList.add(new benda(R.drawable.papan, "Blackboard",R.raw.blackboard));
        bendaList.add(new benda(R.drawable.meja,"Table",R.raw.table));
        bendaList.add(new benda(R.drawable.kursi,"Chair",R.raw.chair));
        bendaList.add(new benda(R.drawable.tas,"Beg",R.raw.beg));
        bendaList.add(new benda(R.drawable.buku,"Book",R.raw.book));
        bendaList.add(new benda(R.drawable.pen,"Pen",R.raw.pen));
        bendaList.add(new benda(R.drawable.pensil,"Pencil",R.raw.pencil));
        bendaList.add(new benda(R.drawable.penghapus,"Eraser",R.raw.eraser));
        bendaList.add(new benda(R.drawable.rautan, "Pencil Sharpener",R.raw.pencil_sh));
        bendaList.add(new benda(R.drawable.penggaris, "Ruler",R.raw.ruler));
        bendaList.add(new benda(R.drawable.kipas, "Fan",R.raw.fan));
        bendaList.add(new benda(R.drawable.jam,"Clock",R.raw.clock));
        bendaList.add(new benda(R.drawable.lemari,"Wardrobe",R.raw.wardrobe));
        bendaList.add(new benda(R.drawable.kasur,"Bed",R.raw.bed));
        bendaList.add(new benda(R.drawable.bantal,"Pillow",R.raw.pillow));
        bendaList.add(new benda(R.drawable.boneka,"Doll",R.raw.doll));
        bendaList.add(new benda(R.drawable.kacamata, "Glasses",R.raw.glasses));
        bendaList.add(new benda(R.drawable.cermin, "Mirror",R.raw.mirror));
        bendaList.add(new benda(R.drawable.piring,"Plate",R.raw.plate));
        bendaList.add(new benda(R.drawable.gelas,"Glass",R.raw.glass));
        bendaList.add(new benda(R.drawable.sendok,"Spoon",R.raw.spoon));
        bendaList.add(new benda(R.drawable.garpu,"Fork",R.raw.fork));
        bendaList.add(new benda(R.drawable.kulkas, "Refrigerator",R.raw.refregerator));
        bendaList.add(new benda(R.drawable.payung, "Umbrella",R.raw.umbrella));
        bendaList.add(new benda(R.drawable.sepatu,"Shoes",R.raw.shoes));
        bendaList.add(new benda(R.drawable.kaos,"T-Shirt",R.raw.tshirt));
        bendaList.add(new benda(R.drawable.celana,"Pants",R.raw.pants));
        bendaList.add(new benda(R.drawable.mobil,"Car",R.raw.car));
        bendaList.add(new benda(R.drawable.bus,"Bus",R.raw.bus));
        bendaList.add(new benda(R.drawable.sepeda,"Motor Cycle",R.raw.motor));



        return bendaList;
    }

    public void backa(View view) {
        onBackPressed();
    }
}