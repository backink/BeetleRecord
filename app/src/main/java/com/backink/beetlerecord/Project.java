package com.backink.beetlerecord;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "project_table")
public class Project {

    public Project() {
        this.projectName = "My Project";
    }

    public Project(String projectName) {
        this.projectName = projectName;
    }

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo (name = "project_name")
    public String projectName;
}
