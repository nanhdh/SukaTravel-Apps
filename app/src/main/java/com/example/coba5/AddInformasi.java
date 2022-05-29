package com.example.coba5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.coba5.Adapter.InformasiWisataAdapter;

import java.util.ArrayList;

public class AddInformasi extends AppCompatActivity {
    DatabaseHelper db;
    ListView listView;
    ArrayList<InformasiWisata>arrayList;
    InformasiWisataAdapter informasiadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_informasi);
        db = new DatabaseHelper(this);
        listView=findViewById(R.id.listView);
        showInformasiWisata();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AddInformasi.this,DetailInformasiWisata.class);
                intent.putExtra("POSITION", String.valueOf( position));
                startActivity( intent);
            }
        });
}

    private void showInformasiWisata() {
        arrayList=db.getinformasiwisata();
        informasiadapter = new InformasiWisataAdapter(this, arrayList);
        listView.setAdapter( informasiadapter );
        informasiadapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.insert_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        LayoutInflater inflater = (LayoutInflater) AddInformasi.this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.insert_layout, null);
       final EditText et_namaWisata = view.findViewById(R.id.etInformasiWisataNama);
       final EditText et_lokasiWisata = view.findViewById(R.id.etInformasiwisatalokasi);
       final EditText et_deskripsiWisata = view.findViewById(R.id.etInformasiWisataDeskripsi);


        AlertDialog.Builder builder = new AlertDialog.Builder(AddInformasi.this);
        builder.setView(view)
                .setPositiveButton("Add info wisata baru", new DialogInterface.OnClickListener() {
                    @Override
                    //informasinamawisata, String informasilokasiwisata, String informasideskripsi, byte[] informasiimage
                    public void onClick(DialogInterface dialogInterface, int which) {
                    String informasinamawisata = et_namaWisata.getText().toString();
                    String informasilokasiwisata = et_lokasiWisata.getText().toString();
                    String informasideskripsi = et_deskripsiWisata.getText().toString();
                   boolean res = db.insertedInformasi(informasinamawisata,informasilokasiwisata,informasideskripsi);
                   if(res==true){
                       showInformasiWisata();
                       Toast.makeText(AddInformasi.this, "Info Wisata Terbaru Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
                   }else{
                       Toast.makeText(AddInformasi.this, "Info Wisata Terbaru Gagal Ditambahkan", Toast.LENGTH_SHORT).show();
                   }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        builder.create().show();
        return super.onOptionsItemSelected(item);
    }
}