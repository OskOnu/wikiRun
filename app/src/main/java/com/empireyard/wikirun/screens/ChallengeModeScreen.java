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

/**
 * Created by osk on 04.02.17.
 */

public class ChallengeModeScreen extends Activity {
    String classLogTag = FinishScreen.class.getSimpleName().toString();

    EditText friend_name_edit;

    Button add_button;
    Button accept_button;

    Button scroll_menu_button;

    StringBuffer messageArray;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.challenge_mode_screen);

        friend_name_edit = (EditText) findViewById(R.id.friend_name_edit);
        add_button = (Button) findViewById(R.id.add_button);
        accept_button = (Button) findViewById(R.id.accept_button);
        scroll_menu_button = (Button) findViewById(R.id.scroll_menu_button);

        friend_name_edit.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                Log.d(classLogTag, "friend_name_edit clicked");

                return false;
            }
        });

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(classLogTag, "add_button clicked");

            }
        });

        accept_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(classLogTag, "accept_button clicked");
                Intent intent = new Intent(ChallengeModeScreen.this, PlayScreen.class);

                startActivity(intent);
            }
        });

        scroll_menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(classLogTag, "scroll_menu_button clicked");

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(classLogTag, "onStart() event");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(classLogTag, "onResume() event");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(classLogTag, "onPause() event");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(classLogTag, "onStop() event");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(classLogTag, "onDestroy() event");
    }
}
