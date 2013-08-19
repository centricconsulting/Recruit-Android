package com.centric.Recruit_Android;
import android.content.Context;
import android.content.res.Resources;
import com.loopj.android.http.*;
import org.apache.http.impl.cookie.BasicClientCookie;

/**
 * Created with IntelliJ IDEA.
 * User: Mike Brooks
 * Date: 8/3/13
 * Time: 11:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class CentricBdClient {
    private static AsyncHttpClient client = new AsyncHttpClient();
    public static void addHeader(String name, String value) {
        client.addHeader(name, value);
    }

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(url, params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(url, params, responseHandler);
    }

    public static void setCookieStore(PersistentCookieStore cookieStore) {
        client.setCookieStore(cookieStore);
    }

    public static void setApiToken(Context context, String token) {
        PersistentCookieStore cookieStore = new PersistentCookieStore(context);
        BasicClientCookie cookie = new BasicClientCookie(context.getString(R.string.api_token), token);
        cookie.setDomain(context.getString(R.string.api_domain));
        cookieStore.addCookie(cookie);
        client.setCookieStore(cookieStore);
    }
}
