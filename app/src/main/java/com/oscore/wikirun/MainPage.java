package com.oscore.wikirun;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ParseException;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ActionMenuItemView;
import android.text.Html;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;


public class MainPage extends AppCompatActivity {
    private static final String message = RunGame.class.getSimpleName();

    String pageContent;
    Document pageData;
    ProgressDialog mProgressDialog;

    String msg_start_page;
    String msg_end_page;

    EditText start_page_name;
    EditText end_page_name;

    Button gen_start_page;
    Button gen_end_page;
    Button run_button;
    Button reset_button;

    GenWebView webViewGen;

   // WebView webViewGen;
    String wikiUrl = "https://en.m.wikipedia.org/wiki/";
    private int steps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_main);
        final Intent intent = new Intent(MainPage.this, RunGame.class);

        webViewGen = new GenWebView(R.id.web_view_gen, intent);

        start_page_name = (EditText)findViewById(R.id.start_page_name);
        end_page_name = (EditText)findViewById(R.id.end_page_name);

        gen_start_page=(Button)findViewById(R.id.gen_start_page);
        gen_end_page=(Button)findViewById(R.id.gen_end_page);
        run_button=(Button)findViewById(R.id.run_button);
        reset_button=(Button)findViewById(R.id.reset_button);

        gen_start_page.setText("GEN");
        gen_end_page.setText("GEN");
        start_page_name.setText("Start page name...");
        end_page_name.setText("End page name...");

        start_page_name.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                gen_start_page.setText("OK");
                start_page_name.setText(" ");
                InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                im.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT);
                return false;
            }
        });

        end_page_name.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                gen_end_page.setText("OK");
                end_page_name.setText(" ");
                InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                im.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT);
                return false;
            }
        });

        gen_start_page.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (gen_start_page.getText() == "GEN") {
                    webViewGen.loadPage("Special:Random", start_page_name);
                }else if (gen_start_page.getText()=="OK"){
                    msg_start_page = start_page_name.getText().toString();
                    webViewGen.loadPage(msg_start_page.replaceAll("[ ]", "_"), start_page_name);
                }
            }
        });
        gen_end_page.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (gen_end_page.getText()=="GEN") {
                    webViewGen.loadPage("Special:Random", end_page_name);
                }else if (gen_end_page.getText()=="OK"){
                    msg_end_page = end_page_name.getText().toString();
                    webViewGen.loadPage(msg_end_page.replaceAll("[ ]", "_"), end_page_name);
                }
            }
        });
        run_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                webViewGen.webView.destroy();
                startActivity(intent);
                gen_start_page.setText("GEN");
                gen_end_page.setText("GEN");
                start_page_name.setText("Start page name...");
                end_page_name.setText("End page name...");
                finish();
            }
        });

        reset_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gen_start_page.setText("GEN");
                gen_end_page.setText("GEN");
                start_page_name.setText("Start page name...");
                end_page_name.setText("End page name...");
            }
        });
        Log.d(message, "onCreate() event");
    }

    public class GenWebView{
        WebView webView;
        String pageName;
        Uri uri;
        EditText editTextName;
        Intent myIntent;
        WebSettings webSettings;
        public GenWebView(int webViewId, Intent intent){
            myIntent = intent;
            webView = (WebView) findViewById(webViewId);
            webView.setVisibility(webView.INVISIBLE);
            webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageFinished(WebView view, String url) {
                    view.loadUrl("javascript:(function() {" +
                            "document.getElementsByClassName('header-container')[0].style.display='none';})()");
                    view.loadUrl("javascript:(function() {" +
                            "document.getElementsByClassName('footer-places hlist hlist-separated')[0].style.display='none';})()");
                    view.loadUrl("javascript:(function() {" +
                            "document.getElementsByClassName('license')[0].firstElementChild.removeAttribute('href');})()");
                    view.loadUrl("javascript:(function() {" +
                            "document.getElementsByClassName('section-heading in-block collapsible-heading open-block')[0].style.display='none';})()");
                    view.loadUrl(
                            "javascript:(function() {" +
                                    "var k = 0;" +
                                    "var element = document.getElementById('mw-content-text');" +
                                    "var divElements = element.getElementsByTagName('div');" +
                                    "var h2Elements = element.getElementsByTagName('h2');" +
                                    "var spanElements = element.getElementsByTagName('span');" +
                                    "for(var i = 0; i < spanElements.length; i++){" +
                                    "if(spanElements[i].id == 'See_also'){" +
                                    "k = 1;" +
                                    "};" +
                                    "if(k == 1){" +
                                    "spanElements[i].style.display='none';" +
                                    "spanElements[i].parentNode.style.display='none';" +
                                    "}"+
                                    "}" +
                                    "})()");
                    pageName = view.getTitle().replace(" - Wikipedia", "");
                    editTextName.setText(pageName);
                    pageName = pageName.replaceAll("[ ]", "_");
                    Log.i(message, "GenWebView() page name - '"+editTextName.getId()+"'");
                    Log.i(message, "GenWebView() page name - '"+pageName+"'");

                    myIntent.putExtra(Integer.toString(editTextName.getId()), pageName);
                    view.setVisibility(view.VISIBLE);
                }
            });
        }
        public void loadPage(String pageName, EditText editText){
            editTextName = editText;
            webView.loadUrl(wikiUrl + pageName);
        }
    }

//    protected void WikiPage(String page_name){
//        finished = false;
//        webViewGen = (WebView) findViewById(R.id.web_view_gen);
//        webViewGen.setVisibility(webViewGen.INVISIBLE);
//        webSettings = webViewGen.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webViewGen.setWebViewClient(new WebViewClient() {
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                finished = true;
//            }
//        });
//        webViewGen.loadUrl(wikiUrl + page_name);
//    }


    @Override
    protected void onStart(){
        super.onStart();
        Log.d(message, "onStart() event");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(message, "onResume() event");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(message, "onPause() event");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(message, "onStop() event");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(message, "onDestroy() event");
    }
}
