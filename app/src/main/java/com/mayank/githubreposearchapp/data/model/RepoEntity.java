package com.mayank.githubreposearchapp.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;


@Entity(tableName = "repo_entity")
public class RepoEntity {
    @PrimaryKey
    @SerializedName("id")
    private int  item_id;

    @SerializedName("full_name")
    private  String full_name;

    @SerializedName("login")
    private String owner;

    @SerializedName("description")
    private String description;

    @SerializedName("forks_count")
    private int forks_count;

    @SerializedName("watchers_count")
    private int watchers_count;

    @SerializedName("stargazers_count")
    private  int stargazers_count;


    @SerializedName("html_url")
    private String url;



    public RepoEntity(int item_id, String full_name, String owner, String description, int forks_count, int watchers_count, int stargazers_count, String url) {
        this.item_id = item_id;
        this.full_name = full_name;
        this.owner = owner;
        this.description = description;
        this.forks_count = forks_count;
        this.watchers_count = watchers_count;
        this.stargazers_count = stargazers_count;
        this.url = url;
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

    public String getUrl() {
        return url;
    }


}
