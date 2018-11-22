/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.admin;
import bean.booking;
import bean.restaurant;
import bean.restaurant_manager;
import bean.restaurant_menu;

import java.io.Serializable;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author PARTH
 */
public class manager_operation implements manager_declaration{
    
    SessionFactory sessionFactoryObj;
    Session sessionObj;
    Transaction transactionObj;
    
    public manager_operation()
    {
        sessionFactoryObj=helpingClasses.session_factory.getSessionFact();
        sessionObj=sessionFactoryObj.openSession();
        transactionObj=sessionObj.beginTransaction();
    }
    
    @Override
    public long insertManager(restaurant_manager man) {
        try
        {
            long l=(Long)sessionObj.save(man);
            transactionObj.commit();
            if(l>0)
            {
                return l;
            }
            else
            {
                return 0;
            }   
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return 0;
    }

    @Override
    public long updateRestaurant(long id, restaurant res) {
        res.setRestaurant_id(id);
        try
        {
            sessionObj.update(res);
            if(!transactionObj.wasCommitted())
            {
                transactionObj.commit();
            }
            return id;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        sessionObj.close();
        return 0;
    }

   


    @Override
    public restaurant_manager getManagerName(String email) {
        String hql="from bean.restaurant_manager where manager_email=:email";
        Query query=sessionObj.createQuery(hql);
        query.setParameter("email", email);
        List<restaurant_manager> li=query.list();
       
        ListIterator lit=li.listIterator();
        if(li.size()>0)
        {
            return li.get(0);
        }
        else
        {
            return null;
        }  
    }

    @Override
    public List loginManager(String email, String password) {
        String hql="from bean.restaurant_manager where manager_email=:email and manager_password=:password";
        Query query=sessionObj.createQuery(hql);
        query.setParameter("email", email);
        query.setParameter("password", password);
        List<admin> li=query.list();
       
        ListIterator lit=li.listIterator();
        
        System.out.println("aujan");
        if(li.size()>0)
        {
            return li;
        }
        else
        {
            return null;
        }  
    }

   


    @Override
    public long getRestaurantId(String email) {
        String hql="from bean.restaurant_manager where manager_email=:email";
        Query query=sessionObj.createQuery(hql);
        query.setParameter("email", email);
        List<restaurant_manager> li=query.list();
        ListIterator lit=li.listIterator();
        restaurant_manager man=(restaurant_manager)li.get(0);
        man.getRestaurantobj().getRestaurant_id();
        if(li.size()>0)
        {
            return man.getRestaurantobj().getRestaurant_id();
        }
        else
        {
            return 0;
        }  
    }

    @Override
    public List viewBookings(long id) {
        String hql="from bean.booking where restaurant_id=:id";
        Query query=sessionObj.createQuery(hql);
        query.setParameter("id", id);
        List<booking> li=query.list();
        ListIterator lit=li.listIterator();
        if(li.size()>0)
        {
            return li;
        }
        else
        {
            return null;
        }  
    }

    @Override
    public boolean deleteBooking(long id) {
        booking book=new booking();
        book.setBooking_id(id);
        try
        {
            sessionObj.delete(book);
            transactionObj.commit();
            sessionObj.close();
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return false;
    }

    @Override
    public List selectSingleRestaurant(long id) {
        
        String hql="from bean.restaurant where restaurant_id=:id";
        Query query=sessionObj.createQuery(hql);
        query.setParameter("id", id);
        List<restaurant> li=query.list();
        ListIterator lit=li.listIterator();
        if(li.size()>0)
        {
            return li;
        }
        else
        {
            return null;
        }
        
        
    }

    @Override
    public long updateRestaurantPhoto(long id, String path) {
        String hql="update bean.restaurant set restaurant_image=:path where restaurant_id=:id";
        Query query=sessionObj.createQuery(hql);
        query.setParameter("id", id);
        query.setParameter("path", path);
        long result=query.executeUpdate();
        if(!transactionObj.wasCommitted())
        {
            transactionObj.commit();
        }
        sessionObj.close();
        return result;
    }

    @Override
    public long addMenuPhoto(restaurant_menu menu) {
        try
        {
            long l=(Long)sessionObj.save(menu);
            transactionObj.commit();
            if(l>0)
            {
                return l;
            }
            else
            {
                return 0;
            }   
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return 0;
    }

   
    
}
