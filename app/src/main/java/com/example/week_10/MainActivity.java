package com.example.week_10;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    WebView web;
    EditText webPage;
    Websites websites = new Websites();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("file:///android_asset/index.html");
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void executeJavascript(View v){
        web.evaluateJavascript("javascript:shoutOut()", null);
    }

    public void load(View v){
        webPage = (EditText)findViewById(R.id.editText);
        String site = "http://" + webPage.getText().toString();
        web.loadUrl(site);
        websites.addSite(site);
    }

    public void loadIndex(View v){
        web.loadUrl("file:///android_asset/index.html");
    }

    public void next(View v){
        int i = websites.getIndex();
        System.out.println(i);
        if(i>=websites.sites.size()){
            i = websites.sites.size()-1;
        } else if (i == 0){
            i = 1;
        }
        ListIterator liter = websites.sites.listIterator(i);
        if(i<websites.sites.size()-1){
            websites.setIndex(i+1);
        }
        Site snext = null;
        snext = (Site) liter.next();
        web.loadUrl(snext.getSite());
    }

    public void last(View v){
        int i = websites.getIndex();
        System.out.println(i);
        if(i<=1){
            i = 1;
        }
        ListIterator liter = websites.sites.listIterator(i);
        if(i>0){
            websites.setIndex(i-1);
        }
        Site sprevious = null;
        sprevious = (Site) liter.previous();
        web.loadUrl(sprevious.getSite());
    }
}
