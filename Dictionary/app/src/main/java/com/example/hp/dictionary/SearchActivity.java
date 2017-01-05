package com.example.hp.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {

    Button bt2;
    EditText searchString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        bt2 = (Button) findViewById(R.id.searchButton);
        searchString = (EditText) findViewById(R.id.searchEditText);

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
    }
}
