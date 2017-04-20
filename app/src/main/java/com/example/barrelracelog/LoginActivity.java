package com.example.barrelracelog;

/**
 * Created by mitch on 4/19/2017.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;


import android.widget.Button;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setting default screen to login.xml
        setContentView(R.layout.login_view);

        TextView registerScreen = (TextView) findViewById(R.id.link_to_register);

        // Listening to register new account link
        registerScreen.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                //Switching to Register screen
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });

        Button btn = (Button) findViewById(R.id.link_to_horse_view);

        btn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent i = new Intent(LoginActivity.this, HorseActivity.class);
                startActivity(i);
            }
        });
    }
}

