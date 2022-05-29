package com.example.coba5.TempatWisataDao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.coba5.DatabaseHelper;
import com.example.coba5.TempatWisata;

import java.util.ArrayList;

public class TempatWisataDao {
    DatabaseHelper db;
    public TempatWisataDao(Context context){
        db = new DatabaseHelper(context);
    }
    public ArrayList<TempatWisata> getAll(){
        ArrayList<TempatWisata> ds= new ArrayList<>();
        SQLiteDatabase sdb = db.getReadableDatabase();
        String TABLE_TempatWisata = "TempatWisata";
        Cursor cs = sdb.rawQuery(" SELECT * FROM  "+TABLE_TempatWisata, null);

        cs.moveToFirst();
        while(!cs.isAfterLast()){
            int idWisata = cs.getInt(0);
            String namaWisata = cs.getString(1);
            String lokasiWisata = cs.getString(2);
            String deskripsiWisata = cs.getString(3);
            int imageName = (cs.getInt(4));
            TempatWisata tw = new TempatWisata(idWisata,namaWisata,lokasiWisata,deskripsiWisata,imageName);
            ds.add(tw);
            cs.moveToNext();
        }
        return ds;
    }

}
