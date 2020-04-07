package com.mayank.githubreposearchapp.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities =  {RepoEntity.class}, version = 1)
public abstract class RepoDatabase extends RoomDatabase {
    private static RepoDatabase instance;

    public abstract RepoEntityDao daoRepoEntity();

    public static synchronized RepoDatabase getInstance(Context context)
    {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    RepoDatabase.class, "repo_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
