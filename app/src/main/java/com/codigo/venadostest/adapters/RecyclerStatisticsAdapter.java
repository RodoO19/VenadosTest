package com.codigo.venadostest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codigo.venadostest.R;
import com.codigo.venadostest.models.Statistics;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerStatisticsAdapter  extends RecyclerView.Adapter<RecyclerStatisticsAdapter.StatisticsAdapter> {

    Context context;
    List<Statistics> statisticsList;

    public static class StatisticsAdapter extends RecyclerView.ViewHolder{

        @BindView(R.id.position) TextView position;
        @BindView(R.id.team) TextView team;
        @BindView(R.id.games) TextView games;
        @BindView(R.id.score_dif) TextView score_dif;
        @BindView(R.id.points) TextView points;
        @BindView(R.id.image)ImageView image;

        public StatisticsAdapter(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public RecyclerStatisticsAdapter(Context context, List<Statistics> items) {
        this.statisticsList = items;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return statisticsList.size();
    }

    @Override
    public StatisticsAdapter onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_statistics, viewGroup, false);
        return new StatisticsAdapter(v);
    }

    @Override
    public void onBindViewHolder(final StatisticsAdapter adapter, final int i) {

        adapter.team.setText(""+statisticsList.get(i).getTeam());
        adapter.points.setText(""+statisticsList.get(i).getPoints());
        adapter.position.setText(""+statisticsList.get(i).getPosition());
        adapter.score_dif.setText(""+statisticsList.get(i).getScore_diff());
        adapter.games.setText(""+statisticsList.get(i).getGames());
        Glide.with(context).load(""+statisticsList.get(i).getImage()).into(adapter.image);
    }
}
