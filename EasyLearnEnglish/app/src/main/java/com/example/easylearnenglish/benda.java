package com.example.easylearnenglish;

public class benda {
    private int gambar;
    private String benda;
    private int gambar2;
    private String benda2;
    private int gambar3;
    private String benda3;

    public benda(int gambar,String benda,int gambar2,String benda2,int gambar3,String benda3) {
        this.gambar = gambar;
        this.benda = benda;
        this.gambar2 = gambar2;
        this.benda2 = benda2;
        this.gambar3 = gambar3;
        this.benda3 = benda3;
    }

    public int getGambar() {
        return gambar;
    }
    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getBenda() {
        return benda;
    }
    public void setBenda(String benda){
        this.benda = benda;
    }
    public int getGambar2() {
        return gambar2;
    }
    public void setGambar2(int gambar2) {
        this.gambar2 = gambar2;
    }

    public String getBenda2() {
        return benda2;
    }
    public void setBenda2(String benda2){
        this.benda2 = benda2;
    }
    public int getGambar3() {
        return gambar3;
    }
    public void setGambar3(int gambar3) {
        this.gambar3 = gambar3;
    }

    public String getBenda3() {
        return benda3;
    }
    public void setBenda3(String benda3){
        this.benda3 = benda3;
    }
}
