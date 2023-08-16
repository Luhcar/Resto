package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class cumi extends AppCompatActivity {

    private TextView nama_makanan, desc, kuantitas, totalHarga;
    private ImageView img;
    private Button btnkurang, btntambah, btnPesan;
    int jumlah, totOrder = 0;
    String text, txtjml;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cumi);

        nama_makanan = findViewById(R.id.namaMkn1);
        desc = findViewById(R.id.desc1);
        kuantitas = findViewById(R.id.jumlah1);
        totalHarga = findViewById(R.id.totalHarga1);
        img = findViewById(R.id.img1);
        btnkurang = findViewById(R.id.btnkurang1);
        btntambah = findViewById(R.id.btntambah1);
        btnPesan = findViewById(R.id.btnPesan2);

        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int basePrice = 30000;
                jumlah++;
                tampilHarga();
                int priceView = basePrice * jumlah;
                String setnewPrice = String.valueOf(priceView);
                totalHarga.setText("Rp. " + setnewPrice);
            }
        });
        btnkurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int basePrice = 30000;
                if (jumlah == 0){
                } else {
                    jumlah--;
                    tampilHarga();
                    int priceView = basePrice * jumlah;
                    String setnewPrice = String.valueOf(priceView);
                    totalHarga.setText("Rp. "+setnewPrice);
                }
            }
        });
        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hasil = "Cumi";
                int jml = Integer.parseInt(String.valueOf(kuantitas.getText()));
                if (jml == 0){
                }else{
                    int cal = jml * 30000;
                    text = jml + "\t\t\t" +  hasil;
                    txtjml = "Rp. " + cal;
                    totOrder = totOrder + cal;

                    Intent intent = new Intent(cumi.this, Pemesanan.class);
                    intent.putExtra("Coba", text);
                    intent.putExtra("total", txtjml);
                    intent.putExtra("Bayar", totOrder);
                    startActivity(intent);
                }

            }
        });
    }
    private void tampilHarga(){
        kuantitas.setText(String.valueOf(jumlah));
    }

    }

