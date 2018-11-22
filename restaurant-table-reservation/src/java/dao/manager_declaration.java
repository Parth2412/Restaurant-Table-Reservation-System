/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.restaurant;
import bean.restaurant_manager;
import bean.restaurant_menu;

import java.util.List;

/**
 *
 * @author PARTH
 */
public interface manager_declaration {
    public long insertManager(restaurant_manager man);
    public long updateRestaurant(long id,restaurant res);
    public restaurant_manager getManagerName(String email);
    public List loginManager(String email,String password);
    public long getRestaurantId(String email);
    public List viewBookings(long id);
    public boolean deleteBooking(long id);
    public List selectSingleRestaurant(long id);
    public long updateRestaurantPhoto(long id,String path);
    public long addMenuPhoto(restaurant_menu menu);
    
}
