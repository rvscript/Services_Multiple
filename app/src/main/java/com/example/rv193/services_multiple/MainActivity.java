package com.example.rv193.services_multiple;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rv193.services_multiple.fragments.FragmentB;

/*
A project for demonstrating communication between components
such as activities and behaviors such as fragments
 */
public class MainActivity extends AppCompatActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Method from Communicator interface that must be implemented
    //FragmentA will create an Interface/Mainactivity instance
    //Through casting.
    //Any class that implements an interface is a child of that interface
    //and can be casted to the interface
    // Communicator C = (Communicator)getActivity();
    @Override
    public void respond(String data) {
        FragmentManager manager= getSupportFragmentManager();
        FragmentB fB =(FragmentB) manager.findFragmentById(R.id.fragmentB);
        //FragmentB gets the data passed to it from FragmentA
        fB.changeText(data);
    }
}
