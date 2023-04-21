package com.ggv.ayurveda;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;

import java.io.PrintWriter;
import java.io.IOException;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Viewer extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        try{
            //Getting Parameter Value
            int id = Integer.parseInt(req.getParameter("id").trim());

            
            // ServletContext context=getServletContext();

            // //Setting Searched Attribute 
            // String recentSearch = (String)context.getAttribute("RecentSearch");

            // //Check Null or not
            // if(recentSearch == null)
            // {
            //     recentSearch = "&" + id;
            // }
            // else if(recentSearch.contains(""+id)) {
            //     //Adding Searched item to Recent Search
            //     recentSearch = recentSearch.replace("&"+id, "");
            //     recentSearch = "&" + id + recentSearch;
            // } else
            //     recentSearch = "&" + id + recentSearch;

            // //Adding on Searched Attribute
            // context=getServletContext();  
            // context.setAttribute("RecentSearch",recentSearch); 

            //Including Pdf Viewer Page
            // RequestDispatcher rd = req.getRequestDispatcher("doc/viewer.html?id="+id);
            // rd.forward(req, res);

            // res.sendRedirect("viewer.html?id="+id);  
            res.sendRedirect("doc/viewer.html?id="+id);  
        }
        catch(Exception e)
        {
            //Forward to Error Page
            System.out.println(e.toString());
        }
    }
}