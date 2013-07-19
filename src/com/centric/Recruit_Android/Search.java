package com.centric.Recruit_Android;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import com.centric.web.JSONParser;

/**
 * Created with IntelliJ IDEA.
 * User: Mike Brooks
 * Date: 7/17/13
 * Time: 1:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class search extends Activity implements TextWatcher {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.search);
        String item[]={
                "Shawn Wallace", "Gwenn Denorme", "Architect", "Developer",
                ".Net", "Ruby", "Java", "Mike Brooks"
        };

        AutoCompleteTextView view = (AutoCompleteTextView)findViewById(R.id.search_autoCompleteTextView);
        view.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, item));
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void afterTextChanged(Editable s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}