package com.pawel_rutkowski.mybooks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.pawel_rutkowski.mybooks.api.GitHubClient;
import com.pawel_rutkowski.mybooks.api.ServiceGenerator;
import com.pawel_rutkowski.mybooks.api.TransferClasses;
import com.pawel_rutkowski.mybooks.mappers.RepositoriesMapper;
import com.pawel_rutkowski.mybooks.data.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RepositoriesMapper repositoriesMapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repositoriesMapper = new RepositoriesMapper();

        getRepositories();
    }

    private void getRepositories() {
        GitHubClient client = ServiceGenerator.createService(GitHubClient.class);
        Call<List<TransferClasses.Repository>> call = client.listRepos("prutkowski");

        call.enqueue(new Callback<List<TransferClasses.Repository>>()  {

            @Override
            public void onResponse(Call<List<TransferClasses.Repository>> call, Response<List<TransferClasses.Repository>> response) {
                List<Repo> repositories = repositoriesMapper.map(response.body());

                for (Repo repo : repositories) {
                    Log.i("LOGTAG", "fullName: " + repo.fullName);
                }
            }

            @Override
            public void onFailure(Call<List<TransferClasses.Repository>> call, Throwable t) {
                Log.i("LOGTAG", "onFailure");
            }
        });
    }
}
