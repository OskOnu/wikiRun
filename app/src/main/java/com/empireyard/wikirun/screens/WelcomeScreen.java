package com.empireyard.wikirun.screens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.empireyard.wikirun.R;
import com.empireyard.wikirun.WikiRun;

/**
 * Created by osk on 04.02.17.
 */

public class WelcomeScreen extends Activity {

    String classLogTag = WelcomeScreen.class.getSimpleName().toString();

    WikiRun wikiRun;

    TextView app_title_text;
    TextView description_text;

    Button log_in_button;
    Button sign_up_button;
    TextView offline_mode_button;

    StringBuffer messageArray;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.welcome_screen);

        app_title_text = (TextView) findViewById(R.id.title_text);
        description_text = (TextView) findViewById(R.id.description_text);

        log_in_button = (Button) findViewById(R.id.log_in_button);
        sign_up_button = (Button) findViewById(R.id.sign_up_button);
        offline_mode_button = (TextView) findViewById(R.id.offline_mode_button);

        log_in_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(classLogTag, "log_in_button clicked");
                Intent intent = new Intent(WelcomeScreen.this, LogInScreen.class);

                startActivity(intent);

            }
        });

        sign_up_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(classLogTag, "sign_up_button clicked");
                Intent intent = new Intent(WelcomeScreen.this, SignUpScreen.class);

                startActivity(intent);

            }
        });

        offline_mode_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(classLogTag, "offline_mode_button clicked");
                Intent intent = new Intent(WelcomeScreen.this, MainMenuScreen.class);

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(classLogTag, "onStart() event");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(classLogTag, "onResume() event");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(classLogTag, "onPause() event");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(classLogTag, "onStop() event");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(classLogTag, "onDestroy() event");
    }
}
