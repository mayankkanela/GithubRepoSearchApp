package com.mayank.githubreposearchapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputEditText;
import com.mayank.githubreposearchapp.R;
import com.mayank.githubreposearchapp.data.model.RepoEntity;
import com.mayank.githubreposearchapp.data.network.GitHubClient;
import com.mayank.githubreposearchapp.data.network.GithubApiBuilder;
import com.mayank.githubreposearchapp.data.network.ResponseObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private ViewModel viewModel;
    private TextInputEditText textInputEditText;
    private ImageButton search;
    private RepoEntityAdapter repoEntityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rv_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        repoEntityAdapter = new RepoEntityAdapter();
        recyclerView.setAdapter(repoEntityAdapter);
        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.getAllRepoEntity().observe(this, new Observer<List<RepoEntity>>() {
            @Override
            public void onChanged(List<RepoEntity> repoEntities) {
                repoEntityAdapter.setEntities(repoEntities);
            }
        });
        textInputEditText = findViewById(R.id.et_search);
        search = findViewById(R.id.ib_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String q = textInputEditText.getText().toString();
                if(!q.isEmpty())
                {
                    fetchData(q);
                }
            }
        });

    }

    private void fetchData(String q) {
        Log.i("Mayank", q);
        GitHubClient gitHubClient = new GithubApiBuilder().getService();
        Call<ResponseObject> callEntities = gitHubClient.searchRepos(q);
        callEntities.enqueue(new Callback<ResponseObject>() {
            @Override
            public void onResponse(Call<ResponseObject> call, Response<ResponseObject> response) {
                //viewModel.insert(response.body());
                if(response.isSuccessful())
                {
                    List<RepoEntity> repoEntities= response.body().getRepoEntities();
                    Log.i("Mayank", response.body().getRepoEntities().get(0).getDescription());
                    for(RepoEntity repoEntity: repoEntities)
                    {
                        viewModel.insert(repoEntity);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseObject> call, Throwable t) {
                Log.i("Mayank", t.getStackTrace().toString());
            }
        });

    }
}
