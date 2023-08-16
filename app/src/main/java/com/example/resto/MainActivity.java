package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recResto;
    private ArrayList<Resto> listResto;
    private RestoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recResto = findViewById(R.id.rec_resto);
        initData();

        recResto.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RestoAdapter(this, listResto);
        recResto.setAdapter(adapter);

    }

    private void initData(){
        this.listResto = new ArrayList<>();
        listResto.add(new Resto("Rendang", "daging sapi yang diolah dengan \nbumbu khas",
                "22.500",R.drawable.rendang ));
        listResto.add(new Resto("Cumi Bakar", "Cumi bakar dengan saos padang",
                "30.000",R.drawable.cumi1 ));
        listResto.add(new Resto("Udang Bakar", "Udang bakar dengan saos padang",
                "27.500",R.drawable.udang1 ));
    }

}