package com.example.easylearnenglish.puzzle;

public class card {
    private final int imageResId;
    private boolean isMatched;
    private boolean isFlipped;

    public card(int imageResId) {
        this.imageResId = imageResId;
        this.isMatched = false;
        this.isFlipped = false;
    }

    public int getImageResId() {
        return imageResId;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public void setFlipped(boolean flipped) {
        isFlipped = flipped;
    }
}
