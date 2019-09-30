package com.flinics.history;

import android.content.Context;

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

import static com.android.volley.Request.Method.DELETE;
import static com.android.volley.Request.Method.GET;
import static com.android.volley.Request.Method.POST;
import static com.android.volley.Request.Method.PUT;
import static com.flinics.history.VolleyQueueConfig.getRequestQueue;

public class Volley {

    public static void getData(final Context context,
                                final JSONObject bodyRequestJsonObject,
                                final Listener<JSONObject> successListener,
                                final ErrorListener errorListener,
                                final String apiVersion,
                                final String apiMethod,
                                final String apiParam,
                                final String token
    ) {

        // Log.d("REST", String.format("https://api.flinics.brickapps.com/v%1$s/%2$s/%3$s", apiVersion, apiMethod, apiParam));
        final URI uri = URI.create(String.format("https://api.flinics.brickapps.com/v%1$s/%2$s/%3$s", apiVersion, apiMethod, apiParam));

        final CustomJsonObjectRequest jsonObjectRequest = new CustomJsonObjectRequest(GET,
                uri.toString(),
                bodyRequestJsonObject,
                successListener,
                errorListener,
                token);

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
            // Log.d("Headers", authFailureError.getMessage());
        }

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            // Log.d("Headers", pair.getKey() + ":" + pair.getValue());
        }


        final RequestQueue queue = getRequestQueue(context);
        queue.add(jsonObjectRequest);
    }

    public static void postData(final Context context,
                                final JSONObject bodyRequestJsonObject,
                                final Listener<JSONObject> successListener,
                                final ErrorListener errorListener,
                                final String apiVersion,
                                final String apiMethod,
                                final String apiParam,
                                final String token
                                ) {

        // Log.d("REST", String.format("https://api.flinics.brickapps.com/v%1$s/%2$s/%3$s", apiVersion, apiMethod, apiParam));
        final URI uri = URI.create(String.format("https://api.flinics.brickapps.com/v%1$s/%2$s/%3$s", apiVersion, apiMethod, apiParam));

        final CustomJsonObjectRequest jsonObjectRequest = new CustomJsonObjectRequest(POST,
                uri.toString(),
                bodyRequestJsonObject,
                successListener,
                errorListener,
                token);

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
            // Log.d("Headers", authFailureError.getMessage());
        }

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            // Log.d("Headers", pair.getKey() + ":" + pair.getValue());
        }


        final RequestQueue queue = getRequestQueue(context);
        queue.add(jsonObjectRequest);
    }

    public static void deleteData(final Context context,
                                final JSONObject bodyRequestJsonObject,
                                final Listener<JSONObject> successListener,
                                final ErrorListener errorListener,
                                final String apiVersion,
                                final String apiMethod,
                                final String apiParam,
                                final String token
    ) {

        // Log.d("REST", String.format("https://api.flinics.brickapps.com/v%1$s/%2$s/%3$s", apiVersion, apiMethod, apiParam));
        final URI uri = URI.create(String.format("https://api.flinics.brickapps.com/v%1$s/%2$s/%3$s", apiVersion, apiMethod, apiParam));

        final CustomJsonObjectRequest jsonObjectRequest = new CustomJsonObjectRequest(DELETE,
                uri.toString(),
                bodyRequestJsonObject,
                successListener,
                errorListener,
                token);

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
            // Log.d("Headers", authFailureError.getMessage());
        }

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            // Log.d("Headers", pair.getKey() + ":" + pair.getValue());
        }


        final RequestQueue queue = getRequestQueue(context);
        queue.add(jsonObjectRequest);
    }

    public static void putData(final Context context,
                               final JSONObject bodyRequestJsonObject,
                               final Listener<JSONObject> successListener,
                               final ErrorListener errorListener,
                               final String apiVersion,
                               final String apiMethod,
                               final String apiParam,
                               final String token
    ) {

        // Log.d("REST", String.format("https://api.flinics.brickapps.com/v%1$s/%2$s/%3$s", apiVersion, apiMethod, apiParam));
        final URI uri = URI.create(String.format("https://api.flinics.brickapps.com/v%1$s/%2$s/%3$s", apiVersion, apiMethod, apiParam));

        final CustomJsonObjectRequest jsonObjectRequest = new CustomJsonObjectRequest(PUT,
                uri.toString(),
                bodyRequestJsonObject,
                successListener,
                errorListener,
                token);

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
            // Log.d("Headers", authFailureError.getMessage());
        }

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            // Log.d("Headers", pair.getKey() + ":" + pair.getValue());
        }


        final RequestQueue queue = getRequestQueue(context);
        queue.add(jsonObjectRequest);
    }

    public static class CustomJsonObjectRequest  extends JsonObjectRequest
    {
        private String _accessToken;
        public CustomJsonObjectRequest(int method, String url, JSONObject jsonRequest, Response.Listener listener, Response.ErrorListener errorListener, String accessToken)
        {
            super(method, url, jsonRequest, listener, errorListener);
            _accessToken = accessToken;
        }

        @Override
        public Map getHeaders() throws AuthFailureError {
            Map<String, String> header = new HashMap<>();
            header.put("Content-Type","application/json");
            if(_accessToken != null && _accessToken != "")
                header.put("authorization", "Bearer " + _accessToken);
            return header;
        }

        @Override
        public String getBodyContentType() {
            return "application/json";
        }

    }
}
