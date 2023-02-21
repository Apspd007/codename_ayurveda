package com.ggv.ayurveda.webutils;

import java.io.File;

public class ModifyTableUtil
{
    public StringBuilder getRow(int id, String comman_name, String family, String sci_name)
    {
        StringBuilder template = new StringBuilder();

        String sp = File.separator;
        String thumbImagePath = "images"+sp+"plants"+sp+"thumbnails"+sp+"thumb-img-"+id+".jpg";

        template.append("<tr>");

            template.append("<td style='text-align:center;'>");
                template.append("<img src='"+thumbImagePath+"'  style='width: 70px; height: 100px;'/>");
            template.append("</td>");
        
            template.append("<td>");
                template.append(comman_name);
            template.append("</td>");
        
            template.append("<td>");
                template.append(sci_name);
            template.append("</td>");
            
            template.append("<td>");
                template.append(family);
            template.append("</td>");

            template.append("<td>");
                template.append("<a href='Viewer?id="+id+"' target='_blank'>pdf logo</a>");
            template.append("</td>");


            String imagePath = "images"+sp+"plants"+sp+"img-"+id+".jpg";
            String pdfPath = "docs"+sp+id+".pdf";

            //loadData(id, com_name, sci_name, family_name, img, pdf)
            String parameters = "loadData( "+id+" , '"+comman_name+"' , '"+sci_name+"' , '"+family+"' , '"+imagePath+"' , '"+pdfPath+"' )";

            template.append("<td>");
                template.append("<button onclick=\""+parameters+"\">");
                    template.append("open file logo");
                template.append("</button>");
            template.append("</td>");

        
        template.append("</tr>");

        return template;
    }
}