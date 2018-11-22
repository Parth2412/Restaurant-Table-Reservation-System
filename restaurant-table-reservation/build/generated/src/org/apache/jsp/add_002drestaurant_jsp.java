package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ListIterator;
import java.util.List;
import dao.admin_operation;
import bean.restaurant;
import bean.city;

public final class add_002drestaurant_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Glance Design Dashboard an Admin Panel Category Flat Bootstrap Responsive Website Template | Forms :: w3layouts</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <meta name=\"keywords\" content=\"Glance Design Dashboard Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, \n");
      out.write("              SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design\" />\n");
      out.write("        <script type=\"application/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap Core CSS -->\n");
      out.write("        <link href=\"css/bootstrap.css\" rel='stylesheet' type='text/css' />\n");
      out.write("\n");
      out.write("        <!-- Custom CSS -->\n");
      out.write("        <link href=\"css/style.css\" rel='stylesheet' type='text/css' />\n");
      out.write("\n");
      out.write("        <!-- font-awesome icons CSS -->\n");
      out.write("        <link href=\"css/font-awesome.css\" rel=\"stylesheet\"> \n");
      out.write("        <!-- //font-awesome icons CSS -->\n");
      out.write("\n");
      out.write("        <!-- side nav css file -->\n");
      out.write("        <link href='css/SidebarNav.min.css' media='all' rel='stylesheet' type='text/css'/>\n");
      out.write("        <!-- side nav css file -->\n");
      out.write("\n");
      out.write("        <!-- js-->\n");
      out.write("        <script src=\"js/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <script src=\"js/modernizr.custom.js\"></script>\n");
      out.write("\n");
      out.write("        <!--webfonts-->\n");
      out.write("        <link href=\"//fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i&amp;subset=cyrillic,cyrillic-ext,latin-ext\" rel=\"stylesheet\">\n");
      out.write("        <!--//webfonts--> \n");
      out.write("\n");
      out.write("        <!-- Metis Menu -->\n");
      out.write("        <script src=\"js/metisMenu.min.js\"></script>\n");
      out.write("        <script src=\"js/custom.js\"></script>\n");
      out.write("        <link href=\"css/custom.css\" rel=\"stylesheet\">\n");
      out.write("        <!--//Metis Menu -->\n");
      out.write("\n");
      out.write("    </head> \n");
      out.write("    <body class=\"cbp-spmenu-push\">\n");
      out.write("        <div class=\"main-content\">\n");
      out.write("            <div class=\"cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left\" id=\"cbp-spmenu-s1\">\n");
      out.write("                <!--left-fixed -navigation-->\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "admin-left-side-navigation.jsp", out, false);
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!--left-fixed -navigation-->\n");
      out.write("\n");
      out.write("            <!-- header-starts -->\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "admin-header.jsp", out, false);
      out.write("\n");
      out.write("            <!-- //header-ends -->\n");
      out.write("            <!-- main content start-->\n");
      out.write("            <div id=\"page-wrapper\">\n");
      out.write("                <div class=\"main-page\">\n");
      out.write("                    <div class=\"forms\">\n");
      out.write("\n");
      out.write("                        <div class=\" form-grids row form-grids-right\">\n");
      out.write("                            <div class=\"widget-shadow \" data-example-id=\"basic-forms\"> \n");
      out.write("                                <div class=\"form-title\">\n");
      out.write("                                    <h4>Add Restaurant :</h4>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-body\">\n");
      out.write("                                    <form class=\"form-horizontal\" method=\"post\" action=\"addRestaurantController\" enctype=\"multipart/form-data\"> \n");
      out.write("                                        <div class=\"form-group\"> \n");
      out.write("                                            <label for=\"inputEmail3\" class=\"col-sm-2 control-label\">Name:</label> \n");
      out.write("                                            <div class=\"col-sm-9\"> \n");
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"inputEmail3\" placeholder=\"Restaurant name\" name=\"restaurant_name\"> \n");
      out.write("                                            </div> \n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\"> \n");
      out.write("                                            <label for=\"inputEmail3\" class=\"col-sm-2 control-label\">Detail:</label> \n");
      out.write("                                            <div class=\"col-sm-9\"> \n");
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"inputEmail3\" placeholder=\"Restaurant detail\" name=\"restaurant_detail\"> \n");
      out.write("                                            </div> \n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\"> \n");
      out.write("                                            <label for=\"inputEmail3\" class=\"col-sm-2 control-label\">Address:</label> \n");
      out.write("                                            <div class=\"col-sm-9\"> \n");
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"inputEmail3\" placeholder=\"Restaurant address\" name=\"restaurant_address\"> \n");
      out.write("                                            </div> \n");
      out.write("                                        </div>\n");
      out.write("                                        \n");
      out.write("                                        <div class=\"form-group\"> \n");
      out.write("                                            <label for=\"inputEmail3\" class=\"col-sm-2 control-label\">2's Table:</label> \n");
      out.write("                                            <div class=\"col-sm-9\"> \n");
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"inputEmail3\" placeholder=\"Restaurant 2's table\" name=\"restaurant_2s_table\"> \n");
      out.write("                                            </div> \n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\"> \n");
      out.write("                                            <label for=\"inputEmail3\" class=\"col-sm-2 control-label\">4's Table:</label> \n");
      out.write("                                            <div class=\"col-sm-9\"> \n");
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"inputEmail3\" placeholder=\"Restaurant 4's table\" name=\"restaurant_4s_table\"> \n");
      out.write("                                            </div> \n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\"> \n");
      out.write("                                            <label for=\"inputEmail3\" class=\"col-sm-2 control-label\">6's Table:</label> \n");
      out.write("                                            <div class=\"col-sm-9\"> \n");
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"inputEmail3\" placeholder=\"Restaurant 6's table\" name=\"restaurant_6s_table\"> \n");
      out.write("                                            </div> \n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\"> \n");
      out.write("                                            <label for=\"inputEmail3\" class=\"col-sm-2 control-label\">8's Table:</label> \n");
      out.write("                                            <div class=\"col-sm-9\"> \n");
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"inputEmail3\" placeholder=\"Restaurant 8's table\" name=\"restaurant_8s_table\"> \n");
      out.write("                                            </div> \n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\"> \n");
      out.write("                                            <label for=\"inputEmail3\" class=\"col-sm-2 control-label\">Total Table:</label> \n");
      out.write("                                            <div class=\"col-sm-9\"> \n");
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"inputEmail3\" placeholder=\"Restaurant total table\" name=\"restaurant_total_table\"> \n");
      out.write("                                            </div> \n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\"> \n");
      out.write("                                            <label for=\"inputEmail3\" class=\"col-sm-2 control-label\">City:</label> \n");
      out.write("                                            <div class=\"col-sm-9\"> \n");
      out.write("<!--                                                <input type=\"text\" class=\"form-control\" id=\"inputEmail3\" placeholder=\"City\" name=\"restaurant_city\"> -->\n");
      out.write("                                                <select class=\"form-control\" id=\"inputEmail3\" placeholder=\"City\" name=\"restaurant_city\">\n");
      out.write("                                                    ");

                                                        city cityObj;
                                                        admin_operation adObj=new admin_operation();
                                                        List li=adObj.selectAllCity();
                                                        ListIterator lit=li.listIterator();
                                                        while(lit.hasNext())
                                                        {
                                                            cityObj=(city)lit.next();
                                                    
      out.write("\n");
      out.write("                                                    <option value='");
      out.print(cityObj.getCity_id() );
      out.write('\'');
      out.write('>');
      out.print(cityObj.getCity_name() );
      out.write("</option>\n");
      out.write("                                                    ");

                                                        }
                                                    
      out.write("\n");
      out.write("                                                </select>\n");
      out.write("                                            </div> \n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-sm-offset-2\"> \n");
      out.write("                                            <button type=\"submit\" class=\"btn btn-default\">Add</button> \n");
      out.write("                                        </div> \n");
      out.write("                                    </form> \n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!--footer-->\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "admin-footer.jsp", out, false);
      out.write("\n");
      out.write("            <!--//footer-->\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- side nav js -->\n");
      out.write("        <script src='js/SidebarNav.min.js' type='text/javascript'></script>\n");
      out.write("        <script>\n");
      out.write("            $('.sidebar-menu').SidebarNav()\n");
      out.write("        </script>\n");
      out.write("        <!-- //side nav js -->\n");
      out.write("\n");
      out.write("        <!-- Classie --><!-- for toggle left push menu script -->\n");
      out.write("        <script src=\"js/classie.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            var menuLeft = document.getElementById('cbp-spmenu-s1'),\n");
      out.write("                    showLeftPush = document.getElementById('showLeftPush'),\n");
      out.write("                    body = document.body;\n");
      out.write("\n");
      out.write("            showLeftPush.onclick = function () {\n");
      out.write("                classie.toggle(this, 'active');\n");
      out.write("                classie.toggle(body, 'cbp-spmenu-push-toright');\n");
      out.write("                classie.toggle(menuLeft, 'cbp-spmenu-open');\n");
      out.write("                disableOther('showLeftPush');\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            function disableOther(button) {\n");
      out.write("                if (button !== 'showLeftPush') {\n");
      out.write("                    classie.toggle(showLeftPush, 'disabled');\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <!-- //Classie --><!-- //for toggle left push menu script -->\n");
      out.write("\n");
      out.write("        <!--scrolling js-->\n");
      out.write("        <script src=\"js/jquery.nicescroll.js\"></script>\n");
      out.write("        <script src=\"js/scripts.js\"></script>\n");
      out.write("        <!--//scrolling js-->\n");
      out.write("\n");
      out.write("        <!-- Bootstrap Core JavaScript -->\n");
      out.write("        <script src=\"js/bootstrap.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
