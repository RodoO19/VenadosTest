package com.codigo.venadostest.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codigo.venadostest.R;
import com.codigo.venadostest.adapters.RecyclerStatisticsAdapter;
import com.codigo.venadostest.adapters.ServiceAdapter;
import com.codigo.venadostest.models.Response.StatisticsResponse;
import com.codigo.venadostest.models.Statistics;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentStatistics extends Fragment {


    @BindView(R.id.recycler)RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    List<Statistics> statisticsList;
    private Context context;
    @BindView(R.id.swipeRefreshLayout)SwipeRefreshLayout swipeRefreshLayout;

    public FragmentStatistics() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_statistics, container, false);
        ButterKnife.bind(this,view);
        context = getActivity().getApplicationContext();
        layoutManager = new LinearLayoutManager(context);
        recycler.setHasFixedSize(true);
        statisticsList = new ArrayList<>();

        recycler.setLayoutManager(layoutManager);
        recycler.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        ResponseStatistics();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                statisticsList.clear();
                ResponseStatistics();
            }
        });
        return view;
    }

    public void ResponseStatistics(){

        Call<StatisticsResponse> call = ServiceAdapter.getService().getStatistics();

        call.enqueue(new Callback<StatisticsResponse>() {
            @Override
            public void onResponse(Call<StatisticsResponse> call, Response<StatisticsResponse> response) {
                if(response.body().isSuccess()){
                    for (Statistics statisticsItem:response.body().getData().getStatistics()){
                        statisticsList.add(statisticsItem);
                    }
                    RecyclerStatistics();
                }else
                    Toast.makeText(context,"Intentalo mas tarde",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<StatisticsResponse> call, Throwable t) {
                Toast.makeText(getContext(),"Revise su conexion a internet",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void RecyclerStatistics(){
        adapter = new RecyclerStatisticsAdapter(context,statisticsList) {
            @Override
            public StatisticsAdapter onCreateViewHolder(ViewGroup viewGroup, int i) {
                return super.onCreateViewHolder(viewGroup, i);
            }
        };
        recycler.setAdapter(adapter);
        swipeRefreshLayout.setRefreshing(false);

    }

}
