package com.backink.beetlerecord;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity (tableName = "project_table")
public class Project {

    public Project() {}

    public Project(String projectName) {
        this.projectName = projectName;
        this.createDate = new SimpleDateFormat("yyyy/mm/dd").format(new Date());
    }

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo (name = "project_name")
    public String projectName;

    @ColumnInfo (name = "create_date")
    public String createDate;
}
