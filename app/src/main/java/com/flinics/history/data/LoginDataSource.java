package com.flinics.history.data;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.flinics.history.data.model.LoggedInUser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    private String classTag = "LoginDataSource";

    public Result<LoggedInUser> login(String username, String password, Context context) {

        try {
            // TODO: handle loggedInUser authentication
            // Log.d("REST", "Login...");
            JSONObject body = new JSONObject();
            body.put("email", username);
            body.put("password", password);
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe", "", "", "");
            return new Result.Success<>(fakeUser);
        } catch (JSONException e) {
            return new Result.Error(new Exception("Error logging in", e));
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }

    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            // Log.e(classTag, error.toString());
        }
    };
}
