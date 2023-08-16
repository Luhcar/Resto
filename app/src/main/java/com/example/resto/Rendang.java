package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Rendang extends AppCompatActivity {

    private TextView nama_makanan, desc, kuantitas, totalHarga;
    private ImageView img;
    private Button btnkurang, btntambah, btnPesan;
    int jumlah, totOrder = 0;
    String text;
    String txtjml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendang);

        nama_makanan = findViewById(R.id.namaMkn);
        desc = findViewById(R.id.desc);
        img = findViewById(R.id.img);
        btnkurang = findViewById(R.id.btnkurang);
        btntambah = findViewById(R.id.btntambah);
        btnPesan = findViewById(R.id.btnPesan1);
        kuantitas = findViewById(R.id.jumlah);
        totalHarga = findViewById(R.id.totalHarga);

        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int basePrice = 22500;
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
                int basePrice = 22500;
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
                String hasil = "Rendang";
                int jml = Integer.parseInt(String.valueOf(kuantitas.getText()));
                if (jml == 0){
                }else{
                    int cal = jml * 22500;
                    text = jml + "\t\t\t" +  hasil;
                    txtjml = "Rp. " + cal;
                    totOrder = totOrder + cal;
                    Intent intent = new Intent(Rendang.this, Pemesanan.class);
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

