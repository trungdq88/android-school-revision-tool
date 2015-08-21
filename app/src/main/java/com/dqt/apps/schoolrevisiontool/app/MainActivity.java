package com.dqt.apps.schoolrevisiontool.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.File;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView wbvMain = (WebView) findViewById(R.id.wbvMain);

        wbvMain.setWebChromeClient(new WebChromeClient());
        wbvMain.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url != null && (url.startsWith("https://github.com") || url.startsWith("http://trungdq88.github.io/school-revision-tool/data/"))) {
                    view.getContext().startActivity(
                            new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    return true;
                } else {
                    return false;
                }
            }
        });
        WebSettings webSettings = wbvMain.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wbvMain.getSettings().setLoadsImagesAutomatically(true);
        wbvMain.clearCache(true);
        wbvMain.getSettings().setDomStorageEnabled(true);
        wbvMain.getSettings().setDatabaseEnabled(true);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            wbvMain.getSettings().setDatabasePath("/data/data/" + wbvMain.getContext().getPackageName() + "/databases/");
        }
        wbvMain.loadUrl("http://trungdq88.github.io/school-revision-tool");
    }


}
