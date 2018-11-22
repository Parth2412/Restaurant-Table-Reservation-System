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
import dao.admin_declaration;
import dao.admin_operation;

/**
 *
 * @author PARTH
 */
public class adminRegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        String admin_name,admin_email,admin_password;
        admin_name=req.getParameter("admin_name");
        admin_email=req.getParameter("admin_email");
        admin_password=req.getParameter("admin_password");
        admin adminObj=new admin(admin_name, admin_password, admin_email);
        admin_declaration adObj=new admin_operation();
        long id=adObj.insertAdmin(adminObj);
        if(id>0)
        {
            resp.sendRedirect("admin-login.jsp?Please Login to Complete Your Registration");
        }
        else
        {
            resp.sendRedirect("Something went wrong...Please try again after sometime");
        }
        
        
    }

    
}
