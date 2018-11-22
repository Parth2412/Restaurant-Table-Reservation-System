package com.nagar.aakash.tablereservation.pojos;

import com.google.gson.annotations.SerializedName;
import com.nagar.aakash.tablereservation.Utilities.MyConstants;

import java.util.Date;

public class BookingPOJO {

    @SerializedName("booking_id")
    private Integer booking_id;

    @SerializedName("booking_name")
    private String booking_name;

    @SerializedName("booking_date")
    private Date booking_date;

    @SerializedName("booking_time")
    private String booking_time;

    @SerializedName("booking_contact_no")
    private String booking_contact_no;

    @SerializedName("no_of_person")
    private String no_of_person;

    @SerializedName("restaurant_id")
    private Integer restaurant_id;

    @SerializedName("user_id")
    private Integer user_id;

    @SerializedName("restaurant_image")
    private String restaurant_image;

    @SerializedName("restaurant_name")
    private String restaurant_name;


    public Integer getBooking_id() {
        return booking_id;
    }

    public String getRestaurant_image() {
        return MyConstants.BASE_IMAGE_URL +  restaurant_image;
    }

    public void setRestaurant_image(String restaurant_image) {
        this.restaurant_image = restaurant_image;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public void setBooking_id(Integer booking_id) {

        this.booking_id = booking_id;
    }

    public String getBooking_name() {
        return booking_name;
    }

    public void setBooking_name(String booking_name) {
        this.booking_name = booking_name;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public String getBooking_time() {
        return booking_time;
    }

    public void setBooking_time(String booking_time) {
        this.booking_time = booking_time;
    }

    public String getBooking_contact_no() {
        return booking_contact_no;
    }

    public void setBooking_contact_no(String booking_contact_no) {
        this.booking_contact_no = booking_contact_no;
    }

    public String getNo_of_person() {
        return no_of_person;
    }

    public void setNo_of_person(String no_of_person) {
        this.no_of_person = no_of_person;
    }

    public Integer getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Integer restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
