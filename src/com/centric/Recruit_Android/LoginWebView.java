package com.centric.Recruit_Android;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Window;
import android.webkit.*;

/**
 * Created with IntelliJ IDEA.
 * User: Mike Brooks
 * Date: 7/18/13
 * Time: 11:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginWebView extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Allow the title bar to show loading process
        requestWindowFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.login);

        Intent intent = getIntent();
        String url = intent.getStringExtra("google_auth_url");

        WebView webView = (WebView) findViewById(R.id.loginWebView);
        // enable Javascript
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient() {
            // Show loading progress
            @Override
            public void onProgressChanged(WebView view, int progress) {
                setProgress(progress * 100);
            }
        });

        webView.setWebViewClient(new LoginWebViewClient());

        webView.loadUrl(url);
    }

    private class LoginWebViewClient extends WebViewClient {
        // When start to load page, show url in activity's title bar
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            setTitle(url);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            CookieSyncManager.getInstance().sync();
            // get the cookie
            String cookie = CookieManager.getInstance().getCookie(url);
            if (cookie == null) {
                return;
            }

            String[] pairs = cookie.split(";");
            for (int i = 0; i < pairs.length; i++) {
                String[] parts = pairs[i].split("=", 2);
                Resources res = getResources();
                // if token i found, return it to the calling activity
                if (parts.length == 2 && parts[0].trim().equalsIgnoreCase(res.getString(R.string.api_token))) {
                    Intent result = new Intent();
                    result.putExtra("token", parts[1]);
                    setResult(RESULT_OK, result);
                    finish();
                }
            }
        }

    }
}