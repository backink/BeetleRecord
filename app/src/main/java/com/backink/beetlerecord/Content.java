package com.backink.beetlerecord;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Content {
    @PrimaryKey (autoGenerate = true)
    public int id;

    @ColumnInfo
    public int num;
}
