package com.ggv.ayurveda;

import java.io.File;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.nio.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Part;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import com.ggv.ayurveda.DBConnection;
import com.ggv.ayurveda.webutils.MessageTemplate;

@MultipartConfig
public class FilesUpload extends HttpServlet 
{
    
    static Connection conn;
    static{
        //Creating Connection
        conn = new DBConnection().getDBConnection();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        //Getting Parameters
        Part img_part = request.getPart("img_file");
        Part pdf_part = request.getPart("pdf_file");

        String com_name = request.getParameter("com_name");
        String sci_name = request.getParameter("sci_name");
        String family = request.getParameter("family");


        //Getting image file extention
        String extention = ".jpg";
        // String temp = img_part.getSubmittedFileName();
        // for(int i = 0 ;i < temp.toString().length(); i++)
        // {
        //     String c_ = ""+ img_part.getSubmittedFileName().toString().charAt(i);
        //     if( c_.equals(".") || extention.contains(".") )
        //     {
        //         extention += c_;
        //     }
        // }

        System.out.print("extention is : "+extention);

        //Image name and PDF name
        String image_name = img_part.getSubmittedFileName();
        String pdf_name = pdf_part.getSubmittedFileName();

        //getting next row count
        int NEXTVAL = 0;
        try{
            String query = "SELECT plant_id.NEXTVAL FROM dual";
            // String query = "insert into ayurveda_db ( id, com_name, sci_name, family, image_name, pdf_name ) values (plant_id.NEXTVAL, ?, ?, ?, image||plant_id.NEXTVAL||"+extention+", pdf||plant_id.NEXTVAL.pdf) ";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                NEXTVAL = rs.getInt(1);
                // out.print(NEXTVAL);
                image_name = "img-"+NEXTVAL+extention;
                pdf_name = NEXTVAL+".pdf";
            }
        }
        catch(Exception e)
        {
            System.out.print("1: "+e);
            
            MessageTemplate errorMsg = new MessageTemplate();
            String template = errorMsg.Message("Error!", "Oops! Something went wrong<br/>"+e, "../admin-menu.jsp", "Ok", "#f44336"); //error->#f44336
            out.println(""+template);
            e.printStackTrace();

            // out.println("1: "+e);
            e.printStackTrace();
        }

        //Saving Image
        {
            String fileName = image_name;
            System.out.println(fileName);
            InputStream is = img_part.getInputStream();
            byte[] data = new byte[is.available()];

            is.read(data);

            String img_path = request.getServletContext().getRealPath("/")+"images"+File.separator+"plants"+File.separator+image_name;
            FileOutputStream fos = new FileOutputStream(img_path);
            fos.write(data);
            System.out.println("Image : "+img_path);

            // out.println("Imaged Saved");
        }

        //Saving PDF
        {
            String fileName = pdf_name;
            System.out.println(fileName);
            InputStream is = pdf_part.getInputStream();
            byte[] data = new byte[is.available()];

            is.read(data);

            String pdf_path = request.getServletContext().getRealPath("/")+"doc"+File.separator+pdf_name;
            FileOutputStream fos = new FileOutputStream(pdf_path);
            fos.write(data);
            System.out.println("PDF : "+pdf_path);

            System.out.println(pdf_path);
            //out.println("PDF Saved");
        }

        try{
            // String query = "SELECT plant_id.NEXTVAL FROM dual";
            String query = "insert into ayurveda_db ( id, com_name, sci_name, family ) values (?, ?, ?, ?) ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, NEXTVAL);
            stmt.setString(2, com_name);
            stmt.setString(3, sci_name);
            stmt.setString(4, family);
            int insert_count = stmt.executeUpdate();
            if(insert_count > 0)
            {
                System.out.print("Inserted Row : "+NEXTVAL);
            }
        }
        catch(Exception e)
        {
            System.out.print("2:"+e);
            // out.println("2:"+e);
            MessageTemplate errorMsg = new MessageTemplate();
            String template = errorMsg.Message("Error!", "Oops! Something went wrong<br/>"+e, "../admin-menu.jsp","Ok", "#f44336"); //error->#f44336
            out.println(""+template);
            e.printStackTrace();
        }

        MessageTemplate successMsg = new MessageTemplate();
        String template = successMsg.Message("Success!", "Your request has been processed.", "../upload-files.jsp", "Ok", "#4CAF50"); //success->#4CAF50
        out.println(""+template);
        out.close();
    }

}
