package com.example.alxsoa.recyclerview_01;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity
{
    private Toolbar mToolbar;
    private Toolbar mToolbarBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.idWdgPrincipal);
        mToolbar.setTitle("Lista de Planetas");
        mToolbar.setSubtitle("Classificação");
        mToolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(mToolbar);

        PlanetaFragmento frag = (PlanetaFragmento) getSupportFragmentManager().findFragmentByTag("mainFrag");
        if(frag == null)
        {
            frag = new PlanetaFragmento();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.idFrgContainer, frag, "mainFrag");
            ft.commit();
        }
    }

    public List<Planeta> GetSetPlaneta(int qtd)
    {
        String[] Planetas = new String[]  {
                                            "Sol",      "Mercúrio",     "Vênus",
                                            "Terra",    "Marte",        "Júpiter",
                                            "Saturno",  "Urano",        "Netuno",
                                            "Plutão"
                                            };

        String[] Classificacao = new String[]  {
                                                "Estrela Gigante",      "Planetas telúricos",
                                                "Planetas telúricos",   "Planetas telúricos",
                                                "Planetas telúricos",   "Planetas gigantes",
                                                "Planetas gigantes",    "Planetas gigantes",
                                                "Planetas gigantes",    "Não é Planeta"
                                                };

        List<Planeta> listAux = new ArrayList<>();
        for(int i = 0; i < qtd; i++)
        {
            Planeta c = new Planeta( Planetas[i % Planetas.length], Classificacao[ i % Classificacao.length ] );
            listAux.add(c);
        }
        return(listAux);
    }
}
