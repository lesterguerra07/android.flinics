package com.flinics.history.ui.login;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private String mDisplayName;
    private String mToken;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(String displayName, String token) {
        mDisplayName = displayName;
        mToken = token;
    }

    String getDisplayName() {
        return mDisplayName;
    }

    public String getToken() {
        return mToken;
    }
}
