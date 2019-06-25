package com.codigo.venadostest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codigo.venadostest.R;
import com.codigo.venadostest.models.Forwards;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerForwardsAdapter extends RecyclerView.Adapter<RecyclerForwardsAdapter.ForwardsAdapter> implements View.OnClickListener {

    Context context;
    List <Forwards> forwardsList;
    private View.OnClickListener listener;

    public static class ForwardsAdapter extends RecyclerView.ViewHolder{

        @BindView(R.id.name) TextView name;
        @BindView(R.id.position) TextView position;
        @BindView(R.id.imagePlayer) CircleImageView image;

        public ForwardsAdapter(View view){
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public RecyclerForwardsAdapter(Context context, List<Forwards> items){
        this.forwardsList = items;
        this.context = context;
    }

    @Override
    public int getItemCount(){
        return forwardsList.size();
    }

    @Override
    public void onClick(View v){

        if (listener != null){
            listener.onClick(v);
        }
    }

    @Override
    public ForwardsAdapter onCreateViewHolder(ViewGroup viewGroup, int i){

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_players, viewGroup, false);
        v.setOnClickListener(this);
        return  new ForwardsAdapter(v);
    }

    @Override
    public void onBindViewHolder(final ForwardsAdapter forwardsAdapter, final int i){

        forwardsAdapter.name.setText(forwardsList.get(i).getName()+" "+forwardsList.get(i).getFirst_surname());
        forwardsAdapter.position.setText(forwardsList.get(i).getPosition());
        Glide.with(context).load(forwardsList.get(i).getImage()).into(forwardsAdapter.image);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
}
