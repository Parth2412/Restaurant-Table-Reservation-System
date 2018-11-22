/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity

public class restaurant_manager {
    @Id
    @GeneratedValue
    private long manager_id;
    private String manager_name;
    private String manager_password;
    @Column(unique=true,nullable=false)
    private String manager_email;
    @ManyToOne
    private restaurant restaurantobj;

    public restaurant_manager()
    {
    }
    
    public restaurant_manager(String manager_name, String manager_password, String manager_email, restaurant restaurantobj) {
        this.manager_name = manager_name;
        this.manager_password = manager_password;
        this.manager_email = manager_email;
        this.restaurantobj = restaurantobj;
    }

    public long getManager_id() {
        return manager_id;
    }

    public void setManager_id(long manager_id) {
        this.manager_id = manager_id;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public String getManager_password() {
        return manager_password;
    }

    public void setManager_password(String manager_password) {
        this.manager_password = manager_password;
    }

    public String getManager_email() {
        return manager_email;
    }

    public void setManager_email(String manager_email) {
        this.manager_email = manager_email;
    }

    public restaurant getRestaurantobj() {
        return restaurantobj;
    }

    public void setRestaurantobj(restaurant restaurantobj) {
        this.restaurantobj = restaurantobj;
    }
    
}
