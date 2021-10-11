package com.example.hp.prosjek;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.support.design.R.styleable.SearchView;


// uzima predmet i ubacuje ga u Skidanje.class i stampa obavestenje
public class Obavestenja extends AppCompatActivity {


    private TextView txt1,txt2,txt3;
    private Predmet predmet;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<ObavestenjeObjekat> lista ;
    private RecyclerView myRec;
    private ImageView imgSet,imgBck;
    private android.widget.SearchView searchView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obavestenja);
        getSupportActionBar().hide();

        lista = new ArrayList<>();
        lista.add(new ObavestenjeObjekat("ispit ce biti odlozen za sledeci utorak","21.05.2017 u 14:03"));
        lista.add(new ObavestenjeObjekat("ispit ce biti odlozen za sledeci utorak dhasjdhasf fjashfua jsoprne fuskdmso gshgs  faignsd dsidg gsigsi gsdjg sdgidgs gdsigsdgs","14.03.2017 u 24:42"));
        lista.add(new ObavestenjeObjekat("ispit ce biti odlozen za sledeci utojfas fjsfskajs gsdagasgsa gaskgasglasg agarak","13.03.2017 u 08:35"));
        lista.add(new ObavestenjeObjekat("Rezultati ispita bla bla","14.02.2017 u 11:42"));
        lista.add(new ObavestenjeObjekat("Neko obavestenje","03.02.2017 u 20:42"));
        lista.add(new ObavestenjeObjekat("Raspored ispita za januar bla bla bla bla...","01.02.2017 u 23:42"));
        lista.add(new ObavestenjeObjekat("Rezultati zavrsnog ispita sa predlogom ocjena..Pregled radova utorak nakon predavanja","12.02.2017 u 20:42"));
        lista.add(new ObavestenjeObjekat("ispit ce biedeci utoradasd sfsafd asfsafasj dfsf safask","12.02.2017 u 20:42"));
        lista.add(new ObavestenjeObjekat("ispit ce biedeci ujfkasf jksfksa kjf hsajfh sajhfjsahf hfsj a uhdfs shuh ustorak zavrsnog ispita sa predlogom ocjena..Pregled radova utorak nakon predavanja","12.02.2017 u 20:42"));
        myRec = (RecyclerView)findViewById(R.id.myRec);


        myRec.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        myRec.setLayoutManager(layoutManager);
        adapter= new MyRecyclerViewAdapter(lista);
        myRec.setAdapter(adapter);

        searchView = (SearchView)findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                novaLista(lista,newText);
                return false;
            }
        });


        imgSet = (ImageView)findViewById(R.id.imgSet);
        imgSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RelativeLayout RelFilter = (RelativeLayout)findViewById(R.id.RelFilter2);
                if(RelFilter.getVisibility()==View.GONE)
                     RelFilter.setVisibility(View.VISIBLE);
                else
                    RelFilter.setVisibility(View.GONE);

            }
        });



       imgBck =(ImageView)findViewById(R.id.imgBck);


        imgBck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();

            }
        });
    }

    //vraca listu obavestenja koja sadrze string iz pretrazivanja
    public void novaLista(ArrayList<ObavestenjeObjekat> lista,String searchSadrzaj)
    {
        ArrayList<ObavestenjeObjekat> nova= new ArrayList<>();
        for(ObavestenjeObjekat obv : lista)
        {
            if(obv.getSadrzaj().indexOf(searchSadrzaj)>=0||obv.getDatum().indexOf(searchSadrzaj)>=0)
                nova.add(obv);
        }
        RecyclerView.Adapter adap = new MyRecyclerViewAdapter(nova);
        myRec.setAdapter(adap);
    }

}
