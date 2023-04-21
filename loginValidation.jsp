<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>

<%
String username = request.getParameter("username");
String password = request.getParameter("password");

/*String dbUrl = "jdbc:mysql://localhost:3306/test";
String dbUsername = "root";
String dbPassword = "root";*/

try{

	/* No Database Connectivity.............. */
	/*Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery("select * from users where username='"+username+"' and password='"+password+"'");
	if(rs.next()){
		session.setAttribute("username", username);
		out.print("success");
    }*/

	System.out.println("User directory is : "+System.getProperty("user.dir"));
	String sp = System.getProperty("file.separator");
	//String Path = System.getProperty("user.dir")+sp+"webapps"+sp+"codename-ayurveda"+sp+"inf"+sp+"users.txt";
	String Path = System.getProperty("user.dir")+sp+"webapps"+sp+"ROOT"+sp+"inf"+sp+"users.txt";

	//Reading users in files
	FileReader fr = new FileReader(Path);
	BufferedReader br = new BufferedReader(fr);

	String line;
	boolean loginFailed = true;
	while( ( line = br.readLine() ) != null )
	{
		
		String[] auth = line.split(",");

		//if(auth.length() < 2) continue; //auth[0] -> username, auth[1] -> password

		if( username.equals( auth[0].trim() ) && password.equals( auth[1].trim() ) )
		{
			
			//Saving Id and Password
			session.setAttribute("username", username);
	
			out.println("success");
			//response.sendRedirect("admin-menu.jsp");
			
			loginFailed = false;

			break;
		}

	}


	if(loginFailed)
	{
		out.print("Invalid username or password!");
	}

	//conn.close();
}
catch(Exception e){
	out.print("Error occurred while processing login request!");
	System.out.println(e);
}

%>
