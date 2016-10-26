package com.pawel_rutkowski.mybooks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.pawel_rutkowski.mybooks.api.GitHubClient;
import com.pawel_rutkowski.mybooks.api.ServiceGenerator;
import com.pawel_rutkowski.mybooks.model.RepositoriesSearch;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GitHubClient client = ServiceGenerator.createService(GitHubClient.class);


        Call<RepositoriesSearch> call = client.repos("arduino");

        call.enqueue(new Callback<RepositoriesSearch>() {
            @Override
            public void onResponse(Call<RepositoriesSearch> call, Response<RepositoriesSearch> response) {
                RepositoriesSearch repositoriesSearch = response.body();

                Log.i("LOGTAG", "Response count: " + repositoriesSearch.totalCount);

            }

            @Override
            public void onFailure(Call<RepositoriesSearch> call, Throwable t) {

            }
        });


    }
}
