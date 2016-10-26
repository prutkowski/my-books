package com.pawel_rutkowski.mybooks.api;


import com.pawel_rutkowski.mybooks.model.RepositoriesSearch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubClient {

    @GET("/search/repositories")
    Call<RepositoriesSearch> repos(@Query("q") String repoSearchName);
}
