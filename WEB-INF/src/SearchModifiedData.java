package com.ggv.ayurveda;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ggv.ayurveda.DBConnection;
import com.ggv.ayurveda.webutils.ModifyTableUtil;

public class SearchModifiedData extends HttpServlet
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
            

            //Getting Query Parameter
            String search = req.getParameter("search");
            if(search.equals("") || search == null || search == "" || search.trim().equals("") || search.trim() == "")
            {

                com.ggv.ayurveda.LoadModifyTable defaultData = new com.ggv.ayurveda.LoadModifyTable();
                defaultData.doGet(req, res);
                return;
            }
            
            //Searching Query Parameter
            String query = "select * from ayurveda_db where upper(com_name) like upper('%"+search+"%') OR upper(sci_name) like upper('%"+search+"%') OR upper(family) like upper('%"+search+"%') ";
            System.out.println(query);
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            
            boolean avaibleData = rs.next();

            if(!avaibleData)
            {
                out.println("Data not Available...");
            }        
            //Creating Card Template
            StringBuilder rowTemplate = new StringBuilder();

            for(int i = 1; avaibleData; i++)
            {
                //Assigning Cards to Card Template
                ModifyTableUtil row = new ModifyTableUtil();
                StringBuilder rows = row.getRow(rs.getInt("ID"), rs.getString("COM_NAME"), rs.getString("Family"), rs.getString("SCI_NAME"));

                rowTemplate.append(rows);

                //Checking for next Data
                avaibleData = rs.next();
            }

            //Sending card template data
            out.println(rowTemplate);
        }
        catch(Exception e)
        {
            System.out.println("Error : "+e);
            out.println("No result found");

            //Showing Default Data 
            com.ggv.ayurveda.LoadModifyTable defaultData = new com.ggv.ayurveda.LoadModifyTable();
            defaultData.doGet(req, res);
        }
    }
}