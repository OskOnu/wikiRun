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

public class PlayScreen extends Activity {

    String classLogTag = PlayScreen.class.getSimpleName().toString();

    TextView final_article_text;
    TextView steps_text;
    TextView time_text;

    Button leave_button;
    Button scroll_menu_button;

    StringBuffer messageArray;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.play_screen);

        final_article_text = (TextView) findViewById(R.id.final_article_text);
        steps_text = (TextView) findViewById(R.id.steps_text);
        time_text = (TextView) findViewById(R.id.time_text);

        leave_button = (Button) findViewById(R.id.leave_button);
        scroll_menu_button = (Button) findViewById(R.id.scroll_menu_button);


        leave_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(classLogTag, "leave_button clicked");
                Intent intent = new Intent(PlayScreen.this, MainMenuScreen.class);

                startActivity(intent);
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
