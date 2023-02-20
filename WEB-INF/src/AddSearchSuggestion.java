package com.ggv.ayurveda;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import com.ggv.ayurveda.DBConnection;
import com.ggv.ayurveda.webutils.CardUtil;

public class AddSearchSuggestion extends HttpServlet
{
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try
        {
            //Creating Connection
            Connection conn;
            conn = new DBConnection().getDBConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select distinct( COM_NAME ) name from ayurveda_db");

            //Creating card template
            StringBuilder dataList = new StringBuilder();

            //Appending Comman Name
            while(rs.next())
            {
                dataList.append("<option value='"+rs.getString("name")+"'>");
                System.out.println(dataList);
            }

            //Appending Scientific Name
            rs = stmt.executeQuery("select distinct( SCI_NAME ) s_name from ayurveda_db");
            while(rs.next())
            {
                dataList.append("<option value='"+rs.getString("s_name")+"'>");
                System.out.println(dataList);
            }

            //Appending Family Name
            rs = stmt.executeQuery("select distinct( family ) f_name from ayurveda_db");
            while(rs.next())
            {
                dataList.append("<option value='"+rs.getString("f_name")+"'>");
                // System.out.println(dataList);
            }

            //Sending Card template data
            out.println(dataList);
        }
        catch(Exception e)
        {
            out.println("Error : "+e);
        }
    }
}