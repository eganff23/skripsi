package com.example.easylearnenglish.ujian;

public class tanya {
    private int gambar;
    private String soal;
    private String opsi1;
    private String opsi2;
    private String opsi3;
    private int jawabBenar;

    public tanya (int gambar, String soal, String opsi1, String opsi2, String opsi3, int jawabBenar){
        this.gambar = gambar;
        this.soal = soal;
        this.opsi1 = opsi1;
        this.opsi2 = opsi2;
        this.opsi3 = opsi3;
        this.jawabBenar = jawabBenar;
    }
    public int getGambar(){
        return gambar;
    }
    public String getSoal(){
        return soal;
    }
    public String getOpsi1() {
        return opsi1;
    }
    public String getOpsi2() {
        return opsi2;
    }
    public String getOpsi3() {
        return opsi3;
    }
    public int getJawabBenar(){
        return jawabBenar;
    }
}

