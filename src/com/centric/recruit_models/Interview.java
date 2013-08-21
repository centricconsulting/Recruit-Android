package com.centric.recruit_models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Mike Brooks
 * Date: 8/20/13
 * Time: 1:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Interview implements Serializable {
    @SerializedName("resource_id")
    String resourceId;

    @SerializedName("updated_at")
    Date updateDate;

    @SerializedName("_id")
    String id;

    @SerializedName("location")
    String location;

    @SerializedName("when")
    Date interviewDate;

    @SerializedName("created_at")
    Date createDate;

    @SerializedName("user_id")
    String userId;

    @SerializedName("type")
    String type;

    @SerializedName("resource")
    InterviewPerson resource;

    @SerializedName("user")
    InterviewPerson user;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public InterviewPerson getResource() {
        return resource;
    }

    public void setResource(InterviewPerson interviewPerson) {
        this.resource = interviewPerson;
    }

    public InterviewPerson getUser() {
        return user;
    }

    public void setUser(InterviewPerson user) {
        this.user = user;
    }
}

