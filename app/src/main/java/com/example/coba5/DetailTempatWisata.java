package com.example.coba5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class DetailTempatWisata extends AppCompatActivity {
    TextView D2namaWisata,D2lokasiWisata, D2DeskripsiWisata, Selecteddate;
    ImageView imaged2;
    Button btnBookings;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tempat_wisata);
        D2namaWisata = findViewById(R.id.detail2_nama_wisata);
        D2lokasiWisata = findViewById(R.id.detail2_lokasi);
        D2DeskripsiWisata = findViewById(R.id.detail2_DeskripsiText);
        imaged2 = findViewById(R.id.detail2_image);
        Selecteddate = findViewById(R.id.selecteddate);
        btnBookings = findViewById(R.id.btnBooking);

        db = new DatabaseHelper(this);
        ArrayList<TempatWisata> arrayList = db.getTempatwisata();
        Intent intent = getIntent();
        String pos = intent.getStringExtra("POSITION1");
        int position = Integer.parseInt(pos);

        TempatWisata tempatWisata = arrayList.get(position);
        String DnamaTepatWisata2 = tempatWisata.getNamaWisata();
        String DlokasiTepatWisata3 = tempatWisata.getLokasiWisata();
        String DdeskripsiTepatWisata4 = tempatWisata.getDeskripsiWisata();
        int DimageTepatWisata5 = tempatWisata.getImageName();

        D2namaWisata.setText(DnamaTepatWisata2);
        D2lokasiWisata.setText(DlokasiTepatWisata3);
        D2DeskripsiWisata.setText(DdeskripsiTepatWisata4);
        imaged2.setImageResource(DimageTepatWisata5);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        Selecteddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dpg = new DatePickerDialog(DetailTempatWisata.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String date = dayOfMonth + "/" + month + "/" + year;
                        Selecteddate.setText(date);
                    }
                }, year, month, day);
                dpg.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                dpg.show();
            }
        });
        //retrive data

        btnBookings.setOnClickListener(view -> {
            String email = getIntent().getStringExtra("PembuatInformasiWisata");
            if (Selecteddate.getText().toString().equals("Tap Tulisan Untuk Atur Tanggal Booking")) {
                Toast.makeText(this, "Masukan tanggal", Toast.LENGTH_SHORT).show();
            }else{
                Boolean daftar = db.insertedBooking(tempatWisata.getIdWisata(), String.valueOf(Selecteddate.getText()), email);
                if (daftar == true) {
                    Toast.makeText(this, "Daftar berhasil", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}