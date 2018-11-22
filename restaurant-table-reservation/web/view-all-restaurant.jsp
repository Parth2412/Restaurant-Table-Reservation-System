
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="bean.restaurant"%>
<%@page import="bean.city"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="dao.admin_operation"%>
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

    </head> 
    <body class="cbp-spmenu-push">
        <div class="main-content">
            <div class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
                <!--left-fixed -navigation-->
                <jsp:include page="admin-left-side-navigation.jsp" />
            </div>
            <!--left-fixed -navigation-->

            <!-- header-starts -->
            <jsp:include page="admin-header.jsp" />
            <!-- //header-ends -->
            <!-- main content start-->
            <div id="page-wrapper">
                <div class="main-page">
                    <div class="tables">
                        <div class="table-responsive bs-example widget-shadow">
                            <h4 style="margin-bottom: -1em;">Restaurants:</h4>
                            <button type="button" class="btn btn-success btn-flat btn-pri" style="float: right; margin-top: 0px;" onclick="location.href='add-restaurant.jsp'"><i class="fa fa-plus" aria-hidden="true"></i> Add Restaurant</button>
                            <table class="table table-bordered" style="margin-top: 50px;"> 
                                <thead> 
                                    <tr> 
                                        <th>#</th> 
                                        <th>Name</th> 
                                        <th>Detail</th> 
                                        <th>Address</th> 
                                        <th>2s Table</th> 
                                        <th>4s Table</th> 
                                        <th>6s Table</th> 
                                        <th>8s Table</th> 
                                        <th>Total Table</th> 
                                        <th>City</th> 
                                        <th>Action</th> 
                                    </tr> 
                                </thead> 
                                <tbody>
                                    <%
                                        admin_operation adopr=new admin_operation();
                                        if(adopr.selectAllRestaurant()!=null){
                                            List li=adopr.selectAllRestaurant();
                                            ListIterator lit=li.listIterator();
                                            while(lit.hasNext()){
                                                restaurant resObj=(restaurant)lit.next();
                                        
                                    %>
                                        <tr> 
                                            <th><%= resObj.getRestaurant_id() %></th> 
                                            <td><%= resObj.getRestaurant_name() %></td> 
                                            <td><%= resObj.getRestaurant_detail() %></td> 
                                            <td><%= resObj.getRestaurant_address() %></td> 
                                            <td><%= resObj.getRestaurant_2s_table() %></td>
                                            <td><%= resObj.getRestaurant_4s_table() %></td> 
                                            <td><%= resObj.getRestaurant_6s_table() %></td>
                                            <td><%= resObj.getRestaurant_8s_table() %></td>
                                            <td><%= resObj.getRestaurant_total_table() %></td>
                                            <td><%= resObj.getCityObj().getCity_name() %></td>
                                            <td><a href="deleteRestaurantController?id=<%=resObj.getRestaurant_id() %>"><img src="delete.png" style="height:25px;width:25px"></a></td>
                                        </tr>
                                    <%
                                        }
                                        }
                                    %>
                                </tbody>
                            </table> 
                        </div>
                    </div>
                </div>
            </div>
            <!--footer-->
            <jsp:include page="admin-footer.jsp" />
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