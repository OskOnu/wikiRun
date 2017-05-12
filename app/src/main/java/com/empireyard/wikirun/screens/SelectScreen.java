package com.empireyard.wikirun.screens;

import android.app.Activity;
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

public class SelectScreen extends Activity{

    String classLogTag = SelectScreen.class.getSimpleName().toString();

    EditText choose_article_text;
    Button search_button;
    Button random_button;

    Button start_article_button;
    Button final_article_button;
    Button accept_button;

    Button scroll_menu_button;

    StringBuffer messageArray;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.select_screen);

        choose_article_text = (EditText) findViewById(R.id.choose_article_text);
        search_button = (Button) findViewById(R.id.search_button);
        random_button = (Button) findViewById(R.id.random_button);
        start_article_button = (Button) findViewById(R.id.start_article_button);
        final_article_button = (Button) findViewById(R.id.final_article_button);
        accept_button = (Button) findViewById(R.id.accept_button);
        scroll_menu_button = (Button) findViewById(R.id.scroll_menu_button);

        choose_article_text.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                Log.d(classLogTag, "choose_article_text clicked");

                return false;
            }
        });

        search_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(classLogTag, "search_button clicked");

            }
        });

        random_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(classLogTag, "random_button clicked");

            }
        });

        start_article_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(classLogTag, "start_article clicked");

            }
        });

        final_article_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(classLogTag, "final_article clicked");

            }
        });

        accept_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(classLogTag, "accept_button clicked");

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
