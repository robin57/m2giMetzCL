package com.example.ameli.chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class Connection extends AppCompatActivity {

    Button connection = null;
    TextView test = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connection_layout);

        // On récupère toutes les vues dont on a besoin
        connection = (Button) findViewById(R.id.connection);


        // On attribue un listener adapté aux vues qui en ont besoin

        connection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Le premier paramètre est le nom de l'activité actuelle
                // Le second est le nom de l'activité de destination
                Intent secondActivity = new Intent(Connection.this, NavigationDrawerManager.class);

                // Puis on lance l'intent !
                startActivity(secondActivity);
            }
        });
    }
}
