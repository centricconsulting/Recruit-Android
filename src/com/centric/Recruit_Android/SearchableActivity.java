package com.centric.Recruit_Android;

import android.app.Activity;
import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import com.centric.recruit_models.Resource;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.json.JSONArray;
import org.json.JSONObject;
import com.google.gson.Gson;

import com.centric.Recruit_Android.CentricBdClient;

/**
 * Created with IntelliJ IDEA.
 * User: Mike Brooks
 * Date: 7/24/13
 * Time: 1:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class SearchableActivity extends ListActivity {
    public static final String SESSION_TOKEN = "TOKEN_KEY";
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresults);

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            Bundle appData = intent.getBundleExtra(SearchManager.APP_DATA);

            String query = intent.getStringExtra(SearchManager.QUERY) ;
            String token = appData.getString(SESSION_TOKEN);

            doSearch(query, token);
        }
    }

    public void doSearch(String query, String sessionToken) {
        Resources res = getResources();
        String searchUrl = res.getString(R.string.search_url) + query + ".json";
        PersistentCookieStore cookieStore = new PersistentCookieStore(getApplicationContext());
        BasicClientCookie cookie = new BasicClientCookie(res.getString(R.string.session_token), sessionToken);
        cookie.setDomain("thawing-ridge-1647.herokuapp.com");
        cookieStore.addCookie(cookie);
        CentricBdClient.setCookieStore(cookieStore);
        CentricBdClient.get(searchUrl, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(JSONArray resourcesArray) {
                System.out.println(resourcesArray.toString());
                // Convert from JSONArray to Resources
                if (resourcesArray != null && resourcesArray.length() > 0) {
                    Gson gson = new Gson();
                    Resource[] resources = gson.fromJson(resourcesArray.toString(), Resource[].class);
                    //setListAdapter(new ArrayAdapter<Resource>(getApplicationContext(), android.R.layout.activity_list_item, resources));
                }
            }

            @Override
            public void onFailure(Throwable throwable, JSONArray jsonArray) {
                super.onFailure(throwable, jsonArray);
                System.out.println(throwable.toString());

            }
        });
    }
}