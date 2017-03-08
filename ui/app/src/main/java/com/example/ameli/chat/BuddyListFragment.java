package com.example.ameli.chat;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ameli on 17/01/2017.
 */

public class BuddyListFragment extends Fragment{

    View myView ;
    private ArrayList<String> friend = new ArrayList<String>();
    private ArrayList<String> ennemy= new ArrayList<String>();
    private ListView friendList;
    private ListView ennemyList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.buddy_list_layout,container,false);

        friendList = (ListView) myView.findViewById(R.id.list_of_friend);
        ennemyList = (ListView) myView.findViewById(R.id.list_of_unfriend);
        generateList();

        friendList.setAdapter(new FriendListAdapter(myView.getContext(),R.layout.buddylist_list_layout,friend));
        ennemyList.setAdapter(new EnnemyListAdapter(myView.getContext(),R.layout.buddylist_list_layout,ennemy));

        return myView;
    }

    private void generateList(){
        //TODO get children infos from database
        for(int i=1; i <=3; i++) {
           friend.add("Buddy n°"+i);
           ennemy.add("Ennemy n°"+i);
        }
    }


    private class FriendListAdapter extends ArrayAdapter<String> {
        private int layout;

        public FriendListAdapter(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            layout=resource;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                ViewManager viewManager = new ViewManager();
                viewManager.thumbnail = (ImageView) convertView.findViewById(R.id.friend_ennemy_thumbnail);
                viewManager.textView = (TextView) convertView.findViewById(R.id.friend_ennemy_text);
                viewManager.textView.setText(friend.get(position));
                viewManager.thumbnail.setImageResource(R.drawable.friend);

                convertView.setTag(viewManager);
            }

            return convertView;
        }
    }

    private class EnnemyListAdapter extends ArrayAdapter<String> {
        private int layout;

        public EnnemyListAdapter(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            layout=resource;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                ViewManager viewManager = new ViewManager();
                viewManager.thumbnail = (ImageView) convertView.findViewById(R.id.friend_ennemy_thumbnail);
                viewManager.textView = (TextView) convertView.findViewById(R.id.friend_ennemy_text);
                viewManager.textView.setText(ennemy.get(position));
                viewManager.thumbnail.setImageResource(R.drawable.ennemy);

                convertView.setTag(viewManager);
            }

            return convertView;
        }
    }

    public class ViewManager {
        ImageView thumbnail;
        TextView textView;
    }

}
