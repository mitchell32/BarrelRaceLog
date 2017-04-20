package com.example.barrelracelog;

import android.app.Activity;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mitch on 4/19/2017.
 */

public class HorseActivity extends Activity {

    public class MyAdapter extends BaseAdapter {

        final int NumberOfItem = 30;
        private Bitmap[] bitmap = new Bitmap[NumberOfItem];

        private Context context;
        private LayoutInflater layoutInflater;

        MyAdapter(Context c) {
            context = c;
            layoutInflater = LayoutInflater.from(context);

            //initial dummy bitmap
            //using R.drawable.icon for all items
            for(int i = 0; i < NumberOfItem; i++){
                bitmap[i] = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
            }
        }

        @Override
        public int getCount(){
            return bitmap.length;
        }

        @Override
        public Object getItem(int position){
            return bitmap[position];
        }

        @Override
        public long getItemId(int position){
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            View grid;
            if(convertView==null){
                grid = new View(context);
                grid = layoutInflater.inflate(R.layout.grid_single, null);
            } else{
                grid = convertView;
            }

            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            imageView.setImageBitmap(bitmap[position]);
            TextView textView = (TextView)grid.findViewById(R.id.grid_text);
            textView.setText(String.valueOf(position));

            return grid;
        }

    }

    GridView gridView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horse_view);
        gridView = (GridView)findViewById(R.id.grid);

        MyAdapter adapter = new MyAdapter(this);
        gridView.setAdapter(adapter);
    }
}
