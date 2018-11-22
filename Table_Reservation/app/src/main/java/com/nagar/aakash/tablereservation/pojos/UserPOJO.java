package com.nagar.aakash.tablereservation.pojos;

import com.google.gson.annotations.SerializedName;

public class UserPOJO {

    @SerializedName("user_id")
    private Integer user_id;

    @SerializedName("user_name")
    private String user_name;

    @SerializedName("user_email")
    private String user_email;

    @SerializedName("user_password")
    private String user_password;

    @SerializedName("user_contact_no")
    private Integer user_contact_no;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Integer getUser_contact_no() {
        return user_contact_no;
    }

    public void setUser_contact_no(Integer user_contact_no) {
        this.user_contact_no = user_contact_no;
    }
}
