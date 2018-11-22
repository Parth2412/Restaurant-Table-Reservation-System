package com.nagar.aakash.tablereservation.result;

import com.google.gson.annotations.SerializedName;
import com.nagar.aakash.tablereservation.pojos.RestaurantPOJO;

import java.util.List;

public class RestaurantResult {


    @SerializedName("status")
    private boolean status;

    @SerializedName("Message")
    private String msg;

    @SerializedName("data")
    private List<RestaurantPOJO> restaurants;

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

    public List<RestaurantPOJO> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantPOJO> restaurants) {
        this.restaurants = restaurants;
    }
}
