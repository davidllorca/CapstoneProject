package me.davidllorca.trendingrepos.data.model.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import me.davidllorca.trendingrepos.data.model.RepoEntry;

@Dao
public interface RepoDao {

    @Query("SELECT * FROM repo")
    LiveData<List<RepoEntry>> loadFavouriteRepos();

    @Insert
    void insertRepo(RepoEntry repoEntry);

    @Delete
    void deleteRepo(RepoEntry repoEntry);

}
