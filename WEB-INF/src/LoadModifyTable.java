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
import com.ggv.ayurveda.webutils.ModifyTableUtil;

public class LoadModifyTable extends HttpServlet
{
    static Connection conn;
    static{
        //Creating Connection
        conn = new DBConnection().getDBConnection();
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from ayurveda_db");

            //Creating table template
            StringBuilder tableTemplate = new StringBuilder();

            while(rs.next())
            {
                //Assigning Cards to Card template
                ModifyTableUtil row = new ModifyTableUtil();
                StringBuilder rows = row.getRow(rs.getInt("ID"), rs.getString("COM_NAME"), rs.getString("Family"), rs.getString("SCI_NAME"));

                tableTemplate.append(rows);
                //out.println(cards);
            }

            //Sending Table template data
            out.println(tableTemplate);
        }
        catch(Exception e)
        {
            out.println("Error : "+e);
        }
    }
}