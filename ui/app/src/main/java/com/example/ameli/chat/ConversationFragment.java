package com.example.ameli.chat;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * Created by ameli on 07/03/2017.
 */

public class ConversationFragment extends Fragment{

    View myView ;

    ListView mListView;

    String[] conversation ={"conversation 1", "conversation 2"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.conversation_layout,container,false);


        mListView = (ListView) myView.findViewById(R.id.list_of_message);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(myView.getContext(),
                android.R.layout.simple_list_item_1, conversation);

        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // When clicked, show a toast with the TextView text

                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame,new MessageFragment()).commit();
            }
        });

        return myView;
    }
}
