<!-- Auth System -->
<%

    //Checking Session

    if(session.getAttribute("username") == null ) 
    {
        response.sendRedirect("admin.jsp");
    }
    
    HttpSession session_ = request.getSession(false);
    if (session_ == null || session_.equals("null")) {
        session_ = request.getSession();
        if( session_ == null || session_.equals("null"))
        {
            response.sendRedirect("admin.jsp");
        }
    }

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Menu</title>
</head>
<body>
    <div>
        <a href="upload-files.jsp"><button>Add Plants</button></a>
        <a href="modify-plants-details.jsp"><button>Modify Plants</button></a>
        <a href="delete-plants-details.jsp"><button>Delete Plants</button></a>
        <button onclick="clearSession()">Log out</button>
    </div>

    <script src="scripts/aoth_system.js"></script>
</body>
</html>