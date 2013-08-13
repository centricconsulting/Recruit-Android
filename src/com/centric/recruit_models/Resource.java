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

    @SerializedName("resume_url")
    String resumeUrl;

    public String getId() {
        return id;
    }

    public void setId(String _id) {
        id = _id;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String[] getTechnologyIds() {
        return technologyIds;
    }

    public void setTechnologyIds(String[] technologyIds) {
        this.technologyIds = technologyIds;
    }

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getResumeLastUpdated() {
        return resumeLastUpdated;
    }

    public void setResumeLastUpdated(Date resumeLastUpdated) {
        this.resumeLastUpdated = resumeLastUpdated;
    }

    public String getResumeFileSize() {
        return resumeFileSize;
    }

    public void setResumeFileSize(String resumeFileSize) {
        this.resumeFileSize = resumeFileSize;
    }

    public String getResumeFileName() {
        return resumeFileName;
    }

    public void setResumeFileName(String resumeFileName) {
        this.resumeFileName = resumeFileName;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getResumeContentType() {
        return resumeContentType;
    }

    public void setResumeContentType(String resumeContentType) {
        this.resumeContentType = resumeContentType;
    }

    public String[] getOpportunityIds() {
        return opportunityIds;
    }

    public void setOpportunityIds(String[] opportunityIds) {
        this.opportunityIds = opportunityIds;
    }

    public String[] getProfileIds() {
        return profileIds;
    }

    public void setProfileIds(String[] profileIds) {
        this.profileIds = profileIds;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getLinkedInUrl() {
        return linkedInUrl;
    }

    public void setLinkedInUrl(String linkedInUrl) {
        this.linkedInUrl = linkedInUrl;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getDateAvailable() {
        return dateAvailable;
    }

    public void setDateAvailable(Date dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    public String getCurrentEmployer() {
        return currentEmployer;
    }

    public void setCurrentEmployer(String currentEmployer) {
        this.currentEmployer = currentEmployer;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
