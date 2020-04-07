package com.mayank.githubreposearchapp.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mayank.githubreposearchapp.data.repository.RepoEntity;
import com.mayank.githubreposearchapp.data.repository.RepoEntityRepository;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    private RepoEntityRepository repository;
    private LiveData<List<RepoEntity>> allRepoEntity;

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new RepoEntityRepository(application);
        allRepoEntity = repository.getAllRepo();
    }

    public void insert(RepoEntity repoEntity){
        repository.insert(repoEntity);
    }

    public void update(RepoEntity repoEntity) {

    }

    public void delete(RepoEntity repoEntity) {

    }

    public void deleteAllRepoEntity() {
        repository.deleteAllRepoEntity();
    }

    public LiveData<List<RepoEntity>> getAllRepoEntity(){
        return allRepoEntity;
    }
}
