package com.flinics.history.ui.login;

import android.app.Application;
import android.content.Context;
import android.util.Patterns;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.flinics.history.R;
import com.flinics.history.Volley;
import com.flinics.history.data.LoginRepository;
import com.flinics.history.data.Result;
import com.flinics.history.data.model.LoggedInUser;
import com.flinics.history.error.Error;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class LoginViewModel extends AndroidViewModel {

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private LoginJsonLiveData loginResult;
    private LoginRepository loginRepository;
    private String tag = this.getClass().getSimpleName();

    LoginViewModel(@NonNull Application application, LoginRepository loginRepository) {
        super(application);
        if (loginResult == null) loginResult = new LoginJsonLiveData(application);

    }

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String username, String password) {

        loginResult.login(username, password);
        // can be launched in a separate asynchronous job
        //Volley.postData(context, null, successListener, errorListener, "1", "auth", "");

        /*Result<LoggedInUser> result = loginRepository.login(username, password, context);

        if (result instanceof Result.Success) {
            LoggedInUser data = ((Result.Success<LoggedInUser>) result).getData();
            loginResult.setValue(new LoginResult(new LoggedInUserView(data.getName())));
        } else {
            loginResult.setValue(new LoginResult(R.string.login_failed));
        }*/
    }

    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    // A placeholder username validation check
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return !username.trim().isEmpty();
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }

    public class LoginJsonLiveData extends MutableLiveData{
        private final Context context;
        private int page=1;

        public LoginJsonLiveData(Context context){
            this.context=context;
        }

        public void login(String user, String password) {
            HashMap<String, String> body = new HashMap<>();
            body.put("email", user);
            body.put("password", password);
            Volley.postData(context, new JSONObject(body), successListener, errorListener, "1", "auth", "", "");
        }

        private Response.Listener<JSONObject> successListener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // Log.d(tag, response.toString());
                String responseID;
                String responseName;
                String responseEmail;
                String responseEntity;
                String responseToken;
                Result<LoggedInUser> result = null;
                try {
                    responseID = response.getString("id");
                    responseName = response.getString("name");
                    responseEmail = response.getString("email");
                    responseEntity = response.getString("entity");
                    responseToken = response.getString("accessToken");

                    LoggedInUser user =
                            new LoggedInUser(
                                    responseID
                                    , responseName
                                    , responseEmail
                                    , responseEntity
                                    , responseToken
                            );
                    result = new Result.Success<>(user);
                } catch (JSONException exception) {
                    // Log.e(tag, "Failed to deserialize auth response", exception);
                    result = new Result.Error(new Exception("Failed to deserialize auth response", exception));
                }catch (Exception exception){
                    // Log.e(tag, "Failed to deserialize args", exception);
                    result = new Result.Error(new Exception("Failed to deserialize args", exception));
                }

                if (result instanceof Result.Success) {
                    LoggedInUser data = ((Result.Success<LoggedInUser>) result).getData();
                    loginResult.setValue(new LoginResult(new LoggedInUserView(data.getName(), data.getAccessToken(), data.get_id())));
                } else {
                    loginResult.setValue(new LoginResult(R.string.login_failed));
                }
            }
        };

        private Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String strJsonResponse;
                JSONObject jsonResponse;
                JSONArray errors = null;
                try {
                    strJsonResponse = new String(error.networkResponse.data, "UTF-8");
                    jsonResponse = new JSONObject(strJsonResponse);
                    errors = jsonResponse.getJSONArray("errors");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if(errors == null){
                    loginResult.setValue(new LoginResult(R.string.login_failed));
                    return;
                }

                if(errors.length() >= 1){
                    try {
                        // Log.e(tag, error.toString());
                        loginResult.setValue(new LoginResult(Error.getErrorResource(errors.getString(0))));
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                loginResult.setValue(new LoginResult(R.string.login_failed));
            }
        };
    }
}
