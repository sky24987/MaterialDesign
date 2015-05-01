package com.example.alxsoa.recyclerview_01;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
{
    private String[] dataSource;
    public RecyclerAdapter(String[] dataArgs)
    {
        dataSource = dataArgs;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.textView.setText(dataSource[position]);
    }

    @Override
    public int getItemCount()
    {
        return dataSource.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        protected TextView textView;
        public ViewHolder(View itemView)
        {
            super(itemView);
            textView =  (TextView) itemView.findViewById(R.id.list_item);
        }
    }
}