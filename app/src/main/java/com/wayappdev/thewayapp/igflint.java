package com.wayappdev.thewayapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class igflint extends Activity {

    String ShowOrHideWebViewInitialUse= "show";
    private WebView mWebView;
    private ProgressBar spinner;
    private View background;
    private ImageView centerlogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_site);

        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        mWebView.setWebViewClient(new CustomWebViewClient());
        background = (View) findViewById(R.id.Loading);
        centerlogo= (ImageView) findViewById(R.id.Loading2);



        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // REMOTE RESOURCE
        mWebView.loadUrl("https://www.instagram.com/wayprogram");
        mWebView.setWebViewClient(new CustomWebViewClient());

        // LOCAL RESOURCE
        // mWebView.loadUrl("file:///android_asset/index.html");
    }
    private class CustomWebViewClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView mWebView, String url, Bitmap favicon) {
            if (ShowOrHideWebViewInitialUse.equals("show")) {

                mWebView.setVisibility(mWebView.INVISIBLE);
            }
        }

        @Override
        public void onPageFinished(WebView view, String url) {

            ShowOrHideWebViewInitialUse = "hide";
            spinner.setVisibility(View.GONE);
            background.setVisibility(background.GONE);
            centerlogo.setVisibility(centerlogo.GONE);

            view.setVisibility(mWebView.VISIBLE);
            super.onPageFinished(view, url);

        }
    }

    // Prevent the back-button from closing the app
    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }


    }

}