package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pemesanan extends AppCompatActivity {

    private TextView jmlmkn, hrgmkn, totbayar;
    private Button btnmenu;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemesanan);

        jmlmkn = findViewById(R.id.jmlmkn);
        hrgmkn = findViewById(R.id.hrgmkn);
        totbayar = findViewById(R.id.totbayar);
        btnmenu = findViewById(R.id.btnmenu);

        Intent intent = getIntent();
        String sum = intent.getStringExtra("Coba");
        String hrg = intent.getStringExtra("total");
        int tot = intent.getIntExtra("Bayar", 0);

        jmlmkn.setText(sum);
        hrgmkn.setText(hrg);
        totbayar.setText("Rp. "+tot);

        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pemesanan.this, MainActivity.class);
                startActivity(intent);
            }

        });
    }

}