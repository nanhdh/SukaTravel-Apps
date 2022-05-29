package com.example.coba5;

public class InformasiWisata {
    int IdInformasiWisata;
    String InformasiNamaWisata,InformasiLokasiWisata,InformasiDeskripsi;

    public InformasiWisata(int idInformasiWisata, String informasiNamaWisata, String informasiLokasiWisata, String informasiDeskripsi) {
        IdInformasiWisata = idInformasiWisata;
        InformasiNamaWisata = informasiNamaWisata;
        InformasiLokasiWisata = informasiLokasiWisata;
        InformasiDeskripsi = informasiDeskripsi;
    }
    public int getIdInformasiWisata() {
        return IdInformasiWisata;
    }

    public void setIdInformasiWisata(int idInformasiWisata) {
        IdInformasiWisata = idInformasiWisata;
    }

    public String getInformasiNamaWisata() {
        return InformasiNamaWisata;
    }

    public void setInformasiNamaWisata(String informasiNamaWisata) {
        InformasiNamaWisata = informasiNamaWisata;
    }
    public String getInformasiLokasiWisata() {
        return InformasiLokasiWisata;
    }

    public void setInformasiLokasiWisata(String informasiLokasiWisata) {
        InformasiLokasiWisata = informasiLokasiWisata;
    }

    public String getInformasiDeskripsi() {
        return InformasiDeskripsi;
    }

    public void setInformasiDeskripsi(String informasiDeskripsi) {
        InformasiDeskripsi = informasiDeskripsi;
    }
}
