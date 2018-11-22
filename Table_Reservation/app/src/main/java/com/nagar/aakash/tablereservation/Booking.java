package com.nagar.aakash.tablereservation;

/**
 * Created by Aakash on 15-Nov-18.
 */

public class Booking {
    String id,name,date,time,total_person,image;

    public Booking(String id,String name, String date, String time, String total_person, String image) {
        this.id=id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.total_person = total_person;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotal_person() {
        return total_person;
    }

    public void setTotal_person(String total_person) {
        this.total_person = total_person;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
