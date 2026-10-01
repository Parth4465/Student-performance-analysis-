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
				<h1 style="color:white"><span><i>Staff Dashboard
				</i></span></h1>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbars-host" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
					<span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbars-host">
					<ul class="navbar-nav ml-auto">
						
<!-- 						<li class="nav-item"><a class="nav-link" href="viewStudentStaff.jsp"><button class="btn btn-warning">View Student</button></button></a></li>
 -->					<li class="nav-item"><a class="nav-link" href="updateStudent.jsp"><button class="btn btn-warning">Update Student</button></a></li>
						<li class="nav-item"><a class="nav-link" href="markAttendance.jsp"><button class="btn btn-warning">Mark Attendance</button></a></li>
						<li class="nav-item"><a class="nav-link" href="viewAttendance.jsp"><button class="btn btn-warning">view Attendance</button></a></li>
						<li class="nav-item"><a class="nav-link" href="viewTimetableStaff.jsp"><button class="btn btn-warning">View Timetable</button></a></li>
						<li class="nav-item"><a class="nav-link" href="viewNoticeStaff.jsp"><button class="btn btn-warning">View Notice</button></a></li>
						<li class="nav-item"><a class="nav-link" href="addMarks.jsp"><button class="btn btn-warning">Add Marks</button></a></li>
						<li class="nav-item"><a class="nav-link" href="viewMarks.jsp"><button class="btn btn-warning">View Marks</button></a></li>
						<li class="nav-item "><a class="nav-link" href="index.html"><button class="btn btn-warning">Logout</button></a></li>
 						
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
          <div class="col-md-9 mb-md-5"><br>
          	<h2 class="text-center" style="color:black">Add Marks</h2>
          	<form action="AddMarks" method="post">
            <table  class="table table-striped table-hover" style="width:1200px;">
					      <thead>
					        <tr>
					          <th style="color:black">Id</th>
					          <th style="color:black">Name</th>
					          <th style="color:black">Roll No.</th>
					          <th style="color:black">Year</th>
					          <th style="color:black">Branch</th>
					          <th style="color:black">Subject</th>
					          <th style="color:black">Total</th> 
                    		  <th style="color:black">Marks</th> 
					    </tr>
					      </thead>
					      <tbody>
					      <%
						  	try
						  	{
						  		Connection con = ConnectDB.connect();
						  		PreparedStatement ps = con.prepareStatement("select * from student_tbl");
						  		ResultSet rs = ps.executeQuery();
						  		while(rs.next())
						  		{
						  		%>
						  			<tr>
								      <td style="color:black"><%=rs.getInt(1)%></td>
								      <td style="color:black"><%=rs.getString(2)%></td>
								      <td style="color:black"><%=rs.getString(3)%></td>
								   	  <td style="color:black"><%=rs.getString(5)%></td>
								   	  <td style="color:black"><%=rs.getString(6)%></td>
								   	  <td style="color:black"><input style="width:70px" type="text" name="subject" ><br></td>
								   	  <td style="color:black"><input style="width:70px" type="text" name="total"  ><br></td>
									  <td style="color:black"><input style="width:70px" type="text" name="marks"  ><br></td>
								    </tr>
								<%
						  		}
						  	}
						  	catch(Exception e)
						  	{
						  		e.printStackTrace();
						  	}
						  %>
						  
						  
             
						 <center><label for="date" style="color:black"><b>DATE:</b></label>
							<input type="date" id="date" name="date"><br><br></center> 
						
						
					      </tbody>
					    </table>
					    <div class="form-group">
              <div class="col-sm-12">
               <center><input type="submit" value="Add" class="btn btn-warning py-3 px-5" ></center>
              </div>
              </div>
          </form>
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