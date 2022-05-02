package com.exalfa.alberoFarm;

public class Albero {
   private String id;
   private String tipologia;
   private double costo;
   Albero(String id, String tipologia, double costo)
   {
       this.id = id;
       this.tipologia = tipologia;
       this.costo = costo;
   }
    public String getId()
    {
        return id;
    }
    public String getTipologia()
    {
        return tipologia;
    }
    public double getCosto()
    {
        return costo;
    }

    public void setId(String id)
    {
        this.id = id;
    }
    public void setTipologia(String tipologia)
    {
        this.tipologia = tipologia;
    }
    public void setCosto(double costo)
    {
        this.costo = costo;
    }
}
