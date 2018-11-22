package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bean.restaurant;
import java.util.Iterator;
import java.util.Set;
import bean.city;
import java.util.ListIterator;
import java.util.List;
import dao.admin_operation;

public final class view_002dall_002dcity_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Book Your Table</title>\n");
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
      out.write("                    <div class=\"tables\">\n");
      out.write("                        <div class=\"table-responsive bs-example widget-shadow\">\n");
      out.write("                            <h4 style=\"margin-bottom: -1em;\">Cities:</h4>\n");
      out.write("                            <button type=\"button\" class=\"btn btn-success btn-flat btn-pri\" style=\"float: right; margin-top: 0px;\" onclick=\"location.href='add-city.jsp'\"><i class=\"fa fa-plus\" aria-hidden=\"true\"></i> Add City</button>\n");
      out.write("                            <table class=\"table table-bordered\" style=\"margin-top: 50px;\"> \n");
      out.write("                                <thead> \n");
      out.write("                                    <tr> \n");
      out.write("                                        <th>#</th> \n");
      out.write("                                        <th>Name</th>  \n");
      out.write("                                    </tr> \n");
      out.write("                                </thead> \n");
      out.write("                                <tbody>\n");
      out.write("                                    ");

                                        admin_operation adopr=new admin_operation();
                                        if(adopr.selectAllCity()!=null){
                                            List li=adopr.selectAllCity();
                                            ListIterator lit=li.listIterator();
                                            while(lit.hasNext()){
                                                city cityObj=(city)lit.next();
                                        
                                    
      out.write("\n");
      out.write("                                        <tr> \n");
      out.write("                                            <th>");
      out.print( cityObj.getCity_id() );
      out.write("</th> \n");
      out.write("                                            <td>");
      out.print( cityObj.getCity_name() );
      out.write("</td> \n");
      out.write("                                            <td><a href=\"deleteRestaurantController?id=");
      out.print(cityObj.getCity_id() );
      out.write("\"><img src=\"delete.png\" style=\"height:25px;width:25px\"></a></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    ");

                                        }
                                        }
                                    
      out.write("\n");
      out.write("                                </tbody>\n");
      out.write("                            </table> \n");
      out.write("                        </div>\n");
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
      out.write("    var menuLeft = document.getElementById('cbp-spmenu-s1'),\n");
      out.write("            showLeftPush = document.getElementById('showLeftPush'),\n");
      out.write("            body = document.body;\n");
      out.write("\n");
      out.write("    showLeftPush.onclick = function () {\n");
      out.write("        classie.toggle(this, 'active');\n");
      out.write("        classie.toggle(body, 'cbp-spmenu-push-toright');\n");
      out.write("        classie.toggle(menuLeft, 'cbp-spmenu-open');\n");
      out.write("        disableOther('showLeftPush');\n");
      out.write("    };\n");
      out.write("\n");
      out.write("    function disableOther(button) {\n");
      out.write("        if (button !== 'showLeftPush') {\n");
      out.write("            classie.toggle(showLeftPush, 'disabled');\n");
      out.write("        }\n");
      out.write("    }\n");
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
