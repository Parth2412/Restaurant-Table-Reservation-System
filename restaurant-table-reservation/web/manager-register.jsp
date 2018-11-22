<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="dao.admin_operation"%>
<%@page import="bean.restaurant"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Book Your Table</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Glance Design Dashboard Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />

        <!-- Custom CSS -->
        <link href="css/style.css" rel='stylesheet' type='text/css' />

        <!-- font-awesome icons CSS -->
        <link href="css/font-awesome.css" rel="stylesheet"> 
        <!-- //font-awesome icons CSS -->

        <!-- side nav css file -->
        <link href='css/SidebarNav.min.css' media='all' rel='stylesheet' type='text/css'/>
        <!-- side nav css file -->

        <!-- js-->
        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/modernizr.custom.js"></script>

        <!--webfonts-->
        <link href="//fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i&amp;subset=cyrillic,cyrillic-ext,latin-ext" rel="stylesheet">
        <!--//webfonts--> 

        <!-- Metis Menu -->
        <script src="js/metisMenu.min.js"></script>
        <script src="js/custom.js"></script>
        <link href="css/custom.css" rel="stylesheet">
        <!--//Metis Menu -->
        <style>
            .cbp-spmenu-push div#page-wrapper {
                margin: 0 0 0 0px;
                transition: .5s all;
                -webkit-transition: .5s all;
                -moz-transition: .5s all;
            }
            .element-style
            {
                height:-webkit-fill-available;
            }
        </style>
    </head> 
    <body class="cbp-spmenu-push">
        <div class="main-content">


            <!-- main content start-->
            <div id="page-wrapper" style="height:-webkit-fill-available;">
                <div class="main-page signup-page">
                    <h2 class="title1">SignUp Here</h2>
                    <div class="sign-up-row widget-shadow">

                        <form action="managerRegisterController" method="post">
                            <div class="sign-u">
                                <input type="text" name="manager_name" placeholder="Name" required="">
                                <div class="clearfix"> </div>
                            </div>
                            <div class="sign-u">
                                <input type="email" name="manager_email" placeholder="Email Address" required="">
                                <div class="clearfix"> </div>
                            </div>
                            <div class="sign-u">
                                <input type="password" name="manager_password" placeholder="Password" required="">
                                <div class="clearfix"> </div>
                            </div>
                            <div class="sign-u">
                                <select class="form-control" name="restaurant" placeholder="restaurant">
                                    <option>Select Your Restaurant</option>
                                    <%
                                        restaurant resObj;
                                        admin_operation adObj=new admin_operation();
                                        List li=adObj.selectAllRestaurant();
                                        ListIterator lit=li.listIterator();
                                        while(lit.hasNext())
                                        {
                                            resObj=(restaurant)lit.next();
                                    %>
                                    <option value="<%= resObj.getRestaurant_id() %>"><%= resObj.getRestaurant_name() %></option>
                                    <%
                                        }
                                    %>
                                </select>
                                <div class="clearfix"> </div>
                            </div>
                            
                            <div class="clearfix"> </div>
                            <div class="sub_home">
                                <input type="submit" value="Register">
                                <div class="clearfix"> </div>
                            </div>
                            <div class="registration">
                                Already Registered.
                                <a class="" href="manager-login.jsp">
                                    Login
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>

        <!-- side nav js -->
        <script src='js/SidebarNav.min.js' type='text/javascript'></script>
        <script>
            $('.sidebar-menu').SidebarNav()
        </script>
        <!-- //side nav js -->

        <!-- Classie --><!-- for toggle left push menu script -->
        <script src="js/classie.js"></script>
        <script>
            var menuLeft = document.getElementById('cbp-spmenu-s1'),
                    showLeftPush = document.getElementById('showLeftPush'),
                    body = document.body;

            showLeftPush.onclick = function () {
                classie.toggle(this, 'active');
                classie.toggle(body, 'cbp-spmenu-push-toright');
                classie.toggle(menuLeft, 'cbp-spmenu-open');
                disableOther('showLeftPush');
            };

            function disableOther(button) {
                if (button !== 'showLeftPush') {
                    classie.toggle(showLeftPush, 'disabled');
                }
            }
        </script>
        <!-- //Classie --><!-- //for toggle left push menu script -->

        <!--scrolling js-->
        <script src="js/jquery.nicescroll.js"></script>
        <script src="js/scripts.js"></script>
        <!--//scrolling js-->

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.js"></script>

    </body>
</html>