/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.admin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.city;
import dao.admin_declaration;
import dao.admin_operation;

/**
 *
 * @author PARTH
 */
public class addCityController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city_name=req.getParameter("city_name");
        city cityObj=new city(city_name);
        admin_declaration adObj=new admin_operation();
        long id=adObj.addCity(cityObj);
        if(id>0)
        {
            resp.sendRedirect("view-all-city.jsp");
        }
        else
        {
            resp.sendRedirect("Something went wrong...Please try again after sometime");
        }
        
    }

    

}
