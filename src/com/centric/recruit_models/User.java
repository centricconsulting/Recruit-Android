package com.centric.recruit_models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Mike Brooks
 * Date: 8/19/13
 * Time: 12:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class User implements Serializable {
    @SerializedName("_id")
    String id;

    @SerializedName("uid")
    String uid;

    @SerializedName("email")
    String emailAddress;

    @SerializedName("first_name")
    String firstName;

    @SerializedName("last_name")
    String lastName;

    @SerializedName("role")
    String role;

    @SerializedName("provider")
    String provider;

    @SerializedName("password_hash")
    String passwordHash;

    @SerializedName("password_salt")
    String passwordSalt;

    @SerializedName("access_token")
    String accessToken;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
