package com.example.jota.login2;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jota on 06-06-2015.
 */
public class FragmentConfiguracion extends Fragment {

    public FragmentConfiguracion(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_configuracion, container, false);
        return rootView;
    }
}