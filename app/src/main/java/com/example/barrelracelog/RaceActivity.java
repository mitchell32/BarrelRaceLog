package com.example.barrelracelog;

import android.app.Dialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by mitch on 4/20/2017.
 */

public class RaceActivity extends ListActivity {
    //LIST OF ARRAY OBJECTS THAT WILL SERVE AS SPECIFIC RACES
    ArrayList<String> raceListItems = new ArrayList<String>();

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;

    ListView myListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.races_view);

        myListView = (ListView) findViewById(android.R.id.list);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                raceListItems);
        setListAdapter(adapter);

        //FOR LIST ITEM CLICK
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String race = raceListItems.get(position);
                Intent intent = new Intent(getBaseContext(), SpecificRaceActivity.class);
                intent.putExtra("RACE_DETAILS", race);
                startActivity(intent);
            }
        });

    }
    //METHOD WHICH WILL HANDLE DYNAMIC INSERTION

    public void addRace(View v) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.add_race_popup);
        Button btnAdd = (Button) dialog.findViewById(R.id.add_race);
        Button btnCancel = (Button) dialog.findViewById(R.id.cancel_race);


        dialog.show();

        btnAdd.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                EditText editText = (EditText) dialog.findViewById(R.id.edit_race);
                String raceDetails = editText.getText().toString();
                raceListItems.add(raceDetails);
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }


        });

        btnCancel.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                dialog.dismiss();
            }

        });
    }


}
