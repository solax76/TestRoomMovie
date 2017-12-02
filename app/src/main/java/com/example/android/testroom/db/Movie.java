package com.example.android.testroom.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Di Rienzo on 02/12/17.
 */

public class Movie {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "author")
    private String author;

    @ColumnInfo(name = "description")
    private String description;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {

        return "Title: " + title +
                ",Author: " + author +
                ",Desc: " + description;
    }
}
