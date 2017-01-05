package com.example.hp.dictionary;

/**
 * Created by mac on 1/5/17.
 */

public class Word {
    private String word;
    private String pronounce;
    private String describe;

    public Word(String word, String pronounce, String describe) {
        this.word = word;
        this.pronounce = pronounce;
        this.describe = describe;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPronounce() {
        return pronounce;
    }

    public void setPronounce(String pronounce) {
        this.pronounce = pronounce;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
