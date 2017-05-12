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

public class MainMenuScreen extends Activity{

    String classLogTag = MainMenuScreen.class.getSimpleName().toString();

    Button single_mode_button;
    Button challenge_mode_button;
    Button ranking_button;
    Button invite_friends_button;
    Button scroll_menu_button;

    StringBuffer messageArray;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_menu_screen);

        single_mode_button = (Button) findViewById(R.id.single_mode_button);
        challenge_mode_button = (Button) findViewById(R.id.challenge_mode_button);
        ranking_button = (Button) findViewById(R.id.ranking_button);
        invite_friends_button = (Button) findViewById(R.id.invite_friends_button);
        scroll_menu_button = (Button) findViewById(R.id.scroll_menu_button);

        single_mode_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(classLogTag, "single_mode_button. clicked");
                Intent intent = new Intent(MainMenuScreen.this, PlayScreen.class);

                startActivity(intent);
            }
        });

        challenge_mode_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(classLogTag, "challenge_mode_button clicked");
                Intent intent = new Intent(MainMenuScreen.this, ChallengeModeScreen.class);

                startActivity(intent);
            }
        });

        ranking_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(classLogTag, "ranking_button clicked");

            }
        });

        invite_friends_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(classLogTag, "invite_friends_button clicked");

            }
        });

        scroll_menu_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(classLogTag, "scroll_menu_button clicked");

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
