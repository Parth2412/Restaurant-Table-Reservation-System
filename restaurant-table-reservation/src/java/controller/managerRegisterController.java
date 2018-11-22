/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.restaurant;
import bean.restaurant_manager;
import dao.manager_declaration;
import dao.manager_operation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PARTH
 */
public class managerRegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String manager_email;
        String manager_password;
        String manager_name;
        int restaurant;
        manager_email=req.getParameter("manager_email");
        manager_password=req.getParameter("manager_password");
        manager_name=req.getParameter("manager_name");
        restaurant=Integer.parseInt(req.getParameter("restaurant"));
        restaurant resObj=new restaurant();
        resObj.setRestaurant_id(restaurant);
        restaurant_manager man=new restaurant_manager(manager_name, manager_password, manager_email, resObj);
        manager_declaration md=new manager_operation();
        long id=md.insertManager(man);
        if(id>0)
        {
            resp.sendRedirect("manager-login.jsp?Please login to complete your registration");
        }
        else
        {
            resp.sendRedirect("something went wrong....please try again after sometime");
        }
    }

    

}
