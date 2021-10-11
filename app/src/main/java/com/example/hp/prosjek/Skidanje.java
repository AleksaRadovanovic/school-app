package com.example.hp.prosjek;

import android.os.AsyncTask;

import java.io.IOError;
import java.io.IOException;
import java.lang.annotation.Documented;

/**
 * Created by Hp on 6/23/2017.
 */

//unosi se predmet i skidaju se obavestenja sa njegovog linka
public class Skidanje extends AsyncTask<Void,Void,Void>
{
    private Predmet predmet;

    public Skidanje(Predmet predmet)
    {
        this.predmet=predmet;
    }


    @Override
    protected Void doInBackground(Void... params)
    {



        return null;
    }




}
