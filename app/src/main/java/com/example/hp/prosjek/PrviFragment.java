package com.example.hp.prosjek;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Hp on 9/1/2017.
 */

public class PrviFragment extends Fragment
{

    private Listener1 lis;
    private LinearLayout biljeska1;

    public interface Listener1
    {
        public void intentChange();
    }
    public PrviFragment()
    {

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.lis=(Listener1)context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.prvi_fragment,container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        biljeska1 =(LinearLayout)getActivity().findViewById(R.id.biljeska1);
        biljeska1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lis.intentChange();
            }
        });

    }
}
