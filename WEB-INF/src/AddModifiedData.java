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
public class AddModifiedData extends HttpServlet 
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
        Part img_part = request.getPart("updateImage");
        Part pdf_part = request.getPart("updatePdf");

        String id = request.getParameter("id");
        String com_name = request.getParameter("com_name");
        String sci_name = request.getParameter("sci_name");
        String family = request.getParameter("family_name");

        if(id == null || id.equals("") ||com_name == null || com_name.equals("") ||sci_name == null || sci_name.equals("") ||family == null || family.equals(""))
        {
            return;
        }


        //Getting image file extention
        String extention = "";
        String temp = img_part.getSubmittedFileName();
        for(int i = 0 ;i < temp.toString().length(); i++)
        {
            String c_ = ""+ img_part.getSubmittedFileName().toString().charAt(i);
            if( c_.equals(".") || extention.contains(".") )
            {
                extention += c_;
            }
        }

        System.out.print("extention is : "+extention);

        //Image name and PDF name
        String image_name ="";// = img_part.getSubmittedFileName();
        String pdf_name = "";// pdf_part.getSubmittedFileName();
        if(img_part != null)
        {
            image_name = img_part.getSubmittedFileName();
        }
        if(pdf_part != null)
        {
            pdf_name = pdf_part.getSubmittedFileName();
        }

        //getting next row count
        // int NEXTVAL = 0;
        // try{
        //     String query = "SELECT plant_id.NEXTVAL FROM dual";
        //     // String query = "insert into ayurveda_db ( id, com_name, sci_name, family, image_name, pdf_name ) values (plant_id.NEXTVAL, ?, ?, ?, image||plant_id.NEXTVAL||"+extention+", pdf||plant_id.NEXTVAL.pdf) ";
        //     PreparedStatement stmt = conn.prepareStatement(query);
        //     ResultSet rs = stmt.executeQuery();
        //     if(rs.next())
        //     {
        //         NEXTVAL = rs.getInt(1);
        //         out.print(NEXTVAL);
        //         image_name = "img-"+NEXTVAL+extention;
        //         pdf_name = NEXTVAL+".pdf";
        //     }
        // }
        // catch(Exception e)
        // {
        //     System.out.print("1: "+e);
        //     out.println("1: "+e);
        //     e.printStackTrace();
        // }


        //Saving Image
        out.println(img_part+"<br>");
        out.println("Name is : "+img_part.getSubmittedFileName()+"<br>");
        if(img_part != null && img_part.getSize() > 0)
        {
            image_name = "img-"+id+".jpg";
            String fileName = image_name;
            System.out.println(fileName);
            InputStream is = img_part.getInputStream();
            byte[] data = new byte[is.available()];

            is.read(data);

            String img_path = request.getServletContext().getRealPath("/")+"images"+File.separator+"plants"+File.separator+image_name;
            FileOutputStream fos = new FileOutputStream(img_path);
            fos.write(data);
            System.out.println("Image : "+img_path);

            out.println("Imaged Saved");

            //Image Compression
            String thumb_Img_Path = request.getServletContext().getRealPath("/")+"images"+File.separator+"plants"+File.separator+"thumbnails"+File.separator+"thumb-"+image_name;
            System.out.print(thumb_Img_Path);
            File file = new File(thumb_Img_Path);
            boolean deleted = file.delete();
            if (deleted) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("File could not be deleted.");
            }

            int id_ = Integer.parseInt(id.trim());
            boolean is_Image_Compressed = new com.ggv.ayurveda.webutils.ImageCompression().compressImg(id_);
            if(is_Image_Compressed)
                System.out.println("Image is Compressed");
            else   
                System.out.println("Image is not Compressed");
        }

        //Saving PDF
        out.println("pdf part : "+pdf_part+"<br>");
        out.println("Pdf is : "+pdf_part.getSubmittedFileName()+"<br>");
        if(pdf_part != null && pdf_part.getSize() > 0 )
        {
            pdf_name = id+".pdf";
            String fileName = pdf_name;
            System.out.println(fileName);
            InputStream is = pdf_part.getInputStream();
            byte[] data = new byte[is.available()];

            is.read(data);

            String pdf_path = request.getServletContext().getRealPath("/")+"docs"+File.separator+pdf_name;
            FileOutputStream fos = new FileOutputStream(pdf_path);
            fos.write(data);
            System.out.println("PDF : "+pdf_path);

            System.out.println(pdf_path);
            out.println("PDF Saved");
        }

        try{
            // String query = "SELECT plant_id.NEXTVAL FROM dual";
            String query = "update ayurveda_db SET com_name = ?, sci_name = ?, family = ? where id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, com_name);
            stmt.setString(2, sci_name);
            stmt.setString(3, family);
            stmt.setString(4, id);
            int updated_row = stmt.executeUpdate();
            if(updated_row > 0)
            {
                System.out.print("Updated Row : "+updated_row);
            }
        }
        catch(Exception e)
        {
            System.out.print("2:"+e);
            out.println("2:"+e);
            e.printStackTrace();
        }
        out.write("Successfully Modified");
        response.setStatus(HttpServletResponse.SC_OK);
        out.close();
    }

}
