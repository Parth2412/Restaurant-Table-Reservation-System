/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.restaurant;
import bean.restaurant_manager;
import bean.restaurant_menu;
import dao.manager_declaration;
import dao.manager_operation;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author PARTH
 */
public class addRestaurantMenuController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
//        long id=(long) req.getAttribute("restaurant_id");
        boolean isMultiPart;
        String filePath;
        int maxFileSize=5000*1024;
        int maxMemSize=5000*1024;
        File file=null;
        String location="";
        filePath=getServletContext().getInitParameter("file_upload");
        isMultiPart=ServletFileUpload.isMultipartContent(req);
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        restaurant res=new restaurant();
        if(!isMultiPart)
        {
            out.println("File Not Uploaded");
        }
        DiskFileItemFactory factory=new DiskFileItemFactory();
        factory.setSizeThreshold(maxMemSize);
        factory.setRepository(new File("c:\\temp"));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(maxFileSize);
        try
        {
            List FileItems=upload.parseRequest(req);
            Iterator i= FileItems.iterator();
            while(i.hasNext())
            {
                FileItem fi=(FileItem)i.next();
                if(!fi.isFormField())
                {
                    String fieldName=fi.getFieldName();
                    String fileName=fi.getName();
                    String contentType=fi.getContentType();
                    if(fileName.lastIndexOf("\\")>=0)
                    {
                        file=new File(filePath+fileName.substring(fileName.lastIndexOf("\\")));
                        location=fileName;
                        restaurant restaurantObj=new restaurant();
                        restaurantObj.setRestaurant_id((Long)session.getAttribute("restaurant_id"));
                        
                        restaurant_menu menuObj=new restaurant_menu(restaurantObj,location);
                        manager_declaration md=new manager_operation();
                        long l=md.addMenuPhoto(menuObj);
                        if(l>0)
                        {
                            resp.sendRedirect("manager-index.jsp");
                        }
                        else
                        {
                            out.println("Something went Wrong...Please try again later");
                        }
                    }
                    else
                    {
                        file=new File(filePath+fileName.substring(fileName.lastIndexOf("\\")+1));
                        location=fileName;
                        restaurant restaurantObj=new restaurant();
                        restaurantObj.setRestaurant_id((Long)session.getAttribute("restaurant_id"));
                        System.out.println(location);
                        System.out.println(restaurantObj.getRestaurant_id());
                        restaurant_menu menuObj=new restaurant_menu(restaurantObj, location);
                        manager_declaration md=new manager_operation();
                        long l=md.addMenuPhoto(menuObj);
                        if(l>0)
                        {
                            resp.sendRedirect("manager-index.jsp");
                        }
                        else
                        {
                            out.println("Something went Wrong...Please try again later");
                        } 
                    }
                    fi.write(file);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    
}
