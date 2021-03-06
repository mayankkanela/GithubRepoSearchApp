package com.mayank.githubreposearchapp.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.mayank.githubreposearchapp.R;
import com.mayank.githubreposearchapp.data.model.RepoEntity;

import java.util.ArrayList;
import java.util.List;

public class RepoEntityAdapter extends RecyclerView.Adapter<RepoEntityAdapter.RepoEntityHolder> {
    private List<RepoEntity> entities = new ArrayList<>();
    private Context context;
    @NonNull
    @Override
    public RepoEntityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_items, parent, false);
        return new RepoEntityHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoEntityHolder holder, int position) {
        RepoEntity entity = entities.get(position);
                if(entity.getFull_name() != null && !TextUtils.isEmpty(entity.getFull_name()))
                {
                    holder.fullName.setText(entity.getFull_name());
                    String a[] = entity.getFull_name().split("/");
                    holder.owner.setText(a[0]);
                    holder.description.setText(entity.getDescription());
                    holder.watchers.setText(String.valueOf(entity.getWatchers_count()));
                    holder.stars.setText(String.valueOf(entity.getStargazers_count()));
                    holder.forks.setText(String.valueOf(entity.getForks_count()));

                }
    }

    public void setEntities(List<RepoEntity> entities)
    {
        this.entities = entities;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return entities.size();
    }

    public class RepoEntityHolder extends RecyclerView.ViewHolder{
        private TextView fullName;
        private TextView owner;
        private TextView description;
        private ChipGroup chipGroup;
        private Chip watchers;
        private Chip stars;
        private Chip forks;

        public RepoEntityHolder(@NonNull View itemView) {
            super(itemView);
            fullName = itemView.findViewById(R.id.tv_full_name);
            owner = itemView.findViewById(R.id.tv_owner);
            description = itemView.findViewById(R.id.tv_description);
            chipGroup = itemView.findViewById(R.id.chip_group);
            watchers = chipGroup.findViewById(R.id.watchers);
            stars = chipGroup.findViewById(R.id.stars);
            forks = chipGroup.findViewById(R.id.forks);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String url = entities.get(getAdapterPosition()).getUrl();
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    context.startActivity(browserIntent);

                }
            });
        }
    }
}
