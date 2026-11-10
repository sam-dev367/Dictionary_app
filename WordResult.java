package com.example.dictionaryapp.models;

import java.util.List;

public class WordResult {
    private String word;
    private List<Meaning> meanings;

    public String getWord() {
        return word;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }
}