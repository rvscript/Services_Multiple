package com.example.rv193.services_multiple.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rv193.services_multiple.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment {
    TextView textView;
    String data;
    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_b, container, false);

        if(savedInstanceState==null){
            data = "";
        }else{
            data = savedInstanceState.getString("text");
            TextView textView = (TextView)view.findViewById(R.id.textView);
            textView.setText(data);
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView = (TextView)getActivity().findViewById(R.id.textView);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text", data);
    }

    public void changeText(String data) {
        this.data = data;
        textView.setText(this.data);
    }
}
