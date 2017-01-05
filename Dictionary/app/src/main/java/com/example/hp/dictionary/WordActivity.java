package com.example.hp.dictionary;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hp.dictionary.DatabaseHelper;

public class WordActivity extends AppCompatActivity {

    TextView word;
    //TextView prononciation = (TextView) findViewById(R.id.TV4);
    TextView description;

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        Context context = getApplicationContext();
        dbHelper = new DatabaseHelper(context);

        word = (TextView) findViewById(R.id.TV4);
        description = (TextView) findViewById(R.id.TV6);

        String extras = getIntent().getStringExtra("wordtofind");
        if (extras!=null){
            findWord(extras);
        }
    }

    public void findWord(String a){
        Word res = dbHelper.getWord(a);
        if (res!= null) {
            word.setText(res.getWord());
            description.setText(res.getDescribe());
        }else {
            word.setText("NULL");
            description.setText("NULL");
        }
    }


}
