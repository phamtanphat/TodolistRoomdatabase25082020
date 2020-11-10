package com.example.todolistroomdatabase25082020.repository;

import android.content.Context;

import com.example.todolistroomdatabase25082020.model.DatabaseWord;
import com.example.todolistroomdatabase25082020.model.WordDao;
import com.example.todolistroomdatabase25082020.model.WordEntity;

import java.util.List;

import io.reactivex.Maybe;

public class WordRepository {
    private static WordDao mWordDao = null;
    private static WordRepository mWordRepository = null;

    private WordRepository(Context context) {
        mWordDao = DatabaseWord.getInstance(context).getWordDao();
    }

    public static WordRepository getInstance(Context context){
        if (mWordRepository == null){
            mWordRepository = new WordRepository(context);
        }
        return mWordRepository;
    }

    public Maybe<List<WordEntity>> getWords(){
        return mWordDao.getWords();
    }
}
