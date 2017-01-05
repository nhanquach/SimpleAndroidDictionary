package com.example.hp.dictionary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 1/5/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "Temp.sqlite";
    public static final String DB_LOCATION = "data/data/com.example.hp.dictionary/databases/";
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDatabase(){
        String dbPath = mContext.getDatabasePath(DB_NAME).getPath();
        if (mDatabase != null && mDatabase.isOpen()){
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDataBase(){
        if (mDatabase != null){
            mDatabase.close();
        }
    }

    public List<Word> getListWords(){
        Word word = null;
        List<Word> wordList = new ArrayList<>();

        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM DIC",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            word = new Word(cursor.getString(0), cursor.getString(1), cursor.getString(2));
            wordList.add(word);
            cursor.moveToNext();
        }

        cursor.close();
        closeDataBase();
        return wordList;
    }

    public Word getWord(String word){
        Word resultWord = null;
        openDatabase();

        Cursor cursor = mDatabase.rawQuery("SELECT * FROM `DIC` WHERE `WORD` = '" + word + " '",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            resultWord = new Word(cursor.getString(0), cursor.getString(1), cursor.getString(2));
            cursor.moveToNext();
        }
        cursor.close();
        closeDataBase();
        return resultWord;
    }

}
