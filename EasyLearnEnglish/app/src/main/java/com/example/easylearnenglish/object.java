package com.example.easylearnenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class object extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        ListView list = findViewById(R.id.list_object);
        listadapter adapter = new listadapter(this, createbenda());

        list.setAdapter(adapter);
    }

    private List<benda> createbenda() {
        List<benda> data = new ArrayList<>();
        data.add(new benda(R.drawable.papan, "Blackboard",R.drawable.meja, "Table",R.drawable.kursi,"Chair"));
        data.add(new benda(R.drawable.tas,"Beg",R.drawable.buku,"Book",R.drawable.pen,"Pen"));
        data.add(new benda(R.drawable.pensil,"Pencil",R.drawable.penghapus,"Eraser",R.drawable.rautan, "Pencil Sharpener"));
        data.add(new benda(R.drawable.penggaris, "Ruler",R.drawable.kipas, "Fan",R.drawable.jam,"Clock"));
        data.add(new benda(R.drawable.lemari,"Wardrobe",R.drawable.kasur,"Bed",R.drawable.bantal,"Pillow"));
        data.add(new benda(R.drawable.boneka,"Doll",R.drawable.kacamata,"Glasses",R.drawable.cermin,"Mirror"));
        data.add(new benda(R.drawable.piring,"Plate",R.drawable.gelas,"Glass",R.drawable.sendok,"Spoon"));
        data.add(new benda(R.drawable.garpu, "Fork",R.drawable.kulkas,"Refrigerator",R.drawable.payung,"Umbrella"));
        data.add(new benda(R.drawable.sepatu,"Shoes",R.drawable.kaos,"T-Shirt",R.drawable.celana,"Pants"));
        data.add(new benda(R.drawable.mobil,"Car",R.drawable.bus,"Bus",R.drawable.sepeda,"Motorcycle"));
        data.add(new benda(R.drawable.sepedaa,"Bike",R.drawable.kereta,"Train",R.drawable.kapal,"Ship"));
        data.add(new benda(R.drawable.anjing,"Dog",R.drawable.ayam,"Chicken",R.drawable.babi,"Pig"));
        data.add(new benda(R.drawable.bebek,"Duck",R.drawable.buaya,"Crocodile",R.drawable.domba,"Sheep"));
        data.add(new benda(R.drawable.gajah,"Elephent",R.drawable.ikan,"Fish",R.drawable.macan,"Tiger"));
        data.add(new benda(R.drawable.kucing,"Cat",R.drawable.kelinci,"Rabbit",R.drawable.sapi,"Cow"));
        data.add(new benda(R.drawable.singa,"Lion",R.drawable.ular,"Snake",R.drawable.tikus,"Mouse"));

        return data;

    }

    public void backa(View view) {
        onBackPressed();
    }
}