package com.example.resto;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestoAdapter extends RecyclerView.Adapter<RestoAdapter.ViewHolder> {

    private ArrayList<Resto> listResto;
    private Context context;

    public RestoAdapter(Context context, ArrayList<Resto> listResto) {
        this.context = context;
        this.listResto = listResto;
    }

    @NonNull
    @Override
    public RestoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.item_resto, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestoAdapter.ViewHolder holder, int position) {
        Resto resto = listResto.get(position);
        holder.txtNama.setText(resto.getNama());
        holder.txtdesc.setText(resto.getDeskripsi());
        holder.txtharga.setText(resto.getHarga());
        holder.imgFoto.setImageResource(resto.getId_gambar());

        holder.btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0){
                    Intent intent = new Intent(context, Rendang.class);
                    context.startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(context, cumi.class);
                    context.startActivity(intent);
                } else if (position == 2) {
                    Intent intent =new Intent(context, Udang.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listResto.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtNama, txtdesc,txtharga;
        public ImageView imgFoto;
        public Button btnPesan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNama = (TextView) itemView.findViewById(R.id.txtNama);
            txtdesc = (TextView) itemView.findViewById(R.id.txtDesc);
            txtharga = (TextView) itemView.findViewById(R.id.txtHarga);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            this.btnPesan = (Button) itemView.findViewById(R.id.btnPesan);
        }
    }
}
