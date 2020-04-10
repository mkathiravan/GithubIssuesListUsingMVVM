package net.kathir.githubissues.model;

import com.google.gson.annotations.SerializedName;

public class UserInfoModel {

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @SerializedName("login")
    private String login;


}
