package com.example.hp.prosjek;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


public class Menu extends AppCompatActivity
{

    private TextView dan1,dan2,dan3,dan4,dan5,txtInfo1,txtInfo2,txtInfo3,txtInfo4,txtInfo5,txtPred1,txtPred2,txtPred3,txtPred4,txtPred5;
    private LinearLayout btnProsjek;
    private ImageView btnRaspored,imgPodesavanja;
    private LinearLayout btnObavestenja,linPodesavanja,linAdd;
    private LinearLayout predmetiBtn;
    private Button btnAdd,btnChange;
    private int dan;
    private ListView lista;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       if(mToggle.onOptionsItemSelected(item)){
           return true;
       }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);

        setContentView(R.layout.menu);




        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.Open,R.string.Close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





        String listaPredmeta [] = {"Uvod u kompjuterske nauke","Operativni sistemi","Matematika I","Ebgleski I","Principi programiranja","Fizika"};
        lista = (ListView)findViewById(R.id.listPredmeti);
        ListAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaPredmeta);
        lista.setAdapter(adapter);

         btnProsjek=(LinearLayout) findViewById(R.id.linBtn3);
         btnObavestenja=(LinearLayout)findViewById(R.id.linBtn1);
         predmetiBtn=(LinearLayout)findViewById(R.id.linBtn2);


        LinearLayout lin1=(LinearLayout)findViewById(R.id.lin1);
        LinearLayout lin2=(LinearLayout)findViewById(R.id.lin2);
        LinearLayout lin3=(LinearLayout)findViewById(R.id.lin3);
        LinearLayout lin4=(LinearLayout)findViewById(R.id.lin4);
        LinearLayout lin5=(LinearLayout)findViewById(R.id.lin5);

        linPodesavanja =(LinearLayout)findViewById(R.id.linPodesavanja);
         linAdd=(LinearLayout)findViewById(R.id.lin342);


        final LinearLayout nizLinear[]={lin1,lin2,lin3,lin4,lin5};

        dan1 =(TextView) findViewById(R.id.dan1);
        dan2 =(TextView) findViewById(R.id.dan2);
        dan3 =(TextView) findViewById(R.id.dan3);
        dan4 =(TextView) findViewById(R.id.dan4);
        dan5 =(TextView) findViewById(R.id.dan5);

        //vrijeme i sala
        txtInfo1 =(TextView) findViewById(R.id.txtInfo1);
        txtInfo2 =(TextView) findViewById(R.id.txtInfo2);
        txtInfo3 =(TextView) findViewById(R.id.txtInfo3);
        txtInfo4 =(TextView) findViewById(R.id.txtInfo4);
        txtInfo5 =(TextView) findViewById(R.id.txtInfo5);

        //imena predmeta
        txtPred1 =(TextView) findViewById(R.id.txtPred1);
        txtPred2 =(TextView) findViewById(R.id.txtPred2);
        txtPred3 =(TextView) findViewById(R.id.txtPred3);
        txtPred4 =(TextView) findViewById(R.id.txtPred4);
        txtPred5 =(TextView) findViewById(R.id.txtPred5);


        final TextView nizPredmeta []={txtPred1,txtPred2,txtPred3,txtPred4,txtPred5};
        final TextView nizInfo []={txtInfo1,txtInfo2,txtInfo3,txtInfo4,txtInfo5};

        final TextView nizTxt[]={dan1,dan2,dan3,dan4,dan5};


        btnAdd= (Button)findViewById(R.id.btnAdd);
        btnChange= (Button)findViewById(R.id.btnChange);





        btnRaspored = (ImageView)findViewById(R.id.imgPodesavanja);



        Raspored ponedeljak[]={new Raspored("Programiranje I","10:15-12:30  sala : 012"),
                new Raspored("Matematika III (p) ","12:45-14:15  sala : 210"),
                new Raspored("Matematika III (v) ","14:15-16:00  sala : 107-A")};
        Raspored utorak[]= {new Raspored("nema predavanja","")
        };
        Raspored srijeda[]={
                new Raspored("Distribuirani (p) ","09:00-10:30  sala : 109"),
                new Raspored("Distribuirani (v) ","10:30-12:00  sala : 109"),
                new Raspored("Engleski III ","12:15-14:00  sala : 227")};
        Raspored cetvrtak[]={new Raspored("Baze podataka I (p)","12:15-15:00  sala : 210"),
                new Raspored("Baze podataka I (v) ","15:15-17:00  sala : 210"),
                new Raspored("Programiranje I ","17:00-18:30  sala : 227")};
        Raspored petak[]={new Raspored("Objektno (p) ","08:15-10:00  sala : 210"),
                new Raspored("Objektno (v) ","10:15-11:00  sala : 210")};



        final Dan nizDana[]={new Dan(ponedeljak),new Dan(utorak),new Dan(srijeda),new Dan(cetvrtak),new Dan(petak)};

        IzracunajDan izracunajDan = new IzracunajDan();
        dan=0;

        nizTxt[dan].setBackgroundResource(R.drawable.dani);
        nizTxt[1].setBackgroundResource(R.drawable.dani2);
        nizDana[dan].unesiRaspored(nizPredmeta,nizInfo,nizLinear);


        btnRaspored.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               nizDana[0].rasporedGone(nizLinear);
                linPodesavanja.setVisibility(View.VISIBLE);

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linPodesavanja.setVisibility(View.GONE);

                linAdd.setVisibility(View.VISIBLE);


            }
        });
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pokaziRaspored(nizTxt,nizDana,nizLinear,nizPredmeta,nizInfo);
                linPodesavanja.setVisibility(View.GONE);
                nizTxt[dan].setBackgroundResource(R.drawable.dani);
                nizTxt[1].setBackgroundResource(R.drawable.dani2);
                nizDana[dan].unesiRaspored(nizPredmeta,nizInfo,nizLinear);
                for(int j=0;j<5;j++)
                {
                    if(j!=dan)
                        nizTxt[j].setBackgroundResource(R.drawable.dani2);
                }

            }
        });



        pokaziRaspored(nizTxt,nizDana,nizLinear,nizPredmeta,nizInfo);



        btnProsjek.setOnClickListener(new Button.OnClickListener()
        {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Menu.this,MainActivity.class);
            startActivity(i);

        }
    });
        btnObavestenja.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this,Obavestenja.class);
                startActivity(i);


            }
        });

        predmetiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this,ListaPredmeta.class);
                startActivity(i);
            }
        });




    }

    public void pokaziRaspored(final TextView nizTxt[], final Dan nizDana[],final LinearLayout nizLinear[],final TextView nizPredmeta [],final TextView nizInfo [])
    {
        for(int i=0;i<5;i++)
        {
            final int fi=i;
            nizTxt[i].setOnClickListener(new Button.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    nizTxt[fi].setBackgroundResource(R.drawable.dani);

                    nizDana[fi].unesiRaspored(nizPredmeta,nizInfo,nizLinear);

                    for(int j=0;j<5;j++)
                    {
                        if(j!=fi)
                            nizTxt[j].setBackgroundResource(R.drawable.dani2);
                    }
                }
            });
        }

    }



}
