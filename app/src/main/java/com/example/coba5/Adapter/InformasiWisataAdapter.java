package com.example.coba5.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.coba5.InformasiWisata;
import com.example.coba5.R;

import java.util.ArrayList;

public class InformasiWisataAdapter extends BaseAdapter {
    Context context;
    ArrayList<InformasiWisata>arrayList;
    public InformasiWisataAdapter(Context context, ArrayList<InformasiWisata> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return arrayList.get( position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE);
        convertview = inflater.inflate(R.layout.show_layout, null);
        TextView namaWisata = convertview.findViewById( R.id.wisata_nama);
        TextView lokasiWisata = convertview.findViewById( R.id.wisata_Lokasi);
        InformasiWisata informasiWisata=arrayList.get(position);
        String nWisata = informasiWisata.getInformasiNamaWisata();
        String LWisata = informasiWisata.getInformasiLokasiWisata();
        namaWisata.setText( nWisata);
        lokasiWisata.setText( LWisata);
        return convertview;
    }
}
