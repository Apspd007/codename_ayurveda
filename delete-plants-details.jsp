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
    <title>modify plants</title>
    <style>
        *{
            box-sizing: border-box;
        }
    </style>
</head>
<body>
    <div id="UpdateSection">
        <h1 style="text-align: center;">delete Data fields</h1>

    <h1 id="loadingIcon" style="display: none;">Lodinggg.......</h1>

    <diV style="">
        <div style="width: 40%; display: inline-block; text-align: center;">
            <img src="images/white.png" id="myImg" style="width: 150px; height: 200px; border: 5px solid black; border-radius: 5px;" />
        </div>
        
        <div style="width: 50%; display: inline-block;">

            <form id="delete-form" method="post" enctype="multipart/form-data">
                <input type="hidden" id="id" name="id" value="-1" />

                <label for="com_name"><b>Comman Name : </b></label>
                <span id="com_name" name="com_name" ></span><br>


                <label for="sci_name">Scientific Name : </label>
                <span id="sci_name" name="sci_name" ></span><br>

                <label for="family_name">Family Name : </label>
                <span id="family_name" name="family_name" ></span><br>

            
                <label for="deletePdf">PDF : </label>
                <a href="#" target="_blank"  id="deletePdf" name="deletePdf">PDF LOGO</a><br>        
                
                <input type="submit" value="delete" id="deleteButton" disabled required/>
            </form>
        </div>
    </diV>

    </div>
    <hr/>
    <table style="margin: auto; width: 80%;">
        <thead>
            <tr>
                <th colspan="6">
                    <input type="text" id="search_query" style="width: 90%;" placeholder="Search Plants" autocomplete="search_item();" onkeyup="search_item();" oninput="search_item()"/>
                </th>
            </tr>
            <tr>
                <th>Image</th>
                <th>Comman Name</th>
                <th>Scientic Name</th>
                <th>family</th>
                <th>Pdf File</th>
                <th>Select</th>
            </tr>
        </thead>
        <tbody id="results">

        </tbody>
    </table>
    <style>
        tr{
            height: 50px;
        }
        table, tr, th, td{
            border: 2px solid black;
        }

        table, tr, th, td{
            border-collapse: collapse;
        }

        tr:nth-child(even){
            background-color:lightgrey;
        }
    </style>
    <script src="scripts/deleteData.js"></script>
    <script>loadTabs();</script>

    <script>

    </script>
</body>
</html>