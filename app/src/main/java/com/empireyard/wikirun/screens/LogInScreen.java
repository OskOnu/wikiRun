package com.empireyard.wikirun.screens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.empireyard.wikirun.R;
import com.empireyard.wikirun.WikiRun;

/**
 * Created by osk on 04.02.17.
 */

public class LogInScreen extends Activity{

    String classLogTag = LogInScreen.class.getSimpleName().toString();

    EditText username_or_email_edit;
    EditText password_edit;
    Button log_in_button;
    Button return_button;

    StringBuffer messageArray;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.log_in_screen);

        username_or_email_edit = (EditText) findViewById(R.id.username_or_email_edit);
        password_edit = (EditText) findViewById(R.id.password_edit);
        log_in_button = (Button) findViewById(R.id.log_in_button);
        return_button = (Button) findViewById(R.id.return_button);

        username_or_email_edit.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                Log.d(classLogTag, "username_or_email_edit clicked");

                return false;
            }
        });

        password_edit.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                Log.d(classLogTag, "password_edit clicked");

                return false;
            }
        });

        log_in_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(classLogTag, "log_in_button clicked");
                Intent intent = new Intent(LogInScreen.this, MainMenuScreen.class);

                startActivity(intent);
            }
        });

        return_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(classLogTag, "return_button clicked");
                Intent intent = new Intent(LogInScreen.this, WelcomeScreen.class);

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
