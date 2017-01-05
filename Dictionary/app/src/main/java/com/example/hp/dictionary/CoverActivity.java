package com.example.hp.dictionary;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hp.dictionary.DatabaseHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class CoverActivity extends AppCompatActivity {

    Button bt;

    private WordListAdapter adapter;
    private List<Word> mWordList;
    private DatabaseHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);


        mDBHelper = new DatabaseHelper(this);
        File Database = getApplicationContext().getDatabasePath(DatabaseHelper.DB_NAME);
        if (!Database.exists()){
            mDBHelper.getReadableDatabase();
            //Copy DB
            if (copyDatabase(this)){
                Toast.makeText(this, "Database ready", Toast.LENGTH_LONG).show();
            }else {
                return;
            }
        }


        bt = (Button) findViewById(R.id.BT1);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CoverActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

    }
    private boolean copyDatabase(Context context){
        try{
            InputStream inputStream = getApplicationContext().getAssets().open(DatabaseHelper.DB_NAME);
            String outFileName = DatabaseHelper.DB_LOCATION + DatabaseHelper.DB_NAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[]buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0){
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("Main", "Copy Successful");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
