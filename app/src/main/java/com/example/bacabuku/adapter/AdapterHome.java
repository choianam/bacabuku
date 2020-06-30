package com.example.bacabuku.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bacabuku.Model.ModelHome;
import com.example.bacabuku.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class AdapterHome extends BaseAdapter {

    private Context context;
    private ArrayList<ModelHome> dataModelArrayList;

    public AdapterHome(Context context, ArrayList<ModelHome> dataModelArrayList){
        this.context = context;
        this.dataModelArrayList = dataModelArrayList;
    }
    @Override
    public int getViewTypeCount(){
        return getCount();
    }
    @Override
    public int getItemViewType(int position){
        return position;
    }
    @Override
    public int getCount(){
        return dataModelArrayList.size();
    }
    @Override
    public Object getItem(int position){
        return dataModelArrayList.get(position);
    }
    @Override
    public long getItemId(int position){
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;

        if (convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.content_home, null, true);

            holder.iv = (ImageView) convertView.findViewById((R.id.nama_file));
            holder.tvjudul = (TextView) convertView.findViewById(R.id.judul_buku);
            holder.tvcategory = (TextView) convertView.findViewById(R.id.kategori_buku);
            holder.tvpenulis = (TextView) convertView.findViewById(R.id.pengarang_buku);
            holder.tvpenerbit = (TextView) convertView.findViewById(R.id.penerbit_buku);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        Picasso.get().load(dataModelArrayList.get(position).getNama_file()).into(holder.iv);
        holder.tvjudul.setText("Judul:"+dataModelArrayList.get(position).getJudul_buku());
        holder.tvcategory.setText("Kategori:"+dataModelArrayList.get(position).getKategori_buku());
        holder.tvpenulis.setText("Penulis:"+dataModelArrayList.get(position).getPengarang_buku());
        holder.tvpenerbit.setText("Penerbit:"+dataModelArrayList.get(position).getPenerbit_buku());

        return convertView;
    }
    private class ViewHolder{
        protected TextView tvjudul, tvcategory, tvpenulis, tvpenerbit;
        protected ImageView iv;
    }

}
