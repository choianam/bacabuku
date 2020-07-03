package com.example.bacabuku.Model;

public class ModelLibrary {
    private String judul_buku1, kategori_buku1, pengarang_buku1, penerbit_buku1;

    public ModelLibrary(){}

    public ModelLibrary(String judul_buku1, String kategori_buku1, String pengarang_buku1, String penerbit_buku1) {
        this.judul_buku1 = judul_buku1;
        this.kategori_buku1 = kategori_buku1;
        this.pengarang_buku1 = pengarang_buku1;
        this.penerbit_buku1 = penerbit_buku1;
    }

    public String getJudul_buku1() {
        return judul_buku1;
    }
    public void setJudul_buku1(String judul_buku1){
        this.judul_buku1 = judul_buku1;
    }
    public String getKategori_buku1(){
        return kategori_buku1;
    }
    public void setKategori_buku1(String kategori_buku1){
        this.kategori_buku1 = kategori_buku1;
    }
    public String getPengarang_buku1(){
        return pengarang_buku1;
    }
    public void setPengarang_buku1(String pengarang_buku1){
        this.pengarang_buku1 = pengarang_buku1;
    }
    public String getPenerbit_buku1(){
        return penerbit_buku1;
    }
    public void setPenerbit_buku1(String penerbit_buku1){
        this.penerbit_buku1 = penerbit_buku1;
    }
}

