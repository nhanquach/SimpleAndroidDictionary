package com.example.hp.dictionary;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mac on 1/5/17.
 */

public class WordListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Word> mWordList;

    public WordListAdapter(Context mContext, List<Word> mWordList) {
        this.mContext = mContext;
        this.mWordList = mWordList;
    }

    @Override
    public int getCount() {
        return mWordList.size();
    }

    @Override
    public String getItem(int position) {
        return mWordList.get(position).getWord().toString();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.itemlistview, null);
        TextView word = (TextView) v.findViewById(R.id.word);

        if (mWordList.get(position).getWord() != null)
            word.setText(mWordList.get(position).getWord().toString());
        return v;
    }
}
