package com.flinics.history;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;
import static com.android.volley.Request.Method.GET;
import static com.android.volley.Request.Method.POST;
import static com.flinics.history.VolleyQueueConfig.getRequestQueue;

public class Volley {

    public static void getData(final Context context,
                               final Listener<JSONObject> successListener,
                               final ErrorListener errorListener,
                               final String apiVersion,
                               final String apiMethod,
                               final String apiParam) {
        final URI uri = URI.create(Resources.getSystem().getString(R.string.api_url, apiVersion, apiMethod, apiParam));

        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(GET,
                uri.toString(),
                null,
                successListener,
                errorListener);

        RetryPolicy retryPolicy = new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        );

        jsonObjectRequest.setRetryPolicy(retryPolicy);

        final RequestQueue queue = getRequestQueue(context);
        queue.add(jsonObjectRequest);
    }

    public static void postData(final Context context,
                                final HashMap<String, String> bodyRequestMap,
                                final Listener<JSONObject> successListener,
                                final ErrorListener errorListener,
                                final String apiVersion,
                                final String apiMethod,
                                final String apiParam) {
        final JSONObject bodyRequestJsonObject = new JSONObject(bodyRequestMap);
        Log.d("REST", String.format("https://api.flinics.brickapps.com/v%1$s/%2$s/%3$s", apiVersion, apiMethod, apiParam));
        final URI uri = URI.create(String.format("https://api.flinics.brickapps.com/v%1$s/%2$s/%3$s", apiVersion, apiMethod, apiParam));

        final CustomJsonObjectRequest jsonObjectRequest = new CustomJsonObjectRequest(POST,
                uri.toString(),
                bodyRequestJsonObject,
                successListener,
                errorListener);

        RetryPolicy retryPolicy = new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        );

        jsonObjectRequest.setRetryPolicy(retryPolicy);

        Iterator it = null;
        try {
            it = jsonObjectRequest.getHeaders().entrySet().iterator();
        } catch (AuthFailureError authFailureError) {
            Log.d("Headers", authFailureError.getMessage());
        }

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Log.d("Headers", pair.getKey() + ":" + pair.getValue());
        }


        final RequestQueue queue = getRequestQueue(context);
        queue.add(jsonObjectRequest);
    }

    public static class CustomJsonObjectRequest  extends JsonObjectRequest
    {
        public CustomJsonObjectRequest(int method, String url, JSONObject jsonRequest, Response.Listener listener, Response.ErrorListener errorListener)
        {
            super(method, url, jsonRequest, listener, errorListener);
        }


        /*@Override
        public Map getHeaders() throws AuthFailureError {
            Map headers = new HashMap();
            headers.put("Content-Type", "application/json");
            return headers;
        }*/

        @Override
        public Map getHeaders() throws AuthFailureError {
            Map<String, String> header = new HashMap<>();
            header.put("Content-Type","application/json");
            return header;
        }

        @Override
        public String getBodyContentType() {
            return "application/json";
        }

    }
}
