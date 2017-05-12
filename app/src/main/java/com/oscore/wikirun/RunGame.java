package com.oscore.wikirun;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RunGame extends AppCompatActivity {
    private static final String message = RunGame.class.getSimpleName();

    WikiWebView myWebView;
    WebSettings webSettings;
    String wikiUrl = "https://en.m.wikipedia.org/wiki/";
    String wikiPage; //actual page
    String startPage; //actual page
    String endPage;

    Button backward_button;
    Button break_button;
    Button forward_button;

    private TextView text_start_page; //actual page
    private TextView text_end_page;
    private TextView text_steps;

    private int steps = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_run);

        startPage = getIntent().getStringExtra(Integer.toString(2131427447));
        endPage = getIntent().getStringExtra(Integer.toString(2131427450));

        final Intent intent = new Intent(RunGame.this, MainPage.class);

        myWebView = new WikiWebView(R.id.web_view, intent);
        myWebView.loadPage(startPage);

        steps = 0;

        text_start_page = (TextView)findViewById(R.id.start_page);

        text_end_page = (TextView)findViewById(R.id.end_page);
        text_steps = (TextView)findViewById(R.id.steps);

        text_start_page.setText(startPage.replaceAll("[_]", " "));
        text_end_page.setText(endPage.replaceAll("[_]", " "));

        backward_button=(Button)findViewById(R.id.backward_button);
        break_button=(Button)findViewById(R.id.break_button);
        forward_button=(Button)findViewById(R.id.forward_button);

        backward_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(myWebView.webView.canGoBack()){
                    myWebView.webView.goBack();
                    steps--;
                    text_steps.setText(Integer.toString(steps));
                }
            }
        });
        break_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                steps = 0;
                text_steps.setText(Integer.toString(steps));
                Log.d(message, "onClick() break_button ");
                startActivity(intent);
                finish();
            }
        });
        forward_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(myWebView.webView.canGoForward()){
                    myWebView.webView.goForward();
                    steps++;
                    text_steps.setText(Integer.toString(steps));
                }
            }
        });


    }

    public class WikiWebView{
        WebView webView;
        Intent myIntent;
        public WikiWebView(int webViewId, Intent intent){
            myIntent = intent;
            webView = (WebView) findViewById(webViewId);
            webView.setVisibility(webView.INVISIBLE);
            webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url){
                    if(url.contains(wikiUrl)){
                        steps++;
                        return false;
                    }
                    return true;
                }

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
                    if(url.contains("#/media/File")) {
                        steps++;
                    }else{
                        text_start_page.setText(view.getUrl().substring(webView.getUrl().lastIndexOf("/") + 1).replaceAll("[-+.^:,_]"," "));
                    }
                    if(view.getUrl().contains(endPage)){
                        Toast toast = Toast.makeText(getApplicationContext(), "You won", Toast.LENGTH_SHORT);
                        toast.show();
                        startActivity(myIntent);
                        finish();
                    }else{

                    }
                    text_steps.setText(Integer.toString(steps));
                    webView.setVisibility(webView.VISIBLE);
                }
            });
        }
        public void loadPage(String pageName){
            webView.loadUrl(wikiUrl + pageName);
        }
    }

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
