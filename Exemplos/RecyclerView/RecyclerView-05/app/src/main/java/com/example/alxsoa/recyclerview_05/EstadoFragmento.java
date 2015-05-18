package com.example.alxsoa.recyclerview_05;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

public class EstadoFragmento extends Fragment implements RecyclerViewOnClickListenerHack
{
    private RecyclerView mRecyclerView;
    private List<Estado> mList;

    @Override
    public View onCreateView (
                                LayoutInflater inflater,
                                ViewGroup container,
                                Bundle savedInstanceState
                             )
    {
        View view = inflater.inflate(R.layout.fragment_estado, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.idListaEstados);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //LinearLayoutManager llm = (LinearLayoutManager) mRecyclerView.getLayoutManager();

                GridLayoutManager llm = (GridLayoutManager) mRecyclerView.getLayoutManager();
                EstadoAdapter adapter = (EstadoAdapter) mRecyclerView.getAdapter();
            }
        });

        mRecyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(getActivity(), mRecyclerView, this));

        GridLayoutManager llm = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(llm);

        mList = ((MainActivity) getActivity()).GetSetEstadoList(10);
        EstadoAdapter adapter = new EstadoAdapter(getActivity(), mList);
        mRecyclerView.setAdapter( adapter );


        return view;
    }

    @Override
    public void onClickListener(View view, int position)
    {
        Toast.makeText(getActivity(), "Posição na Lista: "+position, Toast.LENGTH_SHORT).show();
        EstadoAdapter adapter = (EstadoAdapter) mRecyclerView.getAdapter();
        adapter.removeListItem(position);
    }

    @Override
    public void onLongPressClickListener(View view, int position)
    {
        Toast.makeText(getActivity(), "Tempo Longo Pressionado: "+position, Toast.LENGTH_SHORT).show();
    }

    private static class RecyclerViewTouchListener implements RecyclerView.OnItemTouchListener
    {
        private Context mContext;
        private GestureDetector mGestureDetector;
        private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

        public RecyclerViewTouchListener(Context c, final RecyclerView rv, RecyclerViewOnClickListenerHack rvoclh){
            mContext = c;
            mRecyclerViewOnClickListenerHack = rvoclh;

            mGestureDetector = new GestureDetector(mContext, new GestureDetector.SimpleOnGestureListener(){
                @Override
                public void onLongPress(MotionEvent e)
                {
                    super.onLongPress(e);

                    View cv = rv.findChildViewUnder(e.getX(), e.getY());

                    if(cv != null && mRecyclerViewOnClickListenerHack != null){
                        mRecyclerViewOnClickListenerHack.onLongPressClickListener(cv,
                                rv.getChildPosition(cv) );
                    }
                }

                @Override
                public boolean onSingleTapUp(MotionEvent e)
                {
                    View cv = rv.findChildViewUnder(e.getX(), e.getY());

                    if(cv != null && mRecyclerViewOnClickListenerHack != null){
                        mRecyclerViewOnClickListenerHack.onClickListener(cv,
                                rv.getChildPosition(cv) );
                    }

                    return(true);
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e)
        {
            mGestureDetector.onTouchEvent(e);
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {}
    }
}
