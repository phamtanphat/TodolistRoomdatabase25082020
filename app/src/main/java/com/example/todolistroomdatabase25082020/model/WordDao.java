package com.example.todolistroomdatabase25082020.model;

import android.graphics.Bitmap;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface WordDao {

    @Query("SELECT * FROM Word")
    Maybe<List<WordEntity>> getWords();

    @Insert(onConflict =  OnConflictStrategy.IGNORE)
    Maybe<Long> insertWord(WordEntity wordEntity);

    @Update
    Maybe<Integer> updateWord(WordEntity wordEntity);

    @Delete
    Maybe<Void> deleteWord(WordEntity wordEntity);
}
