package com.example.alxsoa.recyclerview_03;

public class Estado
{
    private String strEstado;
    private String strCapital;
    private int iBandeira;

    public Estado(){}
    public Estado(String strEstadoAux, String strCapitalAux, int iBandeiraAux)
    {
        strEstado = strEstadoAux;
        strCapital = strCapitalAux;
        iBandeira = iBandeiraAux;
    }


    public String getStrEstado()
    {
        return strEstado;
    }

    public void setStrEstado(String strEstado)
    {
        this.strEstado = strEstado;
    }

    public String getStrCapital()
    {
        return strCapital;
    }

    public void setStrCapital(String strCapital)
    {
        this.strCapital = strCapital;
    }

    public int getBandeira ()
    {
        return iBandeira;
    }

    public void setBandeira ( int iBandeira )
    {
        this.iBandeira = iBandeira;
    }
}
