package com.backink.beetlerecord;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProjectDao {
    @Insert
    void insert (Project project);

    @Update
    void update (Project project);

    @Delete
    void delete (Project project);

    @Query("SELECT * FROM project_table")
    LiveData<List<Project>> loadAll ();
}
