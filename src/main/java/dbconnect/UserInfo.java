package dbconnect;

public class UserInfo {
static int id;
static String rollno,name,year,branch,email;

public static String getEmail() {
	return email;
}

public static void setEmail(String email) {
	UserInfo.email = email;
}

public static String getRollno() {
	return rollno;
}

public static void setRollno(String rollno) {
	UserInfo.rollno = rollno;
}

public static String getName() {
	return name;
}

public static void setName(String name) {
	UserInfo.name = name;
}

public static String getYear() {
	return year;
}

public static void setYear(String year) {
	UserInfo.year = year;
}

public static String getBranch() {
	return branch;
}

public static void setBranch(String branch) {
	UserInfo.branch = branch;
}

public static int getId() {
	return id;
}

public static void setId(int id) {
	UserInfo.id = id;
}
}
