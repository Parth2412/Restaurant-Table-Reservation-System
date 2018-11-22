/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.admin;
import bean.restaurant_manager;
import com.sun.corba.se.spi.activation.Server;
import dao.admin_declaration;
import dao.admin_operation;
import dao.manager_declaration;
import dao.manager_operation;
import java.util.List;
import javax.servlet.DispatcherType;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PARTH
 */
public class managerLoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        String manager_email,manager_password;
        manager_email=req.getParameter("manager_email");
        manager_password=req.getParameter("manager_password");
        
        manager_declaration mdObj=new manager_operation();
        List id=mdObj.loginManager(manager_email, manager_password);
        if(id.size()>0)
        {
            restaurant_manager managerObj=mdObj.getManagerName(manager_email);
            long user=(long)mdObj.getRestaurantId(manager_email);
            HttpSession sessionObj=req.getSession();
            sessionObj.setAttribute("manager_name", managerObj.getManager_name());
            sessionObj.setAttribute("restaurant_id", user);
            resp.sendRedirect("manager-index.jsp");
        }
        else
        {
            resp.sendRedirect("Something went wrong...Please try again after sometime");
        }
    }

    

}
