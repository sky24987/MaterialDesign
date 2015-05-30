package com.example.alxsoa.cardview_01;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

// http://www.truiton.com/2015/03/android-cardview-example/
public class MainActivity extends ActionBarActivity
{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    protected void onResume()
    {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(
                                                                    new MyRecyclerViewAdapter
                                                                    .MyClickListener()
        {
            @Override
            public void onItemClick(int position, View v)
            {
                Toast.makeText(getApplicationContext(), "Posição na Lista: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<DataObject> getDataSet()
    {
        ArrayList results = new ArrayList<DataObject>();
        for (int index = 0; index < 20; index++)
        {
            DataObject obj = new DataObject (  "Some Primary Text " + index,
                                                "Secondary " + index
                                            );
            results.add(index, obj);
        }
        return results;
    }
}