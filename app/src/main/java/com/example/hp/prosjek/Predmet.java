package com.example.hp.prosjek;



public class Predmet
{

    private String ime,dattum,link,semestar;
    private int kredit;

    public Predmet(String ime,int  kredit,String link)
    {
        this.ime=ime;
        this.kredit=kredit;
        this.link=link;
    }


    //---------geTeri i seTeri--------------

    public String getDattum() {
        return dattum;
    }

    public void setDattum(String dattum) {
        this.dattum = dattum;
    }

    public String getSemestar() {

        return semestar;
    }

    public void setSemestar(String semestar) {
        this.semestar = semestar;
    }

    public String getIme() {
        return ime;
    }

    public int getKredit() {
        return kredit;
    }

    public String getLink()
    {
        return link;
    }

    public void setKredit(int kredit) {
        this.kredit = kredit;
    }

    public void setLink(String  link)
    {
        this.link = link;
    }

    public void setIme(String ime)
    {
        this.ime=ime;
    }

}
