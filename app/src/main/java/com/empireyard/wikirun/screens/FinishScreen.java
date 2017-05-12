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

public class FinishScreen extends Activity{
    String classLogTag = FinishScreen.class.getSimpleName().toString();

    TextView start_article_text;
    TextView final_article_text;
    TextView steps_text;
    TextView time_text;

    Button ranking_button;
    Button try_again_button;

    Button scroll_menu_button;

    StringBuffer messageArray;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.finish_screen);

        start_article_text = (TextView) findViewById(R.id.start_article_text);
        final_article_text = (TextView) findViewById(R.id.final_article_text);
        steps_text = (TextView) findViewById(R.id.steps_text);
        time_text = (TextView) findViewById(R.id.time_text);
        ranking_button = (Button) findViewById(R.id.ranking_button);
        try_again_button = (Button) findViewById(R.id.try_again_button);
        scroll_menu_button = (Button) findViewById(R.id.scroll_menu_button);


        ranking_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(classLogTag, "ranking_button clicked");

            }
        });

        try_again_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(classLogTag, "try_again_button clicked");
                Intent intent = new Intent(FinishScreen.this, PlayScreen.class);

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
