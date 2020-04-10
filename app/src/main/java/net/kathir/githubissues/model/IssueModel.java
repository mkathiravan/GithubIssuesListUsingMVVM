package net.kathir.githubissues.model;

import com.google.gson.annotations.SerializedName;

public class IssueModel {

    @SerializedName("title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public UserInfoModel getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserInfoModel userinfo) {
        this.userinfo = userinfo;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    @SerializedName("number")
    private String number;

    @SerializedName("user")
    private UserInfoModel userinfo;

    @SerializedName("created_at")
    private String createAt;

}