package com.mayank.githubreposearchapp.data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RepoEntityRepository {
    private RepoEntityDao daoRepoEntity;
    private LiveData<List<RepoEntity>> allRepo;

    public RepoEntityRepository(Application application)
    {
        RepoDatabase repoDatabase = RepoDatabase.getInstance(application);
        daoRepoEntity = repoDatabase.daoRepoEntity();
        allRepo =  daoRepoEntity.getAllRepo();
    }

    public void insert(RepoEntity repoEntity)
    {
        new InsertRepoEntityAsyncTask(daoRepoEntity).execute(repoEntity);
    }

    public void update(RepoEntity repoEntity)
    {

    }

    public void delete(RepoEntity repoEntity)
    {

    }

    public void deleteAllRepoEntity()
    {

    }

    public LiveData<List<RepoEntity>> getAllRepo()
    {
        return allRepo;
    }

    private static class InsertRepoEntityAsyncTask extends AsyncTask<RepoEntity, Void, Void>
    {
        private RepoEntityDao daoRepoEntity;

        private InsertRepoEntityAsyncTask(RepoEntityDao daoRepoEntity)
        {
            this.daoRepoEntity = daoRepoEntity;
        }
        @Override
        protected Void doInBackground(RepoEntity... repoEntities) {
            daoRepoEntity.insert(repoEntities[0]);
            return null;
        }
    }
}
