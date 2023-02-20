package com.ggv.ayurveda;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletContext;

import java.io.PrintWriter;
import java.io.IOException;

public class DisplayRecentSearch extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        try{
            res.setContentType("text/html");
            PrintWriter out = res.getWriter();

            ServletContext context=getServletContext();
            String recentSearch = (String)context.getAttribute("RecentSearch");

            /*if(recentSearch == null)
            {
                System.out.println("Opps You Searched Nothing...");
                out.println("Opps You Searched Nothing...");
                return;
            }
            //Setting Searched Attribute 
            String[] searchList = recentSearch.split("&");
            StringBuilder searchListCard = new StringBuilder();

            searchListCard.append("<ul>");
            for(String i : searchList)
                searchListCard.append("<li>"+i+"</li>");
            searchListCard.append("</ul>");

            out.println(searchListCard.toString()+" hjhjhj");
            System.out.println(searchListCard.toString()+" : "+searchList);
            */
        }
        catch(Exception e)
        {

        }
    }
}