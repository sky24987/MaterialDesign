package com.example.alxsoa.recyclerview_01;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

public class PlanetaFragmento extends Fragment implements RecyclerViewOnClickListenerHack
{
    private RecyclerView mRecyclerView;
    private List<Planeta> mList;

    @Override
    public View onCreateView (
                                LayoutInflater inflater,
                                ViewGroup container,
                                Bundle savedInstanceState
                             )
    {
        View view = inflater.inflate(R.layout.fragment_planeta, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.idListaPlanetas);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener()
        {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState)
            {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager llm = (LinearLayoutManager) mRecyclerView.getLayoutManager();
                PlanetaAdapter adapter = (PlanetaAdapter) mRecyclerView.getAdapter();
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        mList = ((MainActivity) getActivity()).GetSetPlaneta(10);
        PlanetaAdapter adapter = new PlanetaAdapter(getActivity(), mList);
        adapter.setRecyclerViewOnClickListenerHack(this);
        mRecyclerView.setAdapter( adapter );

        return view;
    }

    @Override
    public void onClickListener(View view, int position)
    {
        Toast.makeText(getActivity(), "Posição na Lista: "+position, Toast.LENGTH_SHORT).show();
    }

}
