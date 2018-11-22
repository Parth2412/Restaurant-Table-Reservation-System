package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!--\n");
      out.write("Author: W3layouts\n");
      out.write("Author URL: http://w3layouts.com\n");
      out.write("License: Creative Commons Attribution 3.0 Unported\n");
      out.write("License URL: http://creativecommons.org/licenses/by/3.0/\n");
      out.write("-->\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Glance Design Dashboard an Admin Panel Category Flat Bootstrap Responsive Website Template | Login Page :: w3layouts</title>\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<meta name=\"keywords\" content=\"Glance Design Dashboard Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, \n");
      out.write("SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design\" />\n");
      out.write("<script type=\"application/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>\n");
      out.write("\n");
      out.write("<!-- Bootstrap Core CSS -->\n");
      out.write("<link href=\"css/bootstrap.css\" rel='stylesheet' type='text/css' />\n");
      out.write("\n");
      out.write("<!-- Custom CSS -->\n");
      out.write("<link href=\"css/style.css\" rel='stylesheet' type='text/css' />\n");
      out.write("\n");
      out.write("<!-- font-awesome icons CSS-->\n");
      out.write("<link href=\"css/font-awesome.css\" rel=\"stylesheet\"> \n");
      out.write("<!-- //font-awesome icons CSS-->\n");
      out.write("\n");
      out.write(" <!-- side nav css file -->\n");
      out.write(" <link href='css/SidebarNav.min.css' media='all' rel='stylesheet' type='text/css'/>\n");
      out.write(" <!-- side nav css file -->\n");
      out.write(" \n");
      out.write(" <!-- js-->\n");
      out.write("<script src=\"js/jquery-1.11.1.min.js\"></script>\n");
      out.write("<script src=\"js/modernizr.custom.js\"></script>\n");
      out.write("\n");
      out.write("<!--webfonts-->\n");
      out.write("<link href=\"//fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i&amp;subset=cyrillic,cyrillic-ext,latin-ext\" rel=\"stylesheet\">\n");
      out.write("<!--//webfonts-->\n");
      out.write(" \n");
      out.write("<!-- Metis Menu -->\n");
      out.write("<script src=\"js/metisMenu.min.js\"></script>\n");
      out.write("<script src=\"js/custom.js\"></script>\n");
      out.write("<link href=\"css/custom.css\" rel=\"stylesheet\">\n");
      out.write("<!--//Metis Menu -->\n");
      out.write("<style>\n");
      out.write("    .cbp-spmenu-push div#page-wrapper {\n");
      out.write("    margin: 0 0 0 0px;\n");
      out.write("    transition: .5s all;\n");
      out.write("    -webkit-transition: .5s all;\n");
      out.write("    -moz-transition: .5s all;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("element.style {\n");
      out.write("    height: -webkit-fill-available;\n");
      out.write("    \n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head> \n");
      out.write("<body class=\"cbp-spmenu-push\">\n");
      out.write("<div class=\"main-content\">\n");
      out.write("\t\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- main content start-->\n");
      out.write("                <div id=\"page-wrapper\" style=\"height:-webkit-fill-available;\">\n");
      out.write("\t\t\t<div class=\"login-page \">\n");
      out.write("\t\t\t\t<h2 class=\"title1\">Login</h2>\n");
      out.write("\t\t\t\t<div class=\"widget-shadow\">\n");
      out.write("\t\t\t\t\t<div class=\"login-body\">\n");
      out.write("\t\t\t\t\t\t<form action=\"loginController\" method=\"post\">\n");
      out.write("\t\t\t\t\t\t\t<input type=\"email\" class=\"user\" name=\"admin_email\" placeholder=\"Enter Your Email\" required=\"\">\n");
      out.write("\t\t\t\t\t\t\t<input type=\"password\" name=\"admin_password\" class=\"lock\" placeholder=\"Password\" required=\"\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"forgot-grid\">\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"forgot\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\">forgot password?</a>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"clearfix\"> </div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" name=\"Sign In\" value=\"Sign In\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"registration\">\n");
      out.write("\t\t\t\t\t\t\t\tDon't have an account ?\n");
      out.write("\t\t\t\t\t\t\t\t<a class=\"\" href=\"register.jsp\">\n");
      out.write("\t\t\t\t\t\t\t\t\tCreate an account\n");
      out.write("\t\t\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<!-- side nav js -->\n");
      out.write("\t<script src='js/SidebarNav.min.js' type='text/javascript'></script>\n");
      out.write("\t<script>\n");
      out.write("      $('.sidebar-menu').SidebarNav()\n");
      out.write("    </script>\n");
      out.write("\t<!-- //side nav js -->\n");
      out.write("\t\n");
      out.write("\t<!-- Classie --><!-- for toggle left push menu script -->\n");
      out.write("\t\t<script src=\"js/classie.js\"></script>\n");
      out.write("\t\t<script>\n");
      out.write("\t\t\tvar menuLeft = document.getElementById( 'cbp-spmenu-s1' ),\n");
      out.write("\t\t\t\tshowLeftPush = document.getElementById( 'showLeftPush' ),\n");
      out.write("\t\t\t\tbody = document.body;\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\tshowLeftPush.onclick = function() {\n");
      out.write("\t\t\t\tclassie.toggle( this, 'active' );\n");
      out.write("\t\t\t\tclassie.toggle( body, 'cbp-spmenu-push-toright' );\n");
      out.write("\t\t\t\tclassie.toggle( menuLeft, 'cbp-spmenu-open' );\n");
      out.write("\t\t\t\tdisableOther( 'showLeftPush' );\n");
      out.write("\t\t\t};\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tfunction disableOther( button ) {\n");
      out.write("\t\t\t\tif( button !== 'showLeftPush' ) {\n");
      out.write("\t\t\t\t\tclassie.toggle( showLeftPush, 'disabled' );\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t}\n");
      out.write("\t\t</script>\n");
      out.write("\t<!-- //Classie --><!-- //for toggle left push menu script -->\n");
      out.write("\t\t\n");
      out.write("\t<!--scrolling js-->\n");
      out.write("\t<script src=\"js/jquery.nicescroll.js\"></script>\n");
      out.write("\t<script src=\"js/scripts.js\"></script>\n");
      out.write("\t<!--//scrolling js-->\n");
      out.write("\t\n");
      out.write("\t<!-- Bootstrap Core JavaScript -->\n");
      out.write("   <script src=\"js/bootstrap.js\"> </script>\n");
      out.write("\t<!-- //Bootstrap Core JavaScript -->\n");
      out.write("   \n");
      out.write("</body>\n");
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
