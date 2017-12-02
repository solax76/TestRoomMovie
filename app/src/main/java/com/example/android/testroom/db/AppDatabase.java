package com.example.android.testroom.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Di Rienzo on 02/12/17.
 */

@Database(entities = {TopRatedMovie.class, MostPopularMovie.class, FavoriteMovie.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    private static AppDatabase instance = null;
    protected AppDatabase() {
        // Exists only to defeat instantiation.
    }
    public static AppDatabase getInstance(Context applicationContext) {
        if(instance == null) {
            instance = Room.databaseBuilder(applicationContext,
                    AppDatabase.class, "test-movie").allowMainThreadQueries().build();
        }
        return instance;
    }
}
