package com.example.coba5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailInformasiWisata extends AppCompatActivity {
    TextView DnamaWisata,DlokasiWisata, DDeskripsiWisata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_informasi_wisata);
        DnamaWisata = findViewById(R.id.detail_nama_wisata);
        DlokasiWisata = findViewById(R.id.detail_lokasi_wisata);
        DDeskripsiWisata = findViewById(R.id.detail_deskripsi_wisata);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        ArrayList<InformasiWisata> arrayList = databaseHelper.getinformasiwisata();
        Intent intent=getIntent();
        String pos=intent.getStringExtra("POSITION");
        int position = Integer.parseInt( pos );
        InformasiWisata informasiWisata = arrayList.get( position);
        String DnamaWisata1 = informasiWisata.getInformasiNamaWisata();
        String DLokasiWisata2 = informasiWisata.getInformasiLokasiWisata();
        String DDeskripsiLokasi3 = informasiWisata.getInformasiDeskripsi();
        DnamaWisata.setText(DnamaWisata1);
        DlokasiWisata.setText(DLokasiWisata2);
        DDeskripsiWisata.setText(DDeskripsiLokasi3);
    }
}