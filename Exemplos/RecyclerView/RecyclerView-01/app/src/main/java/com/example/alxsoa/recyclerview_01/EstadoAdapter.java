package com.example.alxsoa.recyclerview_01;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class EstadoAdapter extends RecyclerView.Adapter<EstadoAdapter.MyViewHolder>
{
    private List<Estado> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;


    public EstadoAdapter(Context c, List<Estado> l)
    {
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View v = mLayoutInflater.inflate(R.layout.item_estado, viewGroup, false);
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position)
    {
        myViewHolder.txtPlaneta.setText(mList.get(position).getStrEstado());
        myViewHolder.txtClassificacao.setText(mList.get(position).getStrCapital());
    }

    @Override
    public int getItemCount()
    {
        return mList.size();
    }

    public void setRecyclerViewOnClickListenerHack(RecyclerViewOnClickListenerHack r)
    {
        mRecyclerViewOnClickListenerHack = r;
    }

    public void addListItem(Estado c, int position)
    {
        mList.add(c);
        notifyItemInserted(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView txtPlaneta;
        public TextView txtClassificacao;
        public MyViewHolder(View itemView)
        {
            super(itemView);
            txtPlaneta = (TextView) itemView.findViewById(R.id.idTxtPlaneta);
            txtClassificacao = (TextView) itemView.findViewById(R.id.idTxtClassificacao);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            if(mRecyclerViewOnClickListenerHack != null)
            {
                mRecyclerViewOnClickListenerHack.onClickListener(v, getPosition());
            }
        }
    }
}
