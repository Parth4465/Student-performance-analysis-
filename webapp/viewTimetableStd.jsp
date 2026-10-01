<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="dbconnect.*" %>
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">

    <!-- Basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">   
   
    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
 
     <!-- Site Metas -->
    <title>Student Performance Analysis Web Application</title>  
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Site Icons -->
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Site CSS -->
    <link rel="stylesheet" href="style.css">
    <!-- ALL VERSION CSS -->
    <link rel="stylesheet" href="css/versions.css">
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/custom.css">

    <!-- Modernizer for Portfolio -->
    <script src="js/modernizer.js"></script>

    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body class="host_version" > 

	<!-- Modal -->
	<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
		<div class="modal-content">
			
		</div>
	  </div>
	</div>

    <!-- LOADER -->
	<div id="preloader">
		<div class="loader-container">
			<div class="progress-br float shadow">
				<div class="progress__item"></div>
			</div>
		</div>
	</div>
	<!-- END LOADER -->	
	
	<!-- Start header -->
	<header class="top-navbar">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<h1 style="color:white"><span><i>Student Dashboard
				</i></span></h1>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbars-host" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
					<span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbars-host">
					<ul class="navbar-nav ml-auto">
						
						<li class="nav-item"><a class="nav-link" href="viewTimetableStd.jsp">View Timetable</a></li>
						<li class="nav-item"><a class="nav-link" href="viewAttStudent.jsp">View Attendance</a></li>
						<li class="nav-item"><a class="nav-link" href="viewMarksStudent.jsp">View Marks</a></li>
						<li class="nav-item"><a class="nav-link" href="feedback.html">Give Feedback</a></li>
						<li class="nav-item"><a class="nav-link" href="profile.jsp">Your Profile</a></li>
						<li class="nav-item active"><a class="nav-link" href="index.html">Logout</a></li>
 						
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<!-- End header -->
	
	<section class="ftco-section contact-section" >
      <div class="container">
        <div class="row d-flex mb-5 contact-info justify-content-center">
        
          </div>
        </div>
        <div class="row block-9 justify-content-center mb-5">
          <div class="col-md-7 mb-md-5"><br>
          	<h2 class="text-center" style="color:black">View Timetable</h2>
            <table  class="table table-striped table-hover" style="width:1000px;">
					      <thead>
					        <tr>
					          <th style="color:black">Id</th>
					          <th style="color:black;padding-left:250px">Notice</th>
					           <th style="color:black">Date Time</th>
					        </tr>
					      </thead>
					      <tbody>
					      <%
						  	try
						  	{
						  		Connection con = ConnectDB.connect();
						  		PreparedStatement ps = con.prepareStatement("select * from timetable_tbl");
						  		ResultSet rs = ps.executeQuery();
						  		while(rs.next())
						  		{
						  			String img1=rs.getString("image");
						  		%>
						  			<tr>
								      <td style="color:black"><%=rs.getInt(1)%></td>
								      <td style="color:black"><img src="timetable/<%=img1%>" width="500" height="300"></td>
								      <td style="color:black"><%=rs.getTimestamp(3)%></td>
								    </tr>
								<%
						  		}
						  	}
						  	catch(Exception e)
						  	{
						  		e.printStackTrace();
						  	}
						  %>
						  
					      </tbody>
					    </table>
          
          </div>
        </div>
        
    </section>

    <!-- ALL JS FILES -->
    <script src="js/all.js"></script>
    <!-- ALL PLUGINS -->
    <script src="js/custom.js"></script>
	<script src="js/timeline.min.js"></script>
	<script>
		timeline(document.querySelectorAll('.timeline'), {
			forceVerticalMode: 700,
			mode: 'horizontal',
			verticalStartPosition: 'left',
			visibleItems: 4
		});
	</script>
</body>
</html>