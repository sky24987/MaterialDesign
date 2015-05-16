package com.example.alxsoa.base_03;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends ActionBarActivity
{
    private Toolbar mtbMinhaBarra;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtbMinhaBarra = (Toolbar) findViewById(R.id.tb_main);
        mtbMinhaBarra.setTitle("Main Activity");
        mtbMinhaBarra.setSubtitle("just a subtitle");
        mtbMinhaBarra.setLogo(R.drawable.ic_launcher);
        setSupportActionBar(mtbMinhaBarra);
    }

}
