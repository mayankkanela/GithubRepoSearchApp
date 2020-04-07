package com.mayank.githubreposearchapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.mayank.githubreposearchapp.R;
import com.mayank.githubreposearchapp.data.repository.RepoEntity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rv_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final RepoEntityAdapter repoEntityAdapter = new RepoEntityAdapter();
        recyclerView.setAdapter(repoEntityAdapter);
        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.getAllRepoEntity().observe(this, new Observer<List<RepoEntity>>() {
            @Override
            public void onChanged(List<RepoEntity> repoEntities) {
                repoEntityAdapter.setEntities(repoEntities);
            }
        });
    }
}
