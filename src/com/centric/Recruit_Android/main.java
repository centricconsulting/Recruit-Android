package com.centric.Recruit_Android;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created with IntelliJ IDEA.
 * User: Mike Brooks
 * Date: 7/18/13
 * Time: 11:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class main extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override  public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Start the WebViewActivity to handle the authentication.
            case R.id.login:
                Intent intent = new Intent(this, LoginWebView.class);
                Resources res = getResources();
                intent.setData(Uri.parse(res.getString(R.string.google_auth_url)));
                startActivityForResult(intent, 0);
                return true;
            // Exit.
            case R.id.exit:
                finish();
                return true;
            }
        return super.onOptionsItemSelected(item);
    }
}