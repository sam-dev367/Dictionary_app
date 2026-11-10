package com.example.dictionaryapp.models;

import java.util.List;

public class Meaning {
    private String partOfSpeech;
    private List<Definition> definitions;

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }
}