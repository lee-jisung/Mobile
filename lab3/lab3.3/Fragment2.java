package com.leejisung.lab3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by leejisung on 2018-04-25.
 */

public class Fragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstaceState){
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment2, container, false);
        return rootView;
    }

}
