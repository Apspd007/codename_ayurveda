package com.ggv.ayurveda.authentication;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.io.IOException;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import com.ggv.ayurveda.DBConnection;

public class CheckLogin extends HttpServlet
{
    static Connection conn;
    static{
        //Creating Connection
        conn = new DBConnection().getDBConnection();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try{

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // You can add your own logic to check the username and password against a database or file
            // For now, we will just check if the username is "admin" and the password is "password"
            if (username.equals("admin") && password.equals("password")) 
            {
                System.out.println("Successfully Login");
                
                HttpSession session = request.getSession();
                session.setAttribute("username", username);

                response.sendRedirect("admin-menu.jsp");

            } else {

                out.print("Invalid Id and Password");
                //response.sendRedirect("error.jsp");

            }
        }
        catch(Exception e)
        {
            out.print("Error is "+e);
        }
    }
}