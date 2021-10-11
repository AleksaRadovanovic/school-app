package com.example.hp.prosjek;

/**
 * Created by Hp on 8/31/2017.
 */

public class ObavestenjeObjekat
{
    String sadrzaj,datum;

    public ObavestenjeObjekat(String sadrzaj,String datum)
    {
        this.datum=datum;
        this.sadrzaj=sadrzaj;

    }

    public void setSadrzaj(String sadrzaj)
    {
        this.sadrzaj=sadrzaj;

    }
    public void setDatum(String datum)
    {
        this.datum=datum;

    }

    public String getSadrzaj()
    {
        return sadrzaj;

    }

    public String getDatum()
    {
        return datum;
    }





}
