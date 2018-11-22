/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.admin;
import bean.city;
import bean.restaurant;
import bean.user;
import java.util.List;
import helpingClasses.session_factory;
import java.util.ListIterator;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author PARTH
 */
public class admin_operation implements admin_declaration{

    SessionFactory sessionFactoryObj;
    Session sessionObj;
    Transaction transactionObj;
    
    public admin_operation()
    {
        sessionFactoryObj=helpingClasses.session_factory.getSessionFact();
        sessionObj=sessionFactoryObj.openSession();
        transactionObj=sessionObj.beginTransaction();
    }
    
    @Override
    public long insertAdmin(admin ad) {
        try
        {
            long l=(Long)sessionObj.save(ad);
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
    public List selectAllRestaurant() {
        String hql="from bean.restaurant";
        Query query=sessionObj.createQuery(hql);
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
    public List selectAllUser() {
        String hql="from bean.user";
        Query query=sessionObj.createQuery(hql);
        List<user> li=query.list();
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
    public boolean deleteRestaurant(long id) {
        restaurant res=new restaurant();
        res.setRestaurant_id(id);
        try
        {
            sessionObj.delete(res);
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
    public List searchByName(String name) {
        Criteria criteria=sessionObj.createCriteria(restaurant.class);
        criteria.add(Restrictions.like("name","%"+name+"%"));
        List li=criteria.list();
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
    public List loginAdmin(String email,String password) {
        String hql="from bean.admin where admin_email=:email and admin_password=:password";
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
    public long addRestaurant(restaurant res) {
        try
        {
            long l=(Long)sessionObj.save(res);
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
    public long addCity(city c) {
        try
        {
            long l=(Long)sessionObj.save(c);
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
    public List selectAllCity() {
        String hql="from bean.city";
        Query query=sessionObj.createQuery(hql);
        List<city> li=query.list();
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
    public boolean deleteCity(long id) {
        city c=new city();
        c.setCity_id(id);
        try
        {
            sessionObj.delete(c);
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
    public admin getAdminName(String email) {
        String hql="from bean.admin where admin_email=:email";
        Query query=sessionObj.createQuery(hql);
        query.setParameter("email", email);
        List<admin> li=query.list();
       
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
    
}
