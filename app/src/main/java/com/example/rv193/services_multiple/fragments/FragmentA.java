package com.example.rv193.services_multiple.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.rv193.services_multiple.Communicator;
import com.example.rv193.services_multiple.R;

/**
 * FragmentA has a button that sends information to fragmentB
 * The information is sent through an interface that is implemented in
 * MainActivity
 */
public class FragmentA extends Fragment implements View.OnClickListener{
    //an interface reference variable can interface with a subclass
    //object. in this case that is MainActivity
    //This is a property of Dynamic runtime polymorphism
    Communicator comm;
    Button button;
    int counter=0;
    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null){
            counter = 0;
        }
        else{
            counter = savedInstanceState.getInt("counter",0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comm = (Communicator)getActivity();//Interface = subclass casting
        button= (Button) getActivity().findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
    }

    @Override
    public void onClick(View v) {
        counter++;
        comm.respond("The button clicked increments counter :"+ counter+" times");
    }
}
