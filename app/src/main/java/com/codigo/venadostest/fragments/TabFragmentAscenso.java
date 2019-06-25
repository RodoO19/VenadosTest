package com.codigo.venadostest.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codigo.venadostest.R;
import com.codigo.venadostest.adapters.RecyclerGamesAdapter;
import com.codigo.venadostest.adapters.ServiceAdapter;
import com.codigo.venadostest.models.Games;
import com.codigo.venadostest.models.Response.GamesResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TabFragmentAscenso extends Fragment {

    @BindView(R.id.recycler)RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    List<Games> gamesList;
    private Context context;

    @BindView(R.id.swipeRefreshLayout)SwipeRefreshLayout swipeRefreshLayout;

    public TabFragmentAscenso() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.tab_fragment_ascenso, container, false);

        ButterKnife.bind(this,view);
        context = getActivity().getApplicationContext();
        layoutManager = new LinearLayoutManager(context);
        recycler.setHasFixedSize(true);
        gamesList = new ArrayList<>();

        recycler.setLayoutManager(layoutManager);
        //recycler.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        ResponseGames();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                gamesList.clear();
                ResponseGames();
            }
        });

        return view;
    }

    public void ResponseGames(){

        Call<GamesResponse> call = ServiceAdapter.getService().getGames();

        call.enqueue(new Callback<GamesResponse>() {
            @Override
            public void onResponse(Call<GamesResponse> call, Response<GamesResponse> response) {
                if(response.body().isSuccess()){
                    for (Games gamesItem:response.body().getData().getGames()){
                        Date date=null;
                        try {
                            date=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+00:00").parse(""+gamesItem.getDatetime());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        gamesItem.setDate(date);
                        if (gamesItem.getLeague().equals("Ascenso MX"))
                            gamesList.add(gamesItem);
                    }
                    RecyclerGames();
                }else
                    Toast.makeText(context,"Intentalo mas tarde",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<GamesResponse> call, Throwable t) {
                Toast.makeText(getContext(),"Revise su conexion a internet",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void RecyclerGames(){

        Collections.sort(gamesList, new Comparator<Games>() {
            public int compare(Games p1, Games p2) {
                return Long.valueOf(p1.getDate().getTime()).compareTo(p2.getDate().getTime());
            }
        });

        adapter = new RecyclerGamesAdapter(context,gamesList) {
            @Override
            public GamesAdapter onCreateViewHolder(ViewGroup viewGroup, int i) {
                return super.onCreateViewHolder(viewGroup, i);
            }
        };
        recycler.setAdapter(adapter);
        swipeRefreshLayout.setRefreshing(false);

    }
}
