package com.example.alxsoa.recyclerview_01;

public class Estado
{
    private String strEstado;
    private String strCapital;

    public Estado(){}
    public Estado(String m, String b)
    {
        strEstado = m;
        strCapital = b;
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
}
