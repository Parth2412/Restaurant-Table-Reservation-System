/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.city;
import bean.restaurant;
import dao.manager_declaration;
import dao.manager_operation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PARTH
 */
public class updateRestaurantController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String restaurant_name=req.getParameter("restaurant_name");
        String restaurant_detail=req.getParameter("restaurant_detail");
        String restaurant_address=req.getParameter("restaurant_address");
        int restaurant_2s_table=Integer.parseInt(req.getParameter("restaurant_2s_table"));
        int restaurant_4s_table=Integer.parseInt(req.getParameter("restaurant_4s_table"));
        int restaurant_6s_table=Integer.parseInt(req.getParameter("restaurant_6s_table"));
        int restaurant_8s_table=Integer.parseInt(req.getParameter("restaurant_8s_table"));
        int restaurant_total_table=Integer.parseInt(req.getParameter("restaurant_total_table"));
        int restaurant_city=Integer.parseInt(req.getParameter("restaurant_city"));
        String restaurant_image=req.getParameter("restaurant_image");
        
        session.setAttribute("restaurant_image", restaurant_image);
        city cityObj = new city();
        cityObj.setCity_id(restaurant_city);
        
        restaurant resObj=new restaurant(restaurant_name, restaurant_address, restaurant_detail, restaurant_2s_table, restaurant_4s_table, restaurant_6s_table, restaurant_8s_table, restaurant_total_table, cityObj);
        manager_declaration md=new manager_operation();
        long id=md.updateRestaurant((Long)session.getAttribute("restaurant_id"), resObj);
        
        if(id>0)
        {
            
            resp.sendRedirect("updateRestaurantControllerRedirect");
        }
        else
        {
            resp.sendRedirect("something went wrong....Please try again after sometime");
        }

        
    }

    

}
