<%@page import="org.jfree.chart.ChartUtilities"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.*"%>
<%@page import="dbconnect.*"%>
<%@page import="org.jfree.chart.plot.PlotOrientation"%>
<%@page import="org.jfree.chart.JFreeChart"%>
<%@page import="org.jfree.chart.ChartFactory"%>
<%@page import="org.jfree.data.jdbc.JDBCCategoryDataset"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.jfree.data.category.DefaultCategoryDataset"%>
<%@page import="java.io.OutputStream"%>
<%
    OutputStream out1 = response.getOutputStream();
    String query1 = "SELECT rollno,total,marks from marks_tbl";
    JDBCCategoryDataset dataset1 = new JDBCCategoryDataset("jdbc:mysql://localhost/student_db", "com.mysql.jdbc.Driver","root", "");  
    dataset1.executeQuery(query1);
    JFreeChart chart1 = ChartFactory.createBarChart("Roll No.", "Total Marks", "Marks Obtained",
                    dataset1, PlotOrientation.VERTICAL, true, true, false);		
  response.setContentType("image/jpg");
    ChartUtilities.writeChartAsPNG(out1, chart1, 1000, 600);
    System.out.println("chart 2 completed....");
    
%>