package com.example.todolistroomdatabase25082020.model;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

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
