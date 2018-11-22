/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class updateRestaurantControllerRedirect extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        manager_declaration md=new manager_operation();
        long id=md.updateRestaurantPhoto((Long)session.getAttribute("restaurant_id"), (String)session.getAttribute("restaurant_image"));
        if(id>0)
        {
            resp.sendRedirect("view-restaurant-detail.jsp?Your details has been updated successfully");
        }
        else
        {
            resp.sendRedirect("Something went wrong...Please try again after sometime");
        }
    }

    
    
}
