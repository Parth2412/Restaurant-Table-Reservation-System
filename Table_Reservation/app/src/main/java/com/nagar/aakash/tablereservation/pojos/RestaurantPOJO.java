package com.nagar.aakash.tablereservation.pojos;

import com.google.gson.annotations.SerializedName;
import com.nagar.aakash.tablereservation.Utilities.MyConstants;

import java.io.Serializable;

/**
 * Created by Aakash on 06-Nov-18.
 */

public class RestaurantPOJO implements Serializable {

    @SerializedName("restaurant_id")
    private Integer restaurant_id;

    @SerializedName("restaurant_name")
    private String restaurant_name;

    @SerializedName("restaurant_detail")
    private String restaurant_detail;

    @SerializedName("restaurant_address")
    private String restaurant_address;

    @SerializedName("restaurant_city")
    private String restaurant_city;

    @SerializedName("restaurant_image")
    private String restaurant_image;

    @SerializedName("restaurant_2s_table")
    private Integer restaurant_2s_table;

    @SerializedName("restaurant_4s_table")
    private Integer restaurant_4s_table;

    @SerializedName("restaurant_6s_table")
    private Integer restaurant_6s_table;

    @SerializedName("restaurant_8s_table")
    private Integer restaurant_8s_table;

    @SerializedName("restaurant_total_table")
    private Integer restaurant_total_table;

    public Integer getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Integer restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getRestaurant_detail() {
        return restaurant_detail;
    }

    public void setRestaurant_detail(String restaurant_detail) {
        this.restaurant_detail = restaurant_detail;
    }

    public String getRestaurant_address() {
        return restaurant_address;
    }

    public void setRestaurant_address(String restaurant_address) {
        this.restaurant_address = restaurant_address;
    }

    public String getRestaurant_city() {
        return restaurant_city;
    }

    public void setRestaurant_city(String restaurant_city) {
        this.restaurant_city = restaurant_city;
    }

    public String getRestaurant_image() {
        return MyConstants.BASE_IMAGE_URL + restaurant_image;
    }

    public void setRestaurant_image(String restaurant_image) {
        this.restaurant_image = restaurant_image;
    }

    public Integer getRestaurant_2s_table() {
        return restaurant_2s_table;
    }

    public void setRestaurant_2s_table(Integer restaurant_2s_table) {
        this.restaurant_2s_table = restaurant_2s_table;
    }

    public Integer getRestaurant_4s_table() {
        return restaurant_4s_table;
    }

    public void setRestaurant_4s_table(Integer restaurant_4s_table) {
        this.restaurant_4s_table = restaurant_4s_table;
    }

    public Integer getRestaurant_6s_table() {
        return restaurant_6s_table;
    }

    public void setRestaurant_6s_table(Integer restaurant_6s_table) {
        this.restaurant_6s_table = restaurant_6s_table;
    }

    public Integer getRestaurant_8s_table() {
        return restaurant_8s_table;
    }

    public void setRestaurant_8s_table(Integer restaurant_8s_table) {
        this.restaurant_8s_table = restaurant_8s_table;
    }

    public Integer getRestaurant_total_table() {
        return restaurant_total_table;
    }

    public void setRestaurant_total_table(Integer restaurant_total_table) {
        this.restaurant_total_table = restaurant_total_table;
    }
}
