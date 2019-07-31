package com.flinics.history;

import android.content.Context;
import android.content.res.Resources;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.net.URI;
import java.util.HashMap;

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

        final URI uri = URI.create(Resources.getSystem().getString(R.string.api_url, apiVersion, apiMethod, apiParam));

        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(POST,
                uri.toString(),
                bodyRequestJsonObject,
                successListener,
                errorListener);

        final RequestQueue queue = getRequestQueue(context);
        queue.add(jsonObjectRequest);
    }
}
