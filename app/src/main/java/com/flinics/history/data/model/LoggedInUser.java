package com.flinics.history.data.model;

import androidx.annotation.Nullable;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String _id;
    private String name;
    private String email;
    private String entity;
    private String accessToken;

    public LoggedInUser(String userId, String name, String email, String entity, String accessToken) {
        this._id = userId;
        this.name = name;
        this.email = email;
        this.entity = entity;
        this.accessToken = accessToken;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
