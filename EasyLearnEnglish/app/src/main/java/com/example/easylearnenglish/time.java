package com.example.easylearnenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class time extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        ListView list = findViewById(R.id.list_time);
        baseAdapter adapter = new baseAdapter(this,createisitimes());

        list.setAdapter(adapter);
    }

    private List<isitime> createisitimes(){
        List<isitime>data = new ArrayList<>();
        data.add(new isitime(R.drawable.clock,"O’clock","Digunakan ketika jarum jam panjang menunjukkan pada angka 12\n"+
                "Example :",
                "03.00 = Three o’clock\n"+"10.00 = Ten o’clock"));
        data.add(new isitime(R.drawable.past,"Quarter Past","Digunakan ketika jarum jam panjang menunjukkan pada angka 3\n"+
                "Example","01.15 = Quarter past one\n"+"09.15 = Quarter past nine"));
        data.add(new isitime(R.drawable.to,"Quarter To","Digunakan ketika jarum jam panjang menunjukkan pada angka 9\n"+
                "Example","06.45 = Quarter to seven\n"+"10.45 = Quarter to eleven"));
        data.add(new isitime(R.drawable.halfpast,"Half Past","Digunakan ketika jarum jam panjang menunjukkan pada angka 6\n"+
                "Example","06.30 = Half past six\n"+"01.30 = Half past one"));
        data.add(new isitime(R.drawable.timee,"Past and To","Past berarti lebih, digunakan saat jarum jam panjang kurang dari 30 (tidak melewati angka 6)\n"+
                "To berari kurang, digunakan saat jarum jam panjang lebih dari 30(melewati angka 6)\n"+"Example",
                "10.20 = Twenty past ten\n"+"10.50 = Ten to eleven"));
    return data;
    }


    public void backe(View view) {
        onBackPressed();
    }
}