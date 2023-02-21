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

//For Database Connectivity
import com.ggv.ayurveda.DBConnection;

//For Image Compression
import java.io.File;
import com.ggv.ayurveda.webutils.ImageCompression;


@MultipartConfig
public class DeleteModifiedData extends HttpServlet 
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

        //Getting Parameter
        String id = request.getParameter("id");

        if(id == null || id.equals(""))
        {
            return;
        }

        //Image name and PDF name
        String image_name ="img-"+id+".jpg";// = img_part.getSubmittedFileName();
        String thumb_image_name = "thumb-img-"+id+".jpg";
        String pdf_name = id+".pdf";// pdf_part.getSubmittedFileName();
        File file;
        boolean isDeleted;

        //Deleting Image
        String img_path = request.getServletContext().getRealPath("/")+"images"+File.separator+"plants"+File.separator+image_name;
        file = new File(img_path);
        isDeleted = file.delete();
        if (isDeleted) {
            System.out.println("Image File deleted successfully.");
        } else {
            System.out.println("File could not be deleted.");
        }
        

        //Deleting Thubmnail Image
        String thumb_Img_Path = request.getServletContext().getRealPath("/")+"images"+File.separator+"plants"+File.separator+"thumbnails"+File.separator+"thumb-"+image_name;
        file = new File(thumb_Img_Path);
        isDeleted = file.delete();
        if (isDeleted) {
            System.out.println("Thumbnail File deleted successfully.");
        } else {
            System.out.println("File could not be deleted.");
        }
        
        //Deleting PDF
        String pdf_path = request.getServletContext().getRealPath("/")+"docs"+File.separator+pdf_name;
        file = new File(pdf_path);
        isDeleted = file.delete();
        if (isDeleted) {
            System.out.println("Thumbnail File deleted successfully.");
        } else {
            System.out.println("File could not be deleted.");
        }


        try{
            String query = "delete from ayurveda_db where id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            int deleted_row = stmt.executeUpdate();
            if(deleted_row > 0)
            {
                System.out.print("Deleted Row : "+deleted_row);
            }
        }
        catch(Exception e)
        {
            System.out.print(e);
            e.printStackTrace();
        }
        
        out.write("Data Deleted");
        response.setStatus(HttpServletResponse.SC_OK);
        out.close();
    }

}
