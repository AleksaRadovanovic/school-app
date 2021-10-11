package com.example.hp.prosjek;

/**
 * Created by Hp on 8/22/2017.
 */

public class Raspored {

    private String predmet,vrijemeSala;


    public Raspored(String predmet, String vrijemeSala)
    {
        this.setPredmet(predmet);
        this.setVrijemeSala(vrijemeSala);
    }


    public String getVrijemeSala() {
        return vrijemeSala;
    }

    public void setVrijemeSala(String vrijemeSala) {
        this.vrijemeSala = vrijemeSala;
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }
}
