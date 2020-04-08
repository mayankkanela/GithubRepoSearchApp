package com.mayank.githubreposearchapp.data.repository;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.mayank.githubreposearchapp.data.model.RepoEntity;

import java.util.List;

@Dao
public interface RepoEntityDao {
    @Insert
    void insert(RepoEntity repoEntity);

    @Update
    void update(RepoEntity repoEntity);

    @Delete
    void delete(RepoEntity repoEntity);

    @Query("DELETE FROM repo_entity")
    void deleteAllRepoEntity();

    @Query("SELECT * FROM repo_entity")
    LiveData<List<RepoEntity>> getAllRepo();

}
