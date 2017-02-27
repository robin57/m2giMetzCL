package com.example.ameli.chat;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;


/**
 * Created by ameli on 17/01/2017.
 */

public class DrawPadFragment extends Fragment implements View.OnClickListener{

    View myView ;
    private DrawingView drawView;
    private ImageButton currPaint;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.drawpad_layout,container,false);

        drawView = (DrawingView)myView.findViewById(R.id.drawing);
        LinearLayout paintLayout = (LinearLayout)myView.findViewById(R.id.paint_colors);
        currPaint = (ImageButton)paintLayout.getChildAt(0);

        currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));

        return myView;
    }

    public void paintClicked(View view){
        //use chosen color
        if(view!=currPaint){
            //update color
            ImageButton imgView = (ImageButton)view;
            String color = view.getTag().toString();
            drawView.setColor(color);
            imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
            currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
            currPaint=(ImageButton)view;
        }
    }

    @Override
    public void onClick(View v) {

    }
}
