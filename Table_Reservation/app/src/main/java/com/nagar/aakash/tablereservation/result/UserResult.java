package com.nagar.aakash.tablereservation.result;

import com.google.gson.annotations.SerializedName;
import com.nagar.aakash.tablereservation.pojos.UserPOJO;

public class UserResult {

    @SerializedName("status")
    private boolean status;

    @SerializedName("Message")
    private String msg;

    @SerializedName("data")
    private UserPOJO userPOJO;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserPOJO getUserPOJO() {
        return userPOJO;
    }

    public void setUserPOJO(UserPOJO userPOJO) {
        this.userPOJO = userPOJO;
    }
}
