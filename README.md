# Student Performance Analysis Web Application

A Java EE web application for managing student academic information, attendance, marks, feedback, notices, timetables, and student performance reports. The application provides separate dashboards and workflows for administrators, HODs, staff, and students.

> **Project type:** Academic / portfolio project

## Features

- Admin login and dashboard
- HOD management
- Staff management
- Student registration, approval, update and deletion
- Student login and profile management
- Attendance marking and viewing
- Marks entry and viewing
- Student performance reports and graphs
- Feedback management
- Notice upload/viewing
- Timetable upload/viewing
- Password update functionality

## Technology Stack

| Layer | Technology |
|---|---|
| Frontend | HTML, CSS, JavaScript, JSP |
| Backend | Java Servlets |
| Database | MySQL |
| Web Server | Apache Tomcat |
| Database Driver | MySQL JDBC |
| Reporting / Charts | JFreeChart, Apache PDFBox, JExcel |
| UI Libraries | Bootstrap, Font Awesome and related frontend libraries |

## Application Modules

### Admin

- Authenticate as administrator
- Add/delete HODs
- Add/delete staff
- Approve/disapprove students
- Manage students and notices

### HOD

- Manage department-level staff and students
- Manage marks and attendance workflows
- Upload notices and timetables
- View student information and reports

### Staff

- View assigned students
- Mark attendance
- Add marks
- View student information
- View notices and timetables

### Student

- Login and view profile
- View attendance
- View marks
- View performance reports/graphs
- View notices and timetable
- Update password

## Database

The project uses a MySQL database named `student_db`. The supplied SQL dump contains these tables:

- `attendance_tbl`
- `dept_tbl`
- `feedback_tbl`
- `marks_tbl`
- `notice_tbl`
- `staff_tbl`
- `student_tbl`
- `timetable_tbl`

## Project Structure

```text
Student-Performance-Analysis/
├── database/
│   └── student_db.sql
├── src/
│   └── main/java/
│       ├── dbconnect/
│       └── servlet/
├── webapp/
│   ├── *.html
│   ├── *.jsp
│   ├── css/
│   ├── fonts/
│   ├── images/
│   └── WEB-INF/web.xml
├── lib/
│   └── *.jar
├── dist/
│   └── Student-Performance-Analysis.war
├── docs/
├── .gitignore
└── README.md
```

## Requirements

- JDK 8 or a compatible Java environment
- Apache Tomcat compatible with the application
- MySQL Server
- MySQL JDBC driver (included in `lib/`)
- A browser

## Database Setup

1. Start MySQL.
2. Create the database:

```sql
CREATE DATABASE student_db;
```

3. Import the supplied database dump:

```bash
mysql -u root -p student_db < database/student_db.sql
```

Alternatively, import `database/student_db.sql` using MySQL Workbench or phpMyAdmin.

## Database Connection

The current application source contains a local MySQL connection configuration in:

```text
src/main/java/dbconnect/ConnectDB.java
```

The original configuration points to:

```text
jdbc:mysql://localhost:3306/student_db
```

Before running the application, change the MySQL username/password in `ConnectDB.java` if your local MySQL installation uses different credentials. **Do not commit real production/database passwords to GitHub.**

## Running the WAR

The repository includes a ready-to-deploy WAR file:

```text
dist/Student-Performance-Analysis.war
```

### Tomcat deployment

1. Install Apache Tomcat.
2. Copy the WAR into Tomcat's `webapps` directory.
3. Start Tomcat.
4. Open the application in a browser using the context path generated from the WAR filename, for example:

```text
http://localhost:8080/Student-Performance-Analysis/
```

If you rename the WAR to `StudentPerformanceAnalysis.war`, the context path becomes:

```text
http://localhost:8080/StudentPerformanceAnalysis/
```

## Source Code

The Java source files extracted from the application are provided under `src/main/java/`. JSP, HTML, CSS, fonts and other web resources are under `webapp/`.

The `dist/` WAR is provided as the packaged deployment artifact.

## Important Security Note

This is an academic project containing sample database records. Before making the repository public, review the SQL dump and source code for sample credentials, personal information, API keys, or other sensitive values. Replace/remove anything that should not be public.

## Current Project Status

The repository contains the newer WAR build supplied for the project. The WAR archive was verified as a valid ZIP/WAR archive. Full end-to-end runtime testing with a configured MySQL server and Tomcat environment is still required before claiming production readiness.

## Author

**Parth Khond**

Computer Engineering Student

- GitHub: https://github.com/Parth4465
- LinkedIn: https://www.linkedin.com/in/parth-khond-7220b7385/

## License

This project is provided for academic and portfolio purposes. Add a specific open-source license if you intend to permit reuse or redistribution.
