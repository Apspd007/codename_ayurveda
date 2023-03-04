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
        <h1 style="text-align: center;">Update Data fields</h1>

    <h1 id="loadingIcon" style="display: none;">Lodinggg.......</h1>

    <diV style="">
        <div style="width: 40%; display: inline-block; text-align: center;">
            <img src="images/white.png" id="myImg" style="width: 150px; height: 200px; border: 5px solid black; border-radius: 5px;" />
        </div>
        
        <div style="width: 50%; display: inline-block;">

            <form id="upload-form" method="post" enctype="multipart/form-data">
                <input type="hidden" id="id" name="id" value="-1" />

                <label for="com_name">Comman Name : </label>
                <input type="text" placeholder="Comman Name" id="com_name" name="com_name" disabled required/><br><br>


                <label for="sci_name">Scientific Name : </label>
                <input type="text" placeholder="Scientic Name" id="sci_name" name="sci_name" disabled required/><br><br>

                <label for="family_name">Family Name : </label>
                <input type="text" placeholder="Family Name" id="family_name" name="family_name" disabled required/><br><br>

                <label for="updateImage">Update Image</label>
                <input type="file" id="updateImage" name="updateImage" accept=".jpg, .jpeg" /><br><br/>

                <label for="updatePdf">Update PDF</label>
                <input type="file" id="updatePdf" name="updatePdf" accept=".pdf" /><br><br/>        
                
                <input type="submit" value="update" id="updateButton" disabled required/>
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
    <script src="scripts/loadUpdateTable.js"></script>
    <script>loadTabs();</script>
</body>
</html>