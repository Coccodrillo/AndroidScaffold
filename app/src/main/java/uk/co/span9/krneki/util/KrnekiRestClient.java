package uk.co.span9.krneki.util;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class KrnekiRestClient {

    private static final String BASE_URL = "http://google.com";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, String token, Context context, AsyncHttpResponseHandler responseHandler) {
        if (isRequestReady(context, token)) client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, String token, Context context, AsyncHttpResponseHandler responseHandler) {
        if (isRequestReady(context, token)) client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void put(String url, RequestParams params, String token, Context context, AsyncHttpResponseHandler responseHandler) {
        if (isRequestReady(context, token)) client.put(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void delete(String url, String token, Context context, AsyncHttpResponseHandler responseHandler) {
        if (isRequestReady(context, token)) client.delete(getAbsoluteUrl(url), responseHandler);
    }

    private static boolean isRequestReady(Context context, String token) {
        boolean isReady = isNetworkAvailable(context);
        if (!isReady) {
            Toast.makeText(context, "No network Connection yadda yadda", Toast.LENGTH_LONG).show();
        }
        return isReady;
    }

    private static String getAbsoluteUrl(String url) {
        return BASE_URL + "/"+url;
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
