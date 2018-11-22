/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.admin_operation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PARTH
 */
public class deleteRestaurantController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        admin_operation adopr=new admin_operation();
        boolean boolObj=adopr.deleteRestaurant(id);
        if(boolObj==true)
        {
            resp.sendRedirect("view-all-restaurant.jsp");
        }
        else
        {
            resp.getWriter().print("Something went wrong...Please try again");
        }
    }
    
}
