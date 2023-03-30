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

public class OnPageLoad extends HttpServlet
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
            // ResultSet rs = stmt.executeQuery("select * from ayurveda_db OFFSET 10 ROWS FETCH NEXT 10 ROWS ONLY");

            //checking offset is null or not
            String offset = req.getParameter("offset");
            offset = offset != null ? offset : "0";
            System.out.println("offset is"+offset);

            //Setting Offset Limit
            int offsetStarting  = Integer.parseInt(offset.trim()); //adding next row
            int offsetEnding = offsetStarting + 10; //Adding next 10 row  ////////////////////change here
            System.out.println("offsetStarting : "+offsetStarting+" , offsetEnding : "+offsetEnding);

            //Creating card template
            StringBuilder cardTemplate = new StringBuilder();


            for(int i = 1; i <= 10 && rs.next() ; i++)
            {
                //Assigning Cards to Card template
                CardUtil card = new CardUtil();
                StringBuilder cards = card.getCard(rs.getInt("ID"), rs.getString("COM_NAME"), rs.getString("Family"), rs.getString("SCI_NAME"));

                cardTemplate.append(cards);
                //out.println(cards);
            }

            //Adding Load More Data button
            cardTemplate.append("<input type='hidden' name='rownum' id='rownum' value='"+offsetEnding+"'/>");

            //Sending Card template data
            out.println(cardTemplate);
        }
        catch(Exception e)
        {
            out.println("Error : "+e);
        }
    }
}