package com.mayank.githubreposearchapp.data.network;

import com.google.gson.annotations.SerializedName;
import com.mayank.githubreposearchapp.data.model.RepoEntity;

import java.util.List;

public class ResponseObject {

    @SerializedName("items")
    private List<RepoEntity> repoEntities;

    public List<RepoEntity> getRepoEntities() {
        return repoEntities;
    }
}
