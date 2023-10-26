package com.backink.beetlerecord;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Project.class}, version = 0)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    public abstract ProjectDao projectDao();

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "my-database").build();
        }
        return instance;
    }
}
