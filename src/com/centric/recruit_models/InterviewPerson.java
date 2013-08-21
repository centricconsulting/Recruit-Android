package com.centric.recruit_models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Mike Brooks
 * Date: 8/20/13
 * Time: 1:08 PM
 * To change this template use File | Settings | File Templates.
 */

public class InterviewPerson implements Serializable {
    @SerializedName("first_name")
    String firstName;

    @SerializedName("last_name")
    String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
