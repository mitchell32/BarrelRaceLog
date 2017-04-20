package com.example.barrelracelog;

import android.app.Dialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by mitch on 4/19/2017.
 */

public class HorseActivity extends AppCompatActivity {
    //LIST OF ARRAY STRINGS THAT WILL SERVE AS HORSE NAMES
    ArrayList<String> listItems = new ArrayList<String>();

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;

    int[] imageId;

    GridView grid;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horse_view);

       // CustomGrid adapter = new CustomGrid(HorseActivity.this, "STEVE", imageId);
        grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

            }
        });
    }

    //METHOD WHICH WILL HANDLE DYNAMIC INSERTION
    public void addHorse(View v) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.add_horse_popup);
        Button btnAdd = (Button) dialog.findViewById(R.id.add_horse);
        Button btnCancel = (Button) dialog.findViewById(R.id.cancel_horse);


        dialog.show();

        btnAdd.setOnClickListener(new View.OnClickListener() {

            /* Check if add button is pressed before entering a name and make sure that
            it does not get added to the horse name list
             */
            public void onClick(View v) {
                EditText editText = (EditText) dialog.findViewById(R.id.edit_horse);
                String horseName = editText.getText().toString();
                listItems.add(horseName);
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
