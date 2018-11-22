/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.admin;
import bean.city;
import bean.restaurant;

import java.util.List;

public interface admin_declaration {
    public long insertAdmin(admin ad);
    public long addRestaurant(restaurant res);
    public long addCity(city c);
    public List loginAdmin(String email,String password);
    public admin getAdminName(String email);
    public List selectAllRestaurant();
    public List selectAllUser();
    public List selectAllCity();
    public boolean deleteRestaurant(long id);
    public boolean deleteCity(long id);
    public List searchByName(String name);
    
}
