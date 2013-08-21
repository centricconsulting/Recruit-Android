package com.centric.Recruit_Android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.webkit.*;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.centric.recruit_models.Interview;
import com.centric.recruit_models.Resource;
import com.centric.recruit_models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

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
    private static final String USER_KEY = "USER_KEY";
    private static final String INTERVIEW_KEY = "INTERVIEW_KEY";
    private String token = null;
    private User user = null;
    private String InterviewsJSON = null;
    private List<Interview> InterviewList = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);


        if (savedInstanceState == null) {
            Resources res = getResources();
            //webView.loadUrl(res.getString(R.string.google_auth_url));
            Intent intent = new Intent(getBaseContext(), LoginWebView.class);
            intent.putExtra(getString(R.string.auth_url_key), res.getString(R.string.google_auth_url));
            startActivityForResult(intent, LOGIN_WEB_VIEW);
        }
        else {
            token = savedInstanceState.getString(TOKEN_KEY);
            user = (User)savedInstanceState.getSerializable(USER_KEY);
            InterviewList = parseToInterviewList(savedInstanceState.getString(INTERVIEW_KEY));
            bindUserToView(user);
            bindInterviewsListToView(InterviewList);
        }

    }

    private void bindUserToView(User user) {
        TextView tvName = (TextView)findViewById(R.id.userName);
        tvName.setText("Welcome " + user.getFirstName() + " " + user.getLastName());
    }

    private void bindInterviewsListToView(List<Interview> list) {
        ListView view = (ListView)findViewById(R.id.thisWeeksInterviewsView);
        InterviewListAdapter adapter = new InterviewListAdapter(getApplicationContext(), R.layout.interviewlistrow, list);
        view.setAdapter(adapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(TOKEN_KEY, token);
        outState.putSerializable(USER_KEY, user);
        outState.putString(INTERVIEW_KEY, InterviewsJSON);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LOGIN_WEB_VIEW) {
            if (resultCode == RESULT_OK) {
                // Set token as string
                token = data.getStringExtra("token");

                Resources res = getResources();
                String findUserUrl = res.getString(R.string.find_user_url) + token + ".json?mobile=1";
                CentricBdClient.addHeader(getString(R.string.AuthHeaderKey), getString(R.string.AuthTokenPrefix) + token);
                CentricBdClient.get(findUserUrl, null, UserResponseHandler);

                String thisWeeksInterviewUrl = res.getString(R.string.this_weeks_interviews_url) + ".json?mobile=1";
                CentricBdClient.get(thisWeeksInterviewUrl, null, ThisWeeksInterviewsResponseHandler);
            }
        }
    }

    private JsonHttpResponseHandler ThisWeeksInterviewsResponseHandler =  new JsonHttpResponseHandler() {
        @Override
        public void onSuccess(JSONArray interviewsJSON) {
            System.out.println(interviewsJSON.toString());
            // Convert from JSONArray to Resources
            if (interviewsJSON != null && interviewsJSON.length() > 0) {
                Gson gson = new Gson();
                InterviewsJSON = interviewsJSON.toString();
                InterviewList = parseToInterviewList(InterviewsJSON);
                bindInterviewsListToView(InterviewList);
            }
        }

        @Override
        public void onFailure(Throwable throwable, JSONArray jsonArray) {
            super.onFailure(throwable, jsonArray);
            System.out.println(throwable.toString());

        }
    };

    public static List<Interview> parseToInterviewList(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<List<Interview>>(){}.getType());
    }

    private JsonHttpResponseHandler UserResponseHandler =  new JsonHttpResponseHandler() {
        @Override
        public void onSuccess(JSONArray userJSON) {
            System.out.println(userJSON.toString());
            // Convert from JSONArray to Resources
            if (userJSON != null && userJSON.length() > 0) {
                try {
                    Gson gson = new Gson();
                    String UserJSON = userJSON.getJSONObject(0).toString();
                    user = gson.fromJson(UserJSON, User.class);
                    bindUserToView(user);
                }
                catch(JSONException ex) {
                    Log.e("UserJSON Exception", ex.getMessage(), ex);
                }
            }
        }

        @Override
        public void onFailure(Throwable throwable, JSONArray jsonArray) {
            super.onFailure(throwable, jsonArray);
            System.out.println(throwable.toString());

        }
    };

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

    @Override
    public boolean onSearchRequested() {
        Bundle appData = new Bundle();
        appData.putString(SearchableActivity.SESSION_TOKEN, token);
        startSearch(null, false, appData, false);
        return true;
    }

    public class InterviewListAdapter extends ArrayAdapter<Interview> {
        public InterviewListAdapter(Context context, int textViewResourceId) {
            super(context, textViewResourceId);
            // TODO Auto-generated constructor stub
        }

        private List<Interview> items;

        public InterviewListAdapter(Context context, int resource, List<Interview> items) {

            super(context, resource, items);

            this.items = items;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View v = convertView;

            if (v == null) {

                LayoutInflater vi;
                vi = LayoutInflater.from(getContext());
                v = vi.inflate(R.layout.interviewlistrow, null);

            }

            Interview interview = items.get(position);

            if (interview != null) {

                TextView tvDateTime = (TextView) v.findViewById(R.id.datetime);
                TextView tvResourceName = (TextView)v.findViewById(R.id.resourceName);
                TextView tvUserName = (TextView)v.findViewById(R.id.userName);
                TextView tvLocation = (TextView)v.findViewById(R.id.location);

                if (tvDateTime != null) {
                    tvDateTime.setText(interview.getInterviewDate().toString());
                }

                if (tvResourceName != null) {
                    tvResourceName.setText(interview.getResource().getFullName());
                }

                if (tvUserName != null) {
                    tvUserName.setText(interview.getUser().getFullName());
                }

                if (tvLocation != null) {
                    tvLocation.setText(interview.getLocation());
                }
            }

            return v;
        }
    }
}