<%@page import="dao.manager_operation"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="bean.restaurant"%>
<%@page import="bean.city"%>


<!DOCTYPE HTML>
<html>
    <head>
        <title>Glance Design Dashboard an Admin Panel Category Flat Bootstrap Responsive Website Template | Forms :: w3layouts</title>
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

    </head> 
    <body class="cbp-spmenu-push">
        <div class="main-content">
            <div class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
                <!--left-fixed -navigation-->
                <jsp:include page="manager-left-side-navigation.jsp" />
            </div>
            <!--left-fixed -navigation-->

            <!-- header-starts -->
            <jsp:include page="manager-header.jsp" />
            <!-- //header-ends -->
            <!-- main content start-->
            <%
                manager_operation manopr=new manager_operation();
                restaurant res;
                city cityObj;
                long id;
            %>
            <%
                if(request.getParameter("id")!=null)
                {
                    id=(long)session.getAttribute("restaurant_id");
            %>
                <div id="page-wrapper">
                    <div class="main-page">
                        <div class="forms">

                            <div class=" form-grids row form-grids-right">
                                <div class="widget-shadow " data-example-id="basic-forms"> 
                                    <div class="form-title">
                                        <h4>Update Restaurant Details: <%= id %></h4>
                                    </div>
                                    <div class="form-body">
                                        <form class="form-horizontal" method="post" action="addRestaurantController" > 
                                            <div class="form-group"> 
                                                <label for="inputEmail3" class="col-sm-2 control-label">Name:</label> 
                                                <div class="col-sm-9"> 
                                                    <input type="text" class="form-control" id="inputEmail3" placeholder="Restaurant name" name="restaurant_name"> 
                                                </div> 
                                            </div>
                                            <div class="form-group"> 
                                                <label for="inputEmail3" class="col-sm-2 control-label">Detail:</label> 
                                                <div class="col-sm-9"> 
                                                    <input type="text" class="form-control" id="inputEmail3" placeholder="Restaurant detail" name="restaurant_detail"> 
                                                </div> 
                                            </div>
                                            <div class="form-group"> 
                                                <label for="inputEmail3" class="col-sm-2 control-label">Address:</label> 
                                                <div class="col-sm-9"> 
                                                    <input type="text" class="form-control" id="inputEmail3" placeholder="Restaurant address" name="restaurant_address"> 
                                                </div> 
                                            </div>

                                            <div class="form-group"> 
                                                <label for="inputEmail3" class="col-sm-2 control-label">2's Table:</label> 
                                                <div class="col-sm-9"> 
                                                    <input type="text" class="form-control" id="inputEmail3" placeholder="Restaurant 2's table" name="restaurant_2s_table"> 
                                                </div> 
                                            </div>
                                            <div class="form-group"> 
                                                <label for="inputEmail3" class="col-sm-2 control-label">4's Table:</label> 
                                                <div class="col-sm-9"> 
                                                    <input type="text" class="form-control" id="inputEmail3" placeholder="Restaurant 4's table" name="restaurant_4s_table"> 
                                                </div> 
                                            </div>
                                            <div class="form-group"> 
                                                <label for="inputEmail3" class="col-sm-2 control-label">6's Table:</label> 
                                                <div class="col-sm-9"> 
                                                    <input type="text" class="form-control" id="inputEmail3" placeholder="Restaurant 6's table" name="restaurant_6s_table"> 
                                                </div> 
                                            </div>
                                            <div class="form-group"> 
                                                <label for="inputEmail3" class="col-sm-2 control-label">8's Table:</label> 
                                                <div class="col-sm-9"> 
                                                    <input type="text" class="form-control" id="inputEmail3" placeholder="Restaurant 8's table" name="restaurant_8s_table"> 
                                                </div> 
                                            </div>
                                            <div class="form-group"> 
                                                <label for="inputEmail3" class="col-sm-2 control-label">Total Table:</label> 
                                                <div class="col-sm-9"> 
                                                    <input type="text" class="form-control" id="inputEmail3" placeholder="Restaurant total table" name="restaurant_total_table"> 
                                                </div> 
                                            </div>
                                            <div class="form-group"> 
                                                <label for="inputEmail3" class="col-sm-2 control-label">City:</label> 
                                                <div class="col-sm-9"> 
    <!--                                                <input type="text" class="form-control" id="inputEmail3" placeholder="City" name="restaurant_city"> -->
                                                    <select class="form-control" id="inputEmail3" placeholder="City" name="restaurant_city">
                                                        <%
                                                            city cityObj;
                                                            admin_operation adObj=new admin_operation();
                                                            List li=adObj.selectAllCity();
                                                            ListIterator lit=li.listIterator();
                                                            while(lit.hasNext())
                                                            {
                                                                cityObj=(city)lit.next();
                                                        %>
                                                        <option value='<%=cityObj.getCity_id() %>'><%=cityObj.getCity_name() %></option>
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </div> 
                                            </div>
                                            <div class="col-sm-offset-2"> 
                                                <button type="submit" class="btn btn-default">Update</button> 
                                            </div> 
                                        </form> 
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            <%
                }
            %>
            <!--footer-->
            <jsp:include page="manager-footer.jsp" />
            <!--//footer-->
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