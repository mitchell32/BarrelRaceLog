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

public class LocationActivity extends ListActivity {
    //LIST OF ARRAY STRINGS THAT WILL SERVE AS ARENA NAMES
    ArrayList<String> listItems = new ArrayList<String>();

    //DEFINING A STRING ADAPTER THAT WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;

    ListView myListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_view);

        myListView = (ListView) findViewById(android.R.id.list);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        setListAdapter(adapter);
/*//FOR LIST ITEM CLICK
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String arena = listItems.get(position);
                Intent intent = new Intent(getBaseContext(), RaceActivity.class);
                intent.putExtra("ARENA_DETAILS", arena);
                startActivity(intent);
            }
        });*/
    }

    //METHOD THAT WILL HANDLE DYNAMIC INSERTION OF ARENA NAMES
    public void addLocation(View v) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.add_arena_popup);
        Button btnAdd = (Button) dialog.findViewById(R.id.add_arena);
        Button btnCancel = (Button) dialog.findViewById(R.id.cancel_arena);

        dialog.show();
        btnAdd.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                EditText editText = (EditText) dialog.findViewById(R.id.edit_arena);
                String arenaName = editText.getText().toString();
                listItems.add(arenaName);
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

