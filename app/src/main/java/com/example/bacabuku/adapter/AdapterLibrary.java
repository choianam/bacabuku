package com.example.bacabuku.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bacabuku.Api.Url;
import com.example.bacabuku.BacaActivity;
import com.example.bacabuku.Model.ModelHome;
import com.example.bacabuku.Model.ModelLibrary;
import com.example.bacabuku.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterLibrary extends RecyclerView.Adapter<AdapterLibrary.HolderData> {

    private List<ModelLibrary> mItems ;
    private Context context;

    public AdapterLibrary(Context context, List<ModelLibrary> items){
        this.mItems = items;
        this.context = context;
    }
    @Override
    public AdapterLibrary.HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_library,parent,false);
        AdapterLibrary.HolderData holderData = new AdapterLibrary.HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder(AdapterLibrary.HolderData holder, int position) {
        ModelLibrary md  = mItems.get(position);
        holder.tvjudul.setText(md.getJudul_buku1());
        holder.tvkategori.setText(md.getKategori_buku1());
        holder.tvpengarang.setText(md.getPengarang_buku1());
        holder.tvpenerbit.setText(md.getPenerbit_buku1());


        holder.md = md;

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    class HolderData extends RecyclerView.ViewHolder
    {
        TextView tvjudul,tvkategori,tvpengarang, tvpenerbit;
        Button toBarang;
        ModelLibrary md;

        public  HolderData (View view)
        {
            super(view);

            tvjudul = (TextView) view.findViewById(R.id.judul_buku1);
            tvkategori = (TextView) view.findViewById(R.id.kategori_buku1);
            tvpengarang = (TextView) view.findViewById(R.id.pengarang_buku1);
            tvpenerbit = (TextView) view.findViewById(R.id.penerbit_buku1);

            toBarang = (Button) view.findViewById(R.id.toBarang1);

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
