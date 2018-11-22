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
import com.sun.corba.se.spi.activation.Server;
import dao.admin_declaration;
import dao.admin_operation;
import java.util.List;
import javax.servlet.DispatcherType;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PARTH
 */
public class adminLoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        String admin_email,admin_password;
        admin_email=req.getParameter("admin_email");
        admin_password=req.getParameter("admin_password");
        admin_declaration adObj=new admin_operation();
        List id=adObj.loginAdmin(admin_email, admin_password);
        if(id.size()>0)
        {
            admin adminObj=adObj.getAdminName(admin_email);
            
            HttpSession sessionObj=req.getSession();
            sessionObj.setAttribute("admin_name", adminObj.getAdmin_name());
            resp.sendRedirect("admin-index.jsp");
        }
        else
        {
            resp.sendRedirect("Something went wrong...Please try again after sometime");
        }
    }

    

}
