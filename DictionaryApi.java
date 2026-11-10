package com.example.dictionaryapp.api;

import com.example.dictionaryapp.models.WordResult;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DictionaryApi {
    @GET("api/v2/entries/en/{word}")
    Call<List<WordResult>> getWordMeaning(@Path("word") String word);
}