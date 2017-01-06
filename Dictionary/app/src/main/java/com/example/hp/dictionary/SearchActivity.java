package com.example.hp.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;
import java.util.Objects;

public class SearchActivity extends AppCompatActivity {

    Button bt2;
    EditText searchString;
    WordListAdapter adapter;
    DatabaseHelper mDBHelper;
    List<Word> mWordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        bt2 = (Button) findViewById(R.id.searchButton);
        searchString = (EditText) findViewById(R.id.searchEditText);

        mDBHelper = new DatabaseHelper(this);

        ListView listView = (ListView) findViewById(R.id.DictionaryListView);
        mWordList = mDBHelper.getListWords();
        adapter = new WordListAdapter(this, mWordList);
        listView.setAdapter(adapter);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SearchActivity.this, WordActivity.class);

                Log.w("Search", searchString.getText().toString());
                //Send word
                intent1.putExtra("wordtofind", searchString.getText().toString());
                startActivity(intent1);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String SelectedWord = parent.getAdapter().getItem(position).toString().trim();

                Intent intent1 = new Intent(SearchActivity.this, WordActivity.class);
                intent1.putExtra("wordtofind", SelectedWord);
                startActivity(intent1);
            }
        });


    }
}
