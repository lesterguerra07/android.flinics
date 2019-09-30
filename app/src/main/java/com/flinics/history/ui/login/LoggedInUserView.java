package com.flinics.history.ui.login;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private String mDisplayName;
    private String mToken;
    private String mUserId;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(String displayName, String token, String userId) {
        mDisplayName = displayName;
        mToken = token;
        mUserId = userId;
    }

    String getDisplayName() {
        return mDisplayName;
    }

    public String getToken() {
        return mToken;
    }

    public String getUserId(){ return mUserId; }
}
