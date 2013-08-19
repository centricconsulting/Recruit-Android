package com.centric.Recruit_Android;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.centric.recruit_models.Resource;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Mike Brooks
 * Date: 8/15/13
 * Time: 12:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class ViewResource extends Activity {
    private Resource resource = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.viewresource);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            resource = (Resource)intent.getSerializableExtra(getString(R.string.viewResource));
        }
        else {
            resource = (Resource)savedInstanceState.getSerializable("viewResource");
        }
        bindResourceToView(resource);

        if (resource.getCellPhoneNumber().length() > 0) {
            TextView tvPhone = (TextView)findViewById(R.id.phone);
            tvPhone.setOnClickListener(PhoneNumberOnItemClickListener);
        }

        if (resource.getEmailAddress().length() > 0) {
            TextView tvEmail = (TextView)findViewById(R.id.email);
            tvEmail.setOnClickListener(EmailOnItemClickListener);
        }

        if (resource.getResumeUrl().length() > 0) {
            Button button = (Button)findViewById(R.id.viewResumeButton);
            button.setOnClickListener(ViewResumeButtonOnClickListener);
        }
    }

    private View.OnClickListener ViewResumeButtonOnClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            String url = resource.getResumeUrl();
            Uri path = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, path);
            //intent.setType(resource.getResumeContentType());
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            try {
                startActivity(intent);
            }
            catch (ActivityNotFoundException e) {
                Toast.makeText(ViewResource.this,
                        "No Application Available to View Resume (" + resource.getResumeContentType() + ")",
                        Toast.LENGTH_SHORT).show();
            }
        }
    };

    private View.OnClickListener EmailOnItemClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            TextView tv = (TextView)v;
            String emailAddress = tv.getText().toString();
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{ emailAddress });
            startActivity(Intent.createChooser(i, "Send email"));
        }
    };

    private View.OnClickListener PhoneNumberOnItemClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            TextView tv = (TextView)v;
            String phoneNumber = tv.getText().toString();
            String uri = "tel:" + phoneNumber.trim() ;
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(uri));
            startActivity(intent);
         }
    };

    @Override
    protected void onSaveInstanceState(Bundle state) {
        state.putSerializable("viewResource", resource);
        super.onSaveInstanceState(state);
    }

    private void bindResourceToView(Resource resource) {
        // Name
        TextView tvName = (TextView)findViewById(R.id.name);
        tvName.setText(resource.getFullName());

        TextView tvStatus = (TextView)findViewById(R.id.status);
        tvStatus.setText(resource.getStatus());

        TextView tvPhone = (TextView)findViewById(R.id.phone);
        String phoneNumber = resource.getCellPhoneNumber();
        SpannableString phoneNumberContent = new SpannableString(phoneNumber);
        phoneNumberContent.setSpan(new UnderlineSpan(), 0, phoneNumber.length(), 0);
        tvPhone.setText(phoneNumberContent);

        TextView tvEmail = (TextView)findViewById(R.id.email);
        String emailAddress = resource.getEmailAddress();
        SpannableString emailAddressContent = new SpannableString(emailAddress);
        emailAddressContent.setSpan(new UnderlineSpan(), 0, emailAddress.length(), 0);
        tvEmail.setText(emailAddressContent);
    }
}