package com.example.hp.prosjek;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class IzracunajDan {

    private int dan,mjesec;
    private static int nizDana []={0,31,28,31,30,31,30,31,31,30,31,30,31};


    Calendar calendar;
    SimpleDateFormat format1;

    public IzracunajDan()
    {
       danMjesec();


    }

    private void danMjesec()
    {
        format1 = new SimpleDateFormat("dd:MM:yy:HH:mm:ss");
        calendar = Calendar.getInstance();

        String date = format1.format(calendar.getTime());

        String brDan=date.substring(1,2);
        String brMjesec = date.substring(3,5);

        dan=Integer.parseInt(brDan);
        mjesec=Integer.parseInt(brMjesec);


    }


    public int izracunaj()
    {
        int broj=brojDana();


        if(broj%7>0&&broj%7<6)
            return broj%7;


        return 0;
    }



    public int brojDana()
    {
        int broj1=0;


        for(int i=0;i<mjesec;i++)
        {
            broj1=broj1+nizDana[i];
        }

        return broj1+dan;
    }


}
