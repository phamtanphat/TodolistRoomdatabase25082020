package com.example.todolistroomdatabase25082020.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {WordEntity.class} , version = 1)
public abstract class DatabaseWord extends RoomDatabase {
    public abstract WordDao getWordDao();

    private static DatabaseWord mDatabaseWord = null;

    public static DatabaseWord getInstance(Context context) {
        if (mDatabaseWord == null) {
            mDatabaseWord = Room.databaseBuilder(
                    context,
                    DatabaseWord.class,
                    "Databaseword.sql"
            ).build();
        }
        return mDatabaseWord;
    }
}
