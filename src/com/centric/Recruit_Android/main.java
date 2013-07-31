package com.centric.Recruit_Android;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.*;

/**
 * Created with IntelliJ IDEA.
 * User: Mike Brooks
 * Date: 7/18/13
 * Time: 11:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class main extends Activity {
    private static final int LOGIN_WEB_VIEW = 1;
    private static final String TOKEN_KEY = "TOKEN_KEY";
    private String token = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);


        if (savedInstanceState == null) {
            Resources res = getResources();
            //webView.loadUrl(res.getString(R.string.google_auth_url));
            Intent intent = new Intent(getBaseContext(), LoginWebView.class);
            intent.putExtra("google_auth_url", res.getString(R.string.google_auth_url));
            startActivityForResult(intent, LOGIN_WEB_VIEW);
        }
        else {
            token = savedInstanceState.getString("TOKEN_KEY");
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(TOKEN_KEY, token);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LOGIN_WEB_VIEW) {
            if (resultCode == RESULT_OK) {
                // Set cookie as string
                token = data.getStringExtra("token");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.search).setVisible(token != null);
        return true;
    }

    @Override  public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Start the WebViewActivity to handle the authentication.
            case R.id.login:
//                Intent intent = new Intent(this, LoginWebView.class);
//                Resources res = getResources();
//                intent.setData(Uri.parse(res.getString(R.string.google_auth_url)));
//                startActivityForResult(intent, 0);
                Resources res = getResources();
                WebView webView = (WebView) findViewById(R.id.loginWebView);
                webView.loadUrl(res.getString(R.string.google_auth_url));
                return true;
            // Exit.
            case R.id.exit:
                finish();
                return true;
            case R.id.search:
                onSearchRequested();
                return true;
            }
        return super.onOptionsItemSelected(item);
    }


}