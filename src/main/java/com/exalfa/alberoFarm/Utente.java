package com.exalfa.alberoFarm;

public class Utente {
    private String nome;
    private String cognome;
    private String cf;
    Utente(String nome, String cognome, String cf)
    {
       this.nome = nome;
       this.cognome = cognome;
       this.cf = cf;
    }

    public String getNome()
    {
        return nome;
    }
    public String getCognome()
    {
        return cognome;
    }
    public String getCf()
    {
        return cf;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }
    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }
    public void setCf(String cf)
    {
        this.cf = cf;
    }
}

