package com.empireyard.wikirun.screens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.empireyard.wikirun.R;
import com.empireyard.wikirun.WikiRun;

/**
 * Created by osk on 04.02.17.
 */

public class SignUpScreen extends Activity {

    String classLogTag = SignUpScreen.class.getSimpleName().toString();

    EditText username_edit;
    EditText email_edit;
    EditText password_edit;
    EditText confirm_password_edit;

    Button return_button;
    Button finish_button;

    StringBuffer messageArray;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sign_up_button);

        username_edit = (EditText) findViewById(R.id.username_edit);
        email_edit = (EditText) findViewById(R.id.email_edit);
        password_edit = (EditText) findViewById(R.id.password_edit);
        confirm_password_edit = (EditText) findViewById(R.id.confirm_password_edit);

        return_button = (Button) findViewById(R.id.return_button);
        finish_button = (Button) findViewById(R.id.finish_button);

        username_edit.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                Log.d(classLogTag, "username_edit clicked");

                return false;
            }
        });

        email_edit.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                Log.d(classLogTag, "email_edit clicked");

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

        confirm_password_edit.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                Log.d(classLogTag, "confirm_password_edit clicked");

                return false;
            }
        });


        finish_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(classLogTag, "finish_button clicked");
                Intent intent = new Intent(SignUpScreen.this, MainMenuScreen.class);

                startActivity(intent);
            }
        });

        return_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(classLogTag, "return_button clicked");
                Intent intent = new Intent(SignUpScreen.this, WelcomeScreen.class);

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
