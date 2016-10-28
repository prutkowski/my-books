package com.pawel_rutkowski.mybooks.api;


import com.pawel_rutkowski.mybooks.data.Repo;
import com.pawel_rutkowski.mybooks.data.RepositoriesSearch;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHubClient {

    @GET("/search/repositories")
    Call<RepositoriesSearch> repos(@Query("q") String repoSearchName);

    @GET("/search/repositories")
    Call<List<Repo>> reposList(@Query("q") String repoSearchName);

    @GET("/users/{user}/repos")
    Call<List<TransferClasses.Repository>> listRepos(@Path("user") String user);
}
