package controller;
import bean.restaurant;
import bean.city;
import dao.admin_declaration;
import dao.admin_operation;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class addRestaurantController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String restaurant_name;
        String restaurant_detail;
        String restaurant_address;
        int restaurant_city;
        int restaurant_2s_table;
        int restaurant_4s_table;
        int restaurant_6s_table;
        int restaurant_8s_table;
        int restaurant_total_table;
        restaurant_name=req.getParameter("restaurant_name");
        restaurant_detail=req.getParameter("restaurant_detail");
        restaurant_address=req.getParameter("restaurant_address");
        restaurant_2s_table=Integer.parseInt(req.getParameter("restaurant_2s_table"));
        restaurant_4s_table=Integer.parseInt(req.getParameter("restaurant_4s_table"));
        restaurant_6s_table=Integer.parseInt(req.getParameter("restaurant_6s_table"));
        restaurant_8s_table=Integer.parseInt(req.getParameter("restaurant_8s_table"));
        restaurant_total_table=Integer.parseInt(req.getParameter("restaurant_total_table"));
        restaurant_city=Integer.parseInt(req.getParameter("restaurant_city"));
        city cityObj = new city();
        cityObj.setCity_id(restaurant_city);
        restaurant res=new restaurant(restaurant_name, restaurant_address, restaurant_detail, restaurant_2s_table, restaurant_4s_table, restaurant_6s_table, restaurant_8s_table, restaurant_total_table, cityObj);
        admin_declaration adObj=new admin_operation();
        long id=adObj.addRestaurant(res);
        if(id>0)
        {
            resp.sendRedirect("view-all-restaurant.jsp");
        }
        else
        {
            resp.sendRedirect("Something went wrong...Please try again after sometime");
        }
    }
}
