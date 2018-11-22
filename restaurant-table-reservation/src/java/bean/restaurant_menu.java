/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class restaurant_menu {
    @Id
    @GeneratedValue
    private long restaurant_menu_id;
    private String restaurant_menu_image;
    @ManyToOne
    private restaurant restaurantObj;

    public restaurant_menu(restaurant restaurantObj,String restaurant_menu_image) {
        this.restaurant_menu_image = restaurant_menu_image;
        this.restaurantObj = restaurantObj;
    }

    public long getRestaurant_menu_id() {
        return restaurant_menu_id;
    }

    public void setRestaurant_menu_id(long restaurant_menu_id) {
        this.restaurant_menu_id = restaurant_menu_id;
    }

    public String getRestaurant_menu_image() {
        return restaurant_menu_image;
    }

    public void setRestaurant_menu_image(String restaurant_menu_image) {
        this.restaurant_menu_image = restaurant_menu_image;
    }

    public restaurant getRestaurantObj() {
        return restaurantObj;
    }

    public void setRestaurantObj(restaurant restaurantObj) {
        this.restaurantObj = restaurantObj;
    }
    
    
}
