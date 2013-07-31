package com.centric.recruit_models;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Mike Brooks
 * Date: 7/23/13
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Resource {
    @SerializedName("_id")
    String id;

    @SerializedName("blog_url")
    String blogUrl;

    @SerializedName("cell_phone_number")
    String cellPhoneNumber;

    @SerializedName("created_at")
    Date createdDateTime;

    @SerializedName("current_employer")
    String currentEmployer;

    @SerializedName("date_available")
    Date dateAvailable;

    @SerializedName("email_address")
    String emailAddress;

    @SerializedName("employee_type")
    String employeeType;

    @SerializedName("first_name")
    String firstName;

    @SerializedName("home_phone_number")
    String homePhoneNumber;

    @SerializedName("last_name")
    String lastName;

    @SerializedName("linkedin_url")
    String linkedInUrl;

    @SerializedName("network")
    String network;

    @SerializedName("opportunity_ids")
    String[] opportunityIds;

    @SerializedName("profile_ids")
    String[] profileIds;

    @SerializedName("referrer")
    String referrer;

    @SerializedName("resume_content_type")
    String resumeContentType;

    @SerializedName("resume_file_name")
    String resumeFileName;

    @SerializedName("resume_file_size")
    String resumeFileSize;

    @SerializedName("resume_updated_at")
    Date resumeLastUpdated;

    @SerializedName("status")
    String status;

    @SerializedName("technology_ids")
    String[] technologyIds;

    @SerializedName("twitter_handle")
    String twitterHandle;

    @SerializedName("updated_at")
    Date lastUpdated;
}
