package com.exalfa.alberoFarm;

import java.time.LocalDate;

public class Acquisto {
    private String idAlbero;
    private String cfP;
    private String nomeAlbero;
    private String posizione;
    private LocalDate data;
    Acquisto(String idAlbero, String cfP, String nomeAlbero, String posizione, LocalDate data)
    {
        this.idAlbero = idAlbero;
        this.cfP = cfP;
        this.nomeAlbero = nomeAlbero;
        this.posizione = posizione;
        this.data = data;
    }
    public String getIdAlbero()
    {
        return idAlbero;
    }
    public String getCfP()
    {
        return cfP;
    }
    public String getNomeAlbero()
    {
        return nomeAlbero;
    }
    public String getPosizione()
    {
        return posizione;
    }
    public LocalDate getData()
    {
        return data;
    }

    public void setIdAlbero(String idAlbero)
    {
        this.idAlbero = idAlbero;
    }
    public void setCfP(String cfP)
    {
        this.cfP = cfP;
    }
    public void setNomeAlbero(String nomeAlbero)
    {
        this.nomeAlbero = nomeAlbero;
    }
    public void setPosizione(String posizione)
    {
        this.posizione = posizione;
    }
    public void setData(LocalDate data)
    {
        this.data = data;
    }
}
