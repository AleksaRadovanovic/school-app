package com.example.hp.prosjek;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private EditText txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11;
    private int zbir;
    private ImageView imgBack;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btn1 = (Button)findViewById(R.id.button3);

        txt1 = (EditText)findViewById(R.id.editText2);
        txt2 = (EditText)findViewById(R.id.editText3);
        txt3 = (EditText)findViewById(R.id.editText4);
        txt4 = (EditText)findViewById(R.id.editText5);
        txt5 = (EditText)findViewById(R.id.editText6);
        txt6 = (EditText)findViewById(R.id.edit);
        txt7 = (EditText)findViewById(R.id.editText7);
        txt8 = (EditText)findViewById(R.id.editText8);
        txt9 = (EditText)findViewById(R.id.editText9);
        txt10 = (EditText)findViewById(R.id.editText10);
        txt11 = (EditText)findViewById(R.id.editText11);
        imgBack = (ImageView)findViewById(R.id.imgBack);

         zbir=0;
        final EditText nizE[]={txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11};
        final int nizBroj[]={7,7,7,7,2,6,6,6,6,4,2};



        imgBack.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onBackPressed();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                double p=prosjek(nizE,nizBroj);
                if(p>0)
                    btn1.setText(String.valueOf(prosjek(nizE, nizBroj)));


            }
        });

    }
    public double prosjek(EditText e[],int niz[])
    {
        int zbir=0;
        try {
            for (int i = 0; i < e.length; i++) {
                zbir = zbir + Integer.parseInt(e[i].getText().toString()) * niz[i];
            }
        }catch(NumberFormatException n)
        {
            n.printStackTrace();
            Toast t = Toast.makeText(getApplicationContext(),"Unesite sve ocjene",Toast.LENGTH_SHORT);
            t.setGravity(Gravity.BOTTOM,0,0);
            t.show();
        }
        return zbir/60.0;
    }
    public boolean unos(EditText e[])
    {
        for(int i=0;i<e.length;i++)
        {
            if(e[i].getText().toString()==null)
            {
                return false;
            }
        }
        return true;
    }
}
