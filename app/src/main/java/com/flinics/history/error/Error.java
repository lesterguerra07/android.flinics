package com.flinics.history.error;

import android.content.Context;
import android.content.ContextWrapper;

import com.flinics.history.R;

public class Error {
    public static int getErrorResource(String errorCode){
        switch (errorCode){
            case "000":
                return R.string.internal_error_server;
            case "001":
                return R.string.need_pass_refreshToken_field;
            case "002":
                return R.string.invalid_refreshToken;
            case "003":
                return R.string.missing_email;
            case "004":
                return R.string.missing_password;
            case "005":
                return R.string.invalid_email_or_password;
            case "006":
                return R.string.missing_email_password;
            default:
                return R.string.internal_error_server;
        }

    }
}
