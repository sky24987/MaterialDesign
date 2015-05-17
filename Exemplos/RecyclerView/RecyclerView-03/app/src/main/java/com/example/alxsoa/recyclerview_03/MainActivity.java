package com.example.alxsoa.recyclerview_03;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
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
        mToolbar.setTitle("Estados Brasileiros");
        mToolbar.setSubtitle("Capitais");
        mToolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(mToolbar);

        EstadoFragmento frag = (EstadoFragmento) getSupportFragmentManager().findFragmentByTag("mainFrag");
        if(frag == null)
        {
            frag = new EstadoFragmento();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.idFrgContainer, frag, "mainFrag");
            ft.commit();
        }
    }

    public List<Estado> GetSetEstadoList(int qtd)
    {
        String[] Estado = new String[]  {
                                            "Acre",                     "Alagoas",
                                            "Amapá",                    "Amazonas",
                                            "Bahia",                    "Ceará",
                                            "Distrito Federal",         "Espírito Santo",
                                            "Goiás",                    "Maranhão",
                                            "Mato Grosso",              "Mato Grosso do Sul",
                                            "Minas Gerais",             "Pará",
                                            "Paraíba",                  "Paraná",
                                            "Pernambuco",               "Piauí",
                                            "Rio de Janeiro",           "Rio Grande do Norte",
                                            "Rio Grande do Sul",        "Rondônia",
                                            "Roraima",                  "Santa Catarina",
                                            "São Paulo",                "Sergipe",
                                            "Tocantins"
                                        };

        String[] Capital = new String[]  {
                                            "Rio Branco",           "Maceió",
                                            "Macapá",               "Manaus",
                                            "Salvador",             "Fortaleza",
                                            "Brasília",             "Vitória",
                                            "Goiânia",              "São Luís",
                                            "Cuiabá",               "Campo Grande",
                                            "Belo Horizonte",       "Belém",
                                            "João Pessoa",          "Curitiba",
                                            "Recife",               "Teresina",
                                            "Rio de Janeiro",       "Natal",
                                            "Porto Alegre",         "Porto Velho",
                                            "Boa Vista",            "Florianópolis",
                                            "São Paulo",            "Aracaju",
                                            "Palmas"
                                        };

        int[] Bandeiras = new int[]     {
                                            R.drawable.acre,            R.drawable.alagoas,
                                            R.drawable.amapa,           R.drawable.amazonas,
                                            R.drawable.bahia,           R.drawable.ceara,
                                            R.drawable.distritofederal, R.drawable.espiritosanto,
                                            R.drawable.goias,           R.drawable.maranhao,
                                            R.drawable.matogrosso,      R.drawable.matogrossosul,
                                            R.drawable.minas,           R.drawable.parana,
                                            R.drawable.paraiba,         R.drawable.amazonas,
                                            R.drawable.pernambuco,      R.drawable.piaui,
                                            R.drawable.riodejaneiro,    R.drawable.riograndenorte,
                                            R.drawable.riograndesul,    R.drawable.rondonia,
                                            R.drawable.roraima,         R.drawable.santacatarina,
                                            R.drawable.saopaulo,        R.drawable.sergipe,
                                            R.drawable.tocantins
                                        };


        List<Estado> listAux = new ArrayList<>();
        for(int i = 0; i < 27; i++)
        {
            Estado c = new Estado   (
                                        Estado[i % Estado.length],
                                        Capital[ i % Capital.length ],
                                        Bandeiras[i % Estado.length]
            );
            listAux.add(c);
        }
        return(listAux);
    }

}