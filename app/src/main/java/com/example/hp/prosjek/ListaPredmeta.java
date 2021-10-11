package com.example.hp.prosjek;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;



public class ListaPredmeta extends AppCompatActivity
{

    @Override
    public void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.predmeti);
        getSupportActionBar().hide();

        String lista [] = {"Uvod u kompjuterske nauke","Operativni sistemi","Matematika I","Ebgleski I","Principi programiranja","Fizika"};

        ListAdapter bla = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        ListView lv1 = (ListView)findViewById(R.id.lv1);
        lv1.setAdapter(bla);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(),PredmetActivity.class);
                startActivity(i);

            }
        });

    }






}
