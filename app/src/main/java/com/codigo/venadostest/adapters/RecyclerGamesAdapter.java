package com.codigo.venadostest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codigo.venadostest.R;
import com.codigo.venadostest.models.Games;
import com.codigo.venadostest.utilities.FormatDate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerGamesAdapter extends RecyclerView.Adapter<RecyclerGamesAdapter.GamesAdapter> {

    Context context;
    List <Games> gamesList;
    int month = 0;

    public static class GamesAdapter extends RecyclerView.ViewHolder{

        @BindView(R.id.opponent) TextView opponent;
        @BindView(R.id.team) TextView local;
        @BindView(R.id.score) TextView score;
        @BindView(R.id.txtDay) TextView txtDay;
        @BindView(R.id.txtDate) TextView txtDate;
        @BindView(R.id.local_image) ImageView local_image;
        @BindView(R.id.opponent_image)ImageView opponent_image;
        @BindView(R.id.month)LinearLayout month;
        @BindView(R.id.txtmonth)TextView txtmonth;

        public GamesAdapter(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public RecyclerGamesAdapter(Context context, List<Games> list) {

        this.gamesList = list;
        this.context = context;
    }

    @Override
    public int getItemCount() {

        return gamesList.size();
    }


    @Override
    public GamesAdapter onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_view_games, viewGroup, false);
        return new GamesAdapter(view);

    }

    @Override
    public void onBindViewHolder(final GamesAdapter adapter, final int i) {

        adapter.score.setText(gamesList.get(i).getHome_score()+ " - " +gamesList.get(i).getAway_score());
        adapter.opponent.setText(gamesList.get(i).getOpponent());
        adapter.txtDay.setText(FormatDate.getDayMonth(gamesList.get(i).getDatetime()));
        adapter.txtDate.setText(FormatDate.getDayWeek(gamesList.get(i).getDatetime()));

        int m = gamesList.get(i).getDate().getMonth()+1;
        if (m != month){

            adapter.month.setVisibility(View.VISIBLE);
            month = m;
            adapter.txtmonth.setText(getMonth(m));

        }else{

            adapter.month.setVisibility(View.GONE);

        }

        //evento = (list.get(i).getOpponent() + "vs" + "Venados F.C.");
        //Glide.with(context).load(""+items.get(i).getOpponent_image()).into(adapter.opponent_image);

        if (gamesList.get(i).isLocal()){

            adapter.local.setText(gamesList.get(i).getOpponent());
            Glide.with(context).load(gamesList.get(i).getOpponent_image()).into(adapter.local_image);
            Glide.with(context).load(R.drawable.logo_venados).into(adapter.opponent_image);
            adapter.opponent.setText("Venados F.C");

        }else {

            adapter.opponent.setText(gamesList.get(i).getOpponent());
            Glide.with(context).load(gamesList.get(i).getOpponent_image()).into(adapter.opponent_image);
            Glide.with(context).load(R.drawable.logo_venados).into(adapter.local_image);
            adapter.local.setText("Venados F.C.");

        }
    }

    public String getMonth(int month){

        String mont = "";
        switch (month){
            case 1:
                mont = "Enero";
                break;
            case 2:
                mont = "Febrero";
                break;
            case 3:
                mont = "Marzo";
                break;
            case 4:
                mont = "Abril";
                break;
            case 5:
                mont = "Mayo";
                break;
            case 6:
                mont = "Junio";
                break;
            case 7:
                mont = "Julio";
                break;
            case 8:
                mont = "Agosto";
                break;
            case 9:
                mont = "Septiembre";
                break;
            case 10:
                mont = "Octubre";
                break;
            case 11:
                mont = "Noviembre";
                break;
            case 12:
                mont = "Diciembre";
                break;
        }
        return mont;
    }

}
