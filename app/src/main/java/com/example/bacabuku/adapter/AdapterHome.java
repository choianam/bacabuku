package com.example.bacabuku.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bacabuku.Api.Url;
import com.example.bacabuku.BacaActivity;
import com.example.bacabuku.Model.ModelHome;
import com.example.bacabuku.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class AdapterHome extends RecyclerView.Adapter<AdapterHome.HolderData> {

    private List<ModelHome> mItems ;
    private Context context;

    public AdapterHome(Context context, List<ModelHome> items){
        this.mItems = items;
        this.context = context;
    }
    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_home,parent,false);
        HolderData holderData = new HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        ModelHome md  = mItems.get(position);
        holder.tvjudul.setText(md.getJudul_buku());
        holder.tvkategori.setText(md.getKategori_buku());
        holder.tvpengarang.setText(md.getPengarang_buku());
        holder.tvpenerbit.setText(md.getPenerbit_buku());
        Picasso.get().load(Url.API_HOME+md.getNama_file()).into(holder.tvgambar);


        holder.md = md;


    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    class HolderData extends RecyclerView.ViewHolder
    {
        TextView tvjudul,tvkategori,tvpengarang, tvpenerbit;
        ImageView tvgambar;
        Button toBarang;
        ModelHome md;

        public  HolderData (View view)
        {
            super(view);

            tvjudul = (TextView) view.findViewById(R.id.judul_buku);
            tvkategori = (TextView) view.findViewById(R.id.kategori_buku);
            tvpengarang = (TextView) view.findViewById(R.id.pengarang_buku);
            tvpenerbit = (TextView) view.findViewById(R.id.penerbit_buku);
            tvgambar = (ImageView) view.findViewById(R.id.nama_file);

            toBarang = (Button) view.findViewById(R.id.toBarang);

            toBarang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent update = new Intent(context, BacaActivity.class);


                    context.startActivity(update);
                }
            });
        }
    }

}
