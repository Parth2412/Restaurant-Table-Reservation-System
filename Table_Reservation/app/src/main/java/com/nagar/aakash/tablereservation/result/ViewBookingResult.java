package com.nagar.aakash.tablereservation.result;

import com.google.gson.annotations.SerializedName;
import com.nagar.aakash.tablereservation.pojos.BookingPOJO;


import java.util.List;

public class ViewBookingResult {
    @SerializedName("status")
    private boolean status;

    @SerializedName("Message")
    private String msg;

    @SerializedName("data")
    private List<BookingPOJO> booking;

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

    public List<BookingPOJO> getBooking() {
        return booking;
    }

    public void setBooking(List<BookingPOJO> booking) {
        this.booking = booking;
    }
}
