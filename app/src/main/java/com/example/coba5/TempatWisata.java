package com.example.coba5;

public class TempatWisata {
    int idWisata;
    String NamaWisata;
    String LokasiWisata;
    String DeskripsiWisata;
    int imageName;
    public TempatWisata(int idWisata, String namaWisata, String lokasiWisata, String deskripsiWisata, int imageName) {
        this.idWisata = idWisata;
        NamaWisata = namaWisata;
        LokasiWisata = lokasiWisata;
        DeskripsiWisata = deskripsiWisata;
        this.imageName = imageName;
    }
    public int getIdWisata() {
        return idWisata;
    }

    public void setIdWisata(int idWisata) {
        this.idWisata = idWisata;
    }

    public String getNamaWisata() {
        return NamaWisata;
    }

    public void setNamaWisata(String namaWisata) {
        NamaWisata = namaWisata;
    }

    public String getLokasiWisata() {
        return LokasiWisata;
    }

    public void setLokasiWisata(String lokasiWisata) {
        LokasiWisata = lokasiWisata;
    }

    public String getDeskripsiWisata() {
        return DeskripsiWisata;
    }

    public void setDeskripsiWisata(String deskripsiWisata) {
        DeskripsiWisata = deskripsiWisata;
    }

    public int getImageName() {
        return imageName;
    }

    public void setImageName(int imageName) {
        this.imageName = imageName;
    }
}
