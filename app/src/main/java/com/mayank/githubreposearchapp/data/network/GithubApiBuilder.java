package com.mayank.githubreposearchapp.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubApiBuilder {
    public static final String BASE_URL= "https://api.github.com";

    private Retrofit retrofit;

    public GithubApiBuilder()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public GitHubClient getService()
    {
        return retrofit.create(GitHubClient.class);
    }
}
