package com.example.dictionaryapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dictionaryapp.api.DictionaryApi;
import com.example.dictionaryapp.api.RetrofitClient;
import com.example.dictionaryapp.models.Definition;
import com.example.dictionaryapp.models.Meaning;
import com.example.dictionaryapp.models.WordResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText etSearchWord;
    private Button btnSearch;
    private TextView tvWordTitle, tvMeaning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSearchWord = findViewById(R.id.etSearchWord);
        btnSearch = findViewById(R.id.btnSearch);
        tvWordTitle = findViewById(R.id.tvWordTitle);
        tvMeaning = findViewById(R.id.tvMeaning);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = etSearchWord.getText().toString().trim();
                if (!word.isEmpty()) {
                    fetchWordData(word);
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a word", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void fetchWordData(String word) {
        DictionaryApi api = RetrofitClient.getClient();
        Call<List<WordResult>> call = api.getWordMeaning(word);

        call.enqueue(new Callback<List<WordResult>>() {
            @Override
            public void onResponse(Call<List<WordResult>> call, Response<List<WordResult>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    WordResult result = response.body().get(0);
                    tvWordTitle.setText(result.getWord());

                    StringBuilder stringBuilder = new StringBuilder();
                    for (Meaning meaning : result.getMeanings()) {
                        stringBuilder.append("• Part of Speech: ").append(meaning.getPartOfSpeech()).append("\n");
                        for (Definition def : meaning.getDefinitions()) {
                            stringBuilder.append("   - ").append(def.getDefinition()).append("\n");
                        }
                        stringBuilder.append("\n");
                    }
                    tvMeaning.setText(stringBuilder.toString());
                } else {
                    Toast.makeText(MainActivity.this, "Word not found!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WordResult>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}