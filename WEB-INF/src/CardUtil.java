package com.ggv.ayurveda.webutils;

import com.ggv.ayurveda.webutils.ImageCompression;
import java.io.File;

public class CardUtil
{
    public StringBuilder getCard(int id, String comman_name, String family, String sci_name)
    {
        StringBuilder template = new StringBuilder();

        String path;
        String sp = File.separator;
        if(new ImageCompression().compressImg(id))
        {
            //Assigning Compresses Image path
            path = "."+sp+"images"+sp+"plants"+sp+"thumbnails"+sp+"thumb-img-"+id+".jpg";
        }
        else
        {
            //Assigning Original Image path
            path = "."+sp+"images"+sp+"plants"+sp+"img-"+id+".jpg";;
        }
        //template.append("<a href ='/viewer.html?id="+id+"' >");
        template.append("<a href ='Viewer?id="+id+"' >");
        template.append("<span class='h-32 w-auto max-w-5xl flex lg:justify-between justify-start gap-x-10 items-center bg-slate-300 rounded py-1 px-5'>");
        template.append("<img width='110' class='h-28 object-cover' src='"+path+"' loading='lazy'>");
        template.append("<div class='flex flex-col gap-y-2'>");
        template.append("<span id='name'>"+comman_name+"</span>");
        template.append("<span id='family'>Family: "+family+"</span>");
        template.append("<span id='order'>Scientfic Name: "+sci_name+"</span>");
        template.append("</div>");
        template.append("<div class='pl-4 hidden lg:block'>About");
        template.append("<pre class='break-all'>");
        template.append("Malvaceae, or the mallows, is a family of flowering plants estimated </pre>");
        template.append("</div>");
        template.append("</span>");
        template.append("</a>");
        template.append("<br>");

        return template;
    }
}