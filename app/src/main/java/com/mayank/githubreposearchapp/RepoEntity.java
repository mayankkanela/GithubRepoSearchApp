package com.mayank.githubreposearchapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "repo_entity")
public class RepoEntity {
    @PrimaryKey
    private int  item_id;

    private  String full_name;

    private String owner;

    private String description;

    private int forks_count;

    private int watchers_count;

    private  int stargazers_count;

    public RepoEntity(int item_id, String full_name, String owner, String description, int forks_count, int watchers_count, int stargazers_count) {
        this.item_id = item_id;
        this.full_name = full_name;
        this.owner = owner;
        this.description = description;
        this.forks_count = forks_count;
        this.watchers_count = watchers_count;
        this.stargazers_count = stargazers_count;
    }

    public int getItem_id() {
        return item_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getOwner() {
        return owner;
    }

    public String getDescription() {
        return description;
    }

    public int getForks_count() {
        return forks_count;
    }

    public int getWatchers_count() {
        return watchers_count;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }
}
