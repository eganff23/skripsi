package com.example.easylearnenglish.materi;

public class isitime {
    private int img_time;
    private String namaa;
    private String desk;
    private String examp;

    public isitime(int img_time, String namaa, String desk, String examp){
        this.img_time = img_time;
        this.namaa = namaa;
        this.desk = desk;
        this.examp = examp;
    }

    public  int getImg_time(){
        return img_time;
    }
    public void setImg_time(int img_time){
        this.img_time = img_time;
    }
    public String getNamaa(){
        return namaa;
    }
    public void setNamaa(String namaa){
        this.namaa = namaa;
    }
    public String getDesk(){
        return desk;
    }
    public void  setDesk(String desk){
        this.desk = desk;
    }
    public String getExamp(){
        return examp;
    }
    public void setExamp(String examp){
        this.examp = examp;
    }
}
