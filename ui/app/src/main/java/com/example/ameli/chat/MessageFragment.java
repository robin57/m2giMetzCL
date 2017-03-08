package com.example.ameli.chat;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by ameli on 17/01/2017.
 */

public class MessageFragment extends Fragment{

    View myView ;
    ListView mListView;
    String[] messages ={"Coucou"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.message_layout,container,false);


        mListView = (ListView) myView.findViewById(R.id.list_of_message);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(myView.getContext(),
                android.R.layout.simple_list_item_1, messages);

        mListView.setAdapter(adapter);
        return myView;


    }
}
