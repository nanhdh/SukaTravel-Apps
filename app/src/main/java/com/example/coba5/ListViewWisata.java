package com.example.coba5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.coba5.Adapter.TempatWisataAdapter;
import com.example.coba5.TempatWisataDao.TempatWisataDao;

import java.util.ArrayList;

public class ListViewWisata extends AppCompatActivity {
    ListView lv;
    ArrayList<TempatWisata>ab;
    TempatWisataAdapter tempatWisataAdapter;
    TempatWisataDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_wisata);
        dao = new TempatWisataDao(ListViewWisata.this);
        ab = dao.getAll();
        lv = findViewById(R.id.listView2);
        tempatWisataAdapter = new TempatWisataAdapter(ListViewWisata.this,ab);
        lv.setAdapter(tempatWisataAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            String email = getIntent().getStringExtra("PembuatInformasiWisata");
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListViewWisata.this,DetailTempatWisata.class);
                intent.putExtra("POSITION1", String.valueOf( position));
                intent.putExtra("PembuatInformasiWisata", email);
                Log.d("TAG", "userEMAIL" + email);
                startActivity( intent);

            }
        });
    }
}