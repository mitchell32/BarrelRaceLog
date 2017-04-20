package com.example.barrelracelog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by mitch on 4/19/2017.
 */

public class RegisterActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // set View to register.xml
        setContentView(R.layout.register_view);

        TextView loginScreen = (TextView) findViewById(R.id.link_to_login);

        // Listening to login screen link
        loginScreen.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //closing registration screen
                //switching to Login screen
                finish();
            }
        });
    }

}