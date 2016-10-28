package com.pawel_rutkowski.mybooks.mappers;


import com.pawel_rutkowski.mybooks.api.TransferClasses;
import com.pawel_rutkowski.mybooks.data.Repo;

import java.util.ArrayList;
import java.util.List;

public class RepositoriesMapper {

    public List<Repo> map(List<TransferClasses.Repository> repositories) {
        List <Repo> mappedRepositories = new ArrayList<Repo>();

        for (TransferClasses.Repository repository : repositories) {
            mappedRepositories.add(map(repository));
        }

        return mappedRepositories;
    }

    public Repo map(TransferClasses.Repository repository) {
        return new Repo(String.valueOf(repository.id), repository.name, repository.name);
    }
}
