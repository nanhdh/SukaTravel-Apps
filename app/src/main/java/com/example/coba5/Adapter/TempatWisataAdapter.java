package com.example.coba5.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager2.adapter.FragmentViewHolder;

import com.example.coba5.InformasiWisata;
import com.example.coba5.R;
import com.example.coba5.TempatWisata;

import java.util.ArrayList;

public class TempatWisataAdapter extends BaseAdapter {
    Context context;
    ArrayList<TempatWisata>ab;
    public TempatWisataAdapter(Context context, ArrayList<TempatWisata>ab){
        this.context = context;
        this.ab = ab;

    }
    @Override
    public int getCount() {
        return ab.size();
    }

    @Override
    public Object getItem(int position) {
        return ab.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.show_layout_wisata, null);
            holder.NamaTempatWisata = convertView.findViewById(R.id.NamaTempatWisata);
            holder.LokasiTempatWisata = convertView.findViewById(R.id.LokasiTempatWisata);
            holder.ImageTempatWisata = convertView.findViewById(R.id.ImageTempatWisata);
        convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        TempatWisata tw = ab.get(position);
        holder.NamaTempatWisata.setText(tw.getNamaWisata());
        holder.LokasiTempatWisata.setText(tw.getLokasiWisata());
        int imageName = tw.getImageName();
        int resId = ((Activity)context).getResources().getIdentifier(String.valueOf(imageName),"drawable",((Activity)context).getPackageName());
        holder.ImageTempatWisata.setImageResource(resId);
        return convertView;
    }
    class ViewHolder{
        ImageView ImageTempatWisata;
        TextView NamaTempatWisata;
        TextView LokasiTempatWisata;

    }
}
