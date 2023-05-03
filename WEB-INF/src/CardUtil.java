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
        
        template.append("                    <div class='row mx-sm-5 mx-0 mt-2'>");
        template.append("                        <div class='col-md-8 col-sm-12 col-12'>");
        template.append("                            <div class='card-x container-fluid'>");
        template.append("                                <div class='row'>");
        template.append("                                    <div class='col-md-4 col-sm-3 col-12'>");
        template.append("                                        <img src='"+path+"' class='img-height img-fluid' alt=''>");
        template.append("                                    </div>");
        template.append("                                    <div class='col-md-8 col-sm-9 col-12' style='line-height: 30px;'>");
        template.append("                                        <h1 class='text-ctr' style='line-height: 40px;'><b>Comman Name :</b> "+comman_name+"</h1>");
        template.append("                                        <h1 class='text-ctr' style='line-height: 40px;'><b>Scientific Name : </b>"+sci_name+"</h1>");
        template.append("                                        <div class='d-grid gap-2 mt-4'>");
        template.append("                                            <a href='Viewer?id="+id+"' class='btn btn-primary' style='color:blue;' type='button'>See Details</a>");
        template.append("                                        </div>");
        template.append("                                    </div>");
        template.append("                                </div>");
        template.append("                            </div>");
        template.append("                        </div>");
        template.append("                    </div><br>");

        // template.append("<div class='card' style='max-width: 540px;'>");
        // template.append("  <div class='row g-2 gx-2 row-cols-1'>");
        // template.append("    <div class='col-md-4'>");
        // template.append("      <img src='"+path+"'  class='rounded-start img-thumb' alt='...'>");
        // template.append("    </div>");
        // template.append("    <div class='col-md-8'>");
        // template.append("      <div class='card-body'>");
        // template.append("        <h5 class='card-title' style:'text-align:center;><b>Comman Name : </b>"+comman_name+"</h5>");
        // template.append("        <p class='card-text' style:'text-align:center;><b>Scitntific Name : </b>"+sci_name+"</p>");
        // template.append("        <a href='Viewer?id="+id+"' class='btn btn-primary' style:'text-align:center; margin:auto;'>See details</a>");
        // template.append("      </div>");
        // template.append("    </div>");
        // template.append("  </div>");
        // template.append("</div>");
        

        // template.append("<div class='col-sm-6 col-md-6 col-lg-6 col-12'>");
        // template.append("<div class='card'>");
        // template.append("<img src='"+path+"' class='card-img-top img-thumb'/>");
        // template.append("<div class='card-body'>");
        // template.append("<h5 class='card-title' style:'text-align:center;'> Comman Name : "+comman_name+"</h5>");
        // template.append("<p class='card-text' style:'text-align:center;'>Scientific Name: "+sci_name+"</p>");
        // template.append("<a href='Viewer?id="+id+"' class='btn btn-primary' style:'text-align:center;'>See details</a>");
        // template.append("</div>");
        // template.append("</div>");
        // template.append("</div>");

        // template.append("<a href ='/viewer.html?id="+id+"' >");
        // template.append("<a href ='Viewer?id="+id+"' >"); //using 
        // template.append("<span class='flex flex-col justify-between gap-y-10 items-center bg-slate-300 rounded p-4'>");
        // template.append("<img width='110' class='h-28 object-cover' src='"+path+"' loading='lazy'>");
        // template.append("<div class='flex flex-col justify-center gap-y-2'>");
        // template.append("<span id='name'>"+comman_name+"</span>");
        // template.append("<span id='family'>Family: "+family+"</span>");
        // template.append("<span id='order'>Scientfic Name: "+sci_name+"</span>");
        // template.append("</div>");
        // template.append("<div class='pl-4 hidden lg:block'>About");
        // template.append("<p class='break-all'>");
        // template.append("Malvaceae, or the mallows, is a family of flowering plants estimated </p>");
        // template.append("</div>");
        // template.append("</span>");
        
        // template.append("</a>");
        // template.append("<br>");

        return template;
    }
}