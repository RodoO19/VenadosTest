package com.codigo.venadostest.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.codigo.venadostest.Interface.Service;
import com.codigo.venadostest.R;
import com.codigo.venadostest.adapters.RecyclerForwardsAdapter;
import com.codigo.venadostest.adapters.ServiceAdapter;
import com.codigo.venadostest.models.Forwards;
import com.codigo.venadostest.models.Team;
import com.codigo.venadostest.models.Response.ForwardsResponse;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPlayers extends Fragment {

    private View view;
    @BindView(R.id.recylerViewPlayers)RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Forwards> forwardsList;
    private Context context;
    @BindView(R.id.swipeRefreshLayout)SwipeRefreshLayout swipeRefreshLayout;

    public FragmentPlayers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_players, container, false);

        ButterKnife.bind(this,view);
        context = getActivity().getApplicationContext();
        layoutManager = new GridLayoutManager(context,3);
        recyclerView.setHasFixedSize(true);
        forwardsList = new ArrayList<>();
        recyclerView.setLayoutManager(layoutManager);
        ResponseForwards();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                forwardsList.clear();
                swipeRefreshLayout.setRefreshing(false);

            }
        });
        return view;
    }

    public void ResponseForwards(){

        /*Retrofit retrofit = new Retrofit.Builder().baseUrl("https://venados.dacodes.mx/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        Service service = retrofit.create(Service.class);*/

        Call<ForwardsResponse> call = ServiceAdapter.getService().getForwards();

        call.enqueue(new Callback<ForwardsResponse>() {
            @Override
            public void onResponse(Call<ForwardsResponse> call, Response<ForwardsResponse> response) {
                if(response.body().isSuccess()){
                    for (Forwards forwardsItem:response.body().getData().getTeam().getForwards()){
                        forwardsList.add(forwardsItem);
                    }
                }else
                    Toast.makeText(context,"Intentalo mas tarde",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ForwardsResponse> call, Throwable t) {
                Toast.makeText(getContext(),"Revise su conexion a internet",Toast.LENGTH_LONG).show();
            }
        });

        RecyclerForwards();
    }

    public void RecyclerForwards(){
        RecyclerForwardsAdapter adapter = new RecyclerForwardsAdapter(context,forwardsList);
        recyclerView.setAdapter(adapter);

        adapter.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailsPlayer(forwardsList.get(recyclerView.getChildAdapterPosition(v)));
            }
        } );
    }

    public void DetailsPlayer(Forwards forwards){
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.view_player, null);

        CircleImageView image = (CircleImageView)view.findViewById(R.id.img_player);
        TextView position = (TextView)view.findViewById(R.id.txt_position);
        TextView name = (TextView)view.findViewById(R.id.txt_name);
        TextView birthday = (TextView)view.findViewById(R.id.txt_birthday);
        TextView birth_place = (TextView)view.findViewById(R.id.txt_birth_place);
        TextView weight = (TextView)view.findViewById(R.id.txt_weight);
        TextView height = (TextView)view.findViewById(R.id.txt_height);
        TextView last_team = (TextView)view.findViewById(R.id.txt_last_team);

        java.util.Calendar calendar = java.util.Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+00:00").parse(""+forwards.getBirthday()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Glide.with(context).load(""+forwards.getImage()).into(image);
        position.setText(""+forwards.getPosition());
        name.setText(""+forwards.getName()+" "+forwards.getFirst_surname());
        birthday.setText(""+calendar.get(Calendar.YEAR)+"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DAY_OF_MONTH));
        birth_place.setText(""+forwards.getBirth_place());
        weight.setText(""+forwards.getWeight());
        height.setText(""+forwards.getHeight());
        last_team.setText(""+forwards.getLast_team());

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        builder.show();
    }


}