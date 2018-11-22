package com.nagar.aakash.tablereservation.result;

import com.google.gson.annotations.SerializedName;

public class BookingResult {

    @SerializedName("status")
    private boolean status;

    @SerializedName("Message")
    private String msg;

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
}
