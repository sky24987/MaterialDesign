package com.example.alxsoa.recyclerview_01;

public class Planeta
{
    private String strPlaneta;
    private String strClassificacao;

    public Planeta(){}
    public Planeta(String m, String b)
    {
        strPlaneta = m;
        strClassificacao = b;
    }


    public String getStrPlaneta()
    {
        return strPlaneta;
    }

    public void setStrPlaneta(String strPlaneta)
    {
        this.strPlaneta = strPlaneta;
    }

    public String getStrClassificacao()
    {
        return strClassificacao;
    }

    public void setStrClassificacao(String strClassificacao)
    {
        this.strClassificacao = strClassificacao;
    }
}
