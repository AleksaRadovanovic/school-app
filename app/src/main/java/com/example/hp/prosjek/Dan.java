package com.example.hp.prosjek;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Hp on 8/22/2017.
 */

public class Dan {

    private Raspored nizRaspored [];

    public Dan(Raspored niz[])
    {
        nizRaspored=niz;
    }

    public void unesiRaspored(TextView nizPredmeta[], TextView nizInfo[], LinearLayout nizLinear[])
    {
        for(int i=0;i<nizLinear.length;i++)
        {
            if(i<nizRaspored.length)
            {
                nizPredmeta[i].setText(nizRaspored[i].getPredmet());
                nizInfo[i].setText(nizRaspored[i].getVrijemeSala());
                nizLinear[i].setVisibility(View.VISIBLE);
            }
            else nizLinear[i].setVisibility(View.GONE);


        }
    }

    public void rasporedGone(LinearLayout nizLinear[])
    {
        for(int i=0;i<nizLinear.length;i++)
        {
             nizLinear[i].setVisibility(View.GONE);

        }
    }

}
