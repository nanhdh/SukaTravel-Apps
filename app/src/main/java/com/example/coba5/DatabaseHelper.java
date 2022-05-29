package com.example.coba5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static String DATABASE_NAME = "Library.db";
    private static int DATABASE_VERSION = 12;

    private static String TABLE_USER = "User";
    private static String COLUMN_USERID = "Userid";
    private static String COLUMN_EMAIL = "UserEmail";
    private static String COLUMN_PASSWORD = "UserPassword";
    private static String COLUMN_GENDER = "UserGender";

    private static String TABLE_InformasiW = "InformasiWisata";
    private static String COLUMN_IdInformasiWisata = "IdInformasiWisata";
    private static String COLUMN_InformasiNamaWisata = "InformasiWisata";
    private static String COLUMN_InformasiLokasiWisata = "InformasiLokasiWisata";
    private static String COLUMN_InformasiDeskripsi = "InformasiDeskripsi";

    private static String TABLE_TempatWisata = "TempatWisata";
    private static String COLUMN_IDWisata = "IdWisata";
    private static String COLUMN_NamaTempatWisata= "NamaWisata";
    private static String COLUMN_LokasiTempatWisata = "LokasiWisata";
    private static String COLUMN_DeskripsiTempatWisata = "DeskripsiWisata";
    private static String COLUMN_ImageTempatWisata = "ImageWisata";

    private static String TABLE_Booking = "Booking";
    private static String COLUMN_IDBooking = "IdBooking";
    private static String COLUMN_IDTempatWisata= "IdTempatWisata";
    private static String COLUMN_TanggalBooking = "dateBooking";
    private static String COLUMN_emailUser = "EmailUser";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query1 = " CREATE TABLE " + TABLE_USER + " ( "
                + COLUMN_USERID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_EMAIL + " TEXT, "
                + COLUMN_PASSWORD + " TEXT,"
                + COLUMN_GENDER + " Text );";
        db.execSQL(query1);
        String query2 = " CREATE TABLE " + TABLE_InformasiW + " ( "
                + COLUMN_IdInformasiWisata + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_InformasiNamaWisata + " TEXT, "
                + COLUMN_InformasiLokasiWisata + " TEXT,"
                + COLUMN_InformasiDeskripsi + " TEXT);";
        db.execSQL(query2);
        String query3 = " CREATE TABLE " + TABLE_TempatWisata+ " ( "
                + COLUMN_IDWisata + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NamaTempatWisata + " TEXT, "
                + COLUMN_LokasiTempatWisata + " TEXT,"
                + COLUMN_DeskripsiTempatWisata + " TEXT,"
                + COLUMN_ImageTempatWisata + " INTEGER);";
        db.execSQL(query3);
        query3 = "INSERT INTO " + TABLE_TempatWisata + " VALUES ('1','TMII','Jakarta','Taman Mini Indonesia Indah (TMII) merupakan suatu kawasan taman wisata bertema budaya Indonesia di Jakarta Timur. Area seluas kurang lebih 150 hektar[1] atau 1,5 kilometer persegi ini terletak Di Indonesia.',"+ R.drawable.tmii + ")";
        db.execSQL(query3);
        query3 = "INSERT INTO " + TABLE_TempatWisata + " VALUES ('2','Museum Wayang','Jakarta','Di Museum Wayang kita dapat melihat karya seni perwayangan, pengunjung juga bisa menyaksikan pergelaran Wayang yang dipandu oleh dalang profesional. Kegiatan itu diadakan di hari Minggu mulai jam 10.00 WIB.',"+ R.drawable.museum + ")";
        db.execSQL(query3);
        query3 = "INSERT INTO " + TABLE_TempatWisata + " VALUES ('3','Museum Macan','Jakarta','Museum MACAN adalah museum pertama di Indonesia yang didedikasikan untuk seni modern dan kontemporer. Bangunannya pun dirancang khusus untuk mengakomodasi fungsi museum',"+ R.drawable.museummacan + ")";
        db.execSQL(query3);

        String query4 = " CREATE TABLE " + TABLE_Booking + " ( "
                + COLUMN_IDBooking + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_IDTempatWisata + " TEXT, "
                + COLUMN_TanggalBooking + " TEXT,"
                + COLUMN_emailUser + " Text );";
        db.execSQL(query4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_InformasiW);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_TempatWisata);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_Booking);
        onCreate(db);
    }

    public boolean insertedInformasi(String informasinamawisata, String informasilokasiwisata, String informasideskripsi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_InformasiNamaWisata, informasinamawisata);
        cv.put(COLUMN_InformasiLokasiWisata, informasilokasiwisata);
        cv.put(COLUMN_InformasiDeskripsi, informasideskripsi);
        long result = db.insert(TABLE_InformasiW, null, cv);
        if (result == -1) {
            return false;
        } else
            return true;
    }

    public ArrayList<InformasiWisata> getinformasiwisata() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<InformasiWisata> arrayList = new ArrayList<InformasiWisata>();
            Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_InformasiW, null );
            while (cursor.moveToNext()){
                int id=cursor.getInt(0);
                String namawisata=cursor.getString(1);
                String lokasiwisata=cursor.getString(2);
                String deskripsiwisata=cursor.getString(3);
                InformasiWisata informasiWisata = new InformasiWisata(id,namawisata,lokasiwisata,deskripsiwisata);
                arrayList.add( informasiWisata);
            }
            return arrayList;
        }

        public ArrayList<TempatWisata> getTempatwisata() {
            SQLiteDatabase db = this.getReadableDatabase();
            ArrayList<TempatWisata> arrayList = new ArrayList<TempatWisata>();
            Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_TempatWisata, null );
            while (cursor.moveToNext()){
                int id=cursor.getInt(0);
                String namaTempatwisata=cursor.getString(1);
            String lokasiTempatwisata=cursor.getString(2);
            String deskripsiTempatwisata=cursor.getString(3);
            int imagettempat= (cursor.getInt(4));
            TempatWisata tempatWisata = new TempatWisata(id,namaTempatwisata,lokasiTempatwisata,deskripsiTempatwisata,imagettempat);
            arrayList.add( tempatWisata);

        }
        return arrayList;
    }

    public Boolean insertedUser(String email, String password, String gender) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_PASSWORD, password);
        cv.put(COLUMN_GENDER, gender);
        long result = db.insert(TABLE_USER, null,cv);
        if (result==-1){
            return false;
        } else
            return true;
    }
    public Boolean insertedBooking(int IdTempatWisata, String selecteddate, String emailuser) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_IDTempatWisata, IdTempatWisata);
        cv.put(COLUMN_TanggalBooking, selecteddate);
        cv.put(COLUMN_emailUser, emailuser);
        long result = db.insert(TABLE_Booking, null,cv);
        if (result==-1){
            return false;
        } else
            return true;
    }

    public Boolean checkLogin(String UserEmail, String UserPassword){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_EMAIL + " = ? AND " + COLUMN_PASSWORD + " = ?", new String[]{UserEmail,UserPassword});
        if (cursor.getCount()> 0){
            return true;
        }else{
           return false;
        }

    }


}
