/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.File;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.xml.bind.annotation.XmlRootElement;

@Entity

public class restaurant {
    @Id
    @GeneratedValue
    private long restaurant_id;
    private String restaurant_name;
    private String restaurant_address;
    private String restaurant_detail;
    private int restaurant_2s_table;
    private int restaurant_4s_table;
    private int restaurant_6s_table;
    private int restaurant_8s_table;
    private int restaurant_total_table;
    private String restaurant_image;
    @ManyToOne
    private city cityObj;
   
    
    public restaurant()
    {
    }
            
    public restaurant(String restaurant_name, String restaurant_address, String restaurant_detail, int restaurant_2s_table, int restaurant_4s_table, int restaurant_6s_table, int restaurant_8s_table, int restaurant_total_table, city cityObj) {
        this.restaurant_name = restaurant_name;
        this.restaurant_address = restaurant_address;
        this.restaurant_detail = restaurant_detail;
        this.restaurant_2s_table = restaurant_2s_table;
        this.restaurant_4s_table = restaurant_4s_table;
        this.restaurant_6s_table = restaurant_6s_table;
        this.restaurant_8s_table = restaurant_8s_table;
        this.restaurant_total_table = restaurant_total_table;
        this.cityObj = cityObj;
    }

    public restaurant(String restaurant_image) {
        this.restaurant_image = restaurant_image;
    }

    public long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getRestaurant_address() {
        return restaurant_address;
    }

    public void setRestaurant_address(String restaurant_address) {
        this.restaurant_address = restaurant_address;
    }

    public String getRestaurant_detail() {
        return restaurant_detail;
    }

    public void setRestaurant_detail(String restaurant_detail) {
        this.restaurant_detail = restaurant_detail;
    }

    public int getRestaurant_2s_table() {
        return restaurant_2s_table;
    }

    public void setRestaurant_2s_table(int restaurant_2s_table) {
        this.restaurant_2s_table = restaurant_2s_table;
    }

    public int getRestaurant_4s_table() {
        return restaurant_4s_table;
    }

    public void setRestaurant_4s_table(int restaurant_4s_table) {
        this.restaurant_4s_table = restaurant_4s_table;
    }

    public int getRestaurant_6s_table() {
        return restaurant_6s_table;
    }

    public void setRestaurant_6s_table(int restaurant_6s_table) {
        this.restaurant_6s_table = restaurant_6s_table;
    }

    public int getRestaurant_8s_table() {
        return restaurant_8s_table;
    }

    public void setRestaurant_8s_table(int restaurant_8s_table) {
        this.restaurant_8s_table = restaurant_8s_table;
    }

    public int getRestaurant_total_table() {
        return restaurant_total_table;
    }

    public void setRestaurant_total_table(int restaurant_total_table) {
        this.restaurant_total_table = restaurant_total_table;
    }

    public city getCityObj() {
        return cityObj;
    }

    public void setCityObj(city cityObj) {
        this.cityObj = cityObj;
    }

    public String getRestaurant_image() {
        return restaurant_image;
    }

    public void setRestaurant_image(String restaurant_image) {
        this.restaurant_image = restaurant_image;
    }

   
    
}
