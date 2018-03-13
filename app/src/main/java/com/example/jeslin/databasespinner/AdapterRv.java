package com.example.jeslin.databasespinner;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by JeSLiN on 03-07-2017.
 */

public class AdapterRv extends RecyclerView.Adapter<AdapterRv.CoustomClass> {
    @Override
    public AdapterRv.CoustomClass onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(AdapterRv.CoustomClass holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CoustomClass extends RecyclerView.ViewHolder{
        public CoustomClass(View itemView) {
            super(itemView);
        }
    }
}
