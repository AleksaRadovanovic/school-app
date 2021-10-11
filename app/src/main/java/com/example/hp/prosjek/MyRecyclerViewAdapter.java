package com.example.hp.prosjek;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Hp on 8/31/2017.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.DataObjectHolder>
{

private ArrayList<ObavestenjeObjekat> dataSet;

    public static  class DataObjectHolder extends RecyclerView.ViewHolder
    {
        TextView datum,sadrzaj;

        public DataObjectHolder(View itemView)
        {
            super(itemView);
            datum = (TextView)itemView.findViewById(R.id.txtDatum1);
            sadrzaj= (TextView) itemView.findViewById(R.id.txtSadrzaj1);

        }


    }


    public MyRecyclerViewAdapter(ArrayList<ObavestenjeObjekat> dataSet)
    {
        this.dataSet=dataSet;
    }

    public DataObjectHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card,parent,false);
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }
    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.sadrzaj.setText(dataSet.get(position).getSadrzaj());
        holder.datum.setText(dataSet.get(position).getDatum());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
