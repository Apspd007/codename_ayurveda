<%@page import="java.sql.*"%>

<%
String username = request.getParameter("username");
String password = request.getParameter("password");

/*String dbUrl = "jdbc:mysql://localhost:3306/test";
String dbUsername = "root";
String dbPassword = "root";*/

try{

	/*Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery("select * from users where username='"+username+"' and password='"+password+"'");
	if(rs.next()){
		session.setAttribute("username", username);
		out.print("success");
    }*/

    if( username.equals("admin") && password.equals("password") )
    {
        
        //Saving Id and Password
        session.setAttribute("username", username);

        out.println("success");
        //response.sendRedirect("admin-menu.jsp");
    }
	else{
		out.print("Invalid username or password!");
	}

	//conn.close();
}
catch(Exception e){
	out.print("Error occurred while processing login request!");
}

%>
