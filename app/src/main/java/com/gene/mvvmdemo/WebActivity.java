package com.gene.mvvmdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {
    WebView web;


    public static void enter(Context context){
        Intent i = new Intent(context,WebActivity.class);
        context.startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        web = (WebView)findViewById(R.id.web);
        initWebViewSetting();
        web.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        web.loadUrl("http://www.jin10.com/example/jin10.com.html");
    }

    private void initWebViewSetting() {
        WebSettings settings = web.getSettings();
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        settings.setDomStorageEnabled(true);
        settings.setAppCachePath(getCacheDir().getPath());
        settings.setAppCacheEnabled(true);
        settings.setDatabaseEnabled(true);

        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAllowFileAccess(true);
        settings.setGeolocationEnabled(true);
    }
}
