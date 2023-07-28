package com.example.easylearnenglish.materi;

public class benda {
    private int imageResource;
    private String name;
    private int soundResource;

    public benda(int imageResource, String name, int soundResource) {
        this.imageResource = imageResource;
        this.name = name;
        this.soundResource = soundResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getName() {
        return name;
    }

    public int getSoundResource() {
        return soundResource;
    }
}

