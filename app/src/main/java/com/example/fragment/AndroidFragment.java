package com.example.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AndroidFragment extends Fragment {

    TextView txtFA;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_android, container, false);
        txtFA = v.findViewById(R.id.textviewFragmentAndroid);
        txtFA.setText("Hehe");
        return v;
    }

}
