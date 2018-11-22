/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

//@Entity

public class booking {
    //@Id
    //@GeneratedValue
    private long booking_id;
    private String booking_time;
    private String booking_date;
    private String booking_name;
    private long booking_contact_no;
    private int no_of_person;
    //@ManyToMany
    //@JoinColumn(name="user_id")
    private user userObj;
    //@ManyToMany
    //@JoinColumn(name="restaurant_id")
    private long restaurant_id;

    public booking() {
    }

    public booking(String booking_time, String booking_date, String booking_name, long booking_contact_no, int no_of_person, user userObj, long restaurant_id) {
        this.booking_time = booking_time;
        this.booking_date = booking_date;
        this.booking_name = booking_name;
        this.booking_contact_no = booking_contact_no;
        this.no_of_person = no_of_person;
        this.userObj = userObj;
        this.restaurant_id = restaurant_id;
    }

    public long getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(long booking_id) {
        this.booking_id = booking_id;
    }

    public String getBooking_time() {
        return booking_time;
    }

    public void setBooking_time(String booking_time) {
        this.booking_time = booking_time;
    }

    public String getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(String booking_date) {
        this.booking_date = booking_date;
    }

    public String getBooking_name() {
        return booking_name;
    }

    public void setBooking_name(String booking_name) {
        this.booking_name = booking_name;
    }

    public long getBooking_contact_no() {
        return booking_contact_no;
    }

    public void setBooking_contact_no(long booking_contact_no) {
        this.booking_contact_no = booking_contact_no;
    }

    public int getNo_of_person() {
        return no_of_person;
    }

    public void setNo_of_person(int no_of_person) {
        this.no_of_person = no_of_person;
    }

    public user getUserObj() {
        return userObj;
    }

    public void setUserObj(user userObj) {
        this.userObj = userObj;
    }

    public long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    
}
