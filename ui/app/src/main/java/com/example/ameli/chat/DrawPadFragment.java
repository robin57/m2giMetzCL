package com.example.ameli.chat;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ameli on 17/01/2017.
 */

public class DrawPadFragment extends Fragment{

    View myView ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.drawpad_layout,container,false);
        return myView;
    }
}
