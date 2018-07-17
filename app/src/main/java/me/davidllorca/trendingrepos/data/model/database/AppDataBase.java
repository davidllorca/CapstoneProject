package me.davidllorca.trendingrepos.data.model.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.support.annotation.NonNull;

import me.davidllorca.trendingrepos.data.model.ContributorEntry;
import me.davidllorca.trendingrepos.data.model.RepoEntry;
import me.davidllorca.trendingrepos.data.model.UserEntry;

@Database(entities = {RepoEntry.class, UserEntry.class, ContributorEntry.class}, version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class AppDataBase extends RoomDatabase {

    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "trending_repos_db";
    private static AppDataBase sInstance;

    public static AppDataBase getInstance(Context context) {
        if(sInstance == null){
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class,
                        AppDataBase.DATABASE_NAME)
                        .allowMainThreadQueries() // TODO IT'S TEMPORALLY!
                        .build();
            }
        }
        return sInstance;
    }

    public abstract RepoDao repoDao();

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }

}
