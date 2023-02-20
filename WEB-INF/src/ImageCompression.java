package com.ggv.ayurveda.webutils;

//Necessary Packages for Image compression
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;
import javax.imageio.*;
import javax.imageio.stream.*;

import java.io.File;

public class ImageCompression
{
    boolean compressImg(int id)
    {
        String sp = File.separator;
        String currentPath = System.getProperty("user.dir");
        System.out.println(currentPath);

        currentPath += sp+"webapps"+sp+"codename-ayurveda"+sp;
        String compressed_img_path = currentPath+"images"+sp+"plants"+sp+"thumbnails"+sp+"thumb-img-"+id+".jpg";
        String original_img_path = currentPath+"images"+sp+"plants"+sp+"img-"+id+".jpg";
        
        System.out.println("compressed path : "+compressed_img_path);
        System.out.println("original path : "+original_img_path);
        try
        {
            File f = new File(compressed_img_path);
            if(f.exists())
            {
                return true;       
            }
            else
            {
                throw new FileNotFoundException("File not found");
            }
        }
        catch(FileNotFoundException f)
        {

            try{
                File input = new File(original_img_path);
                BufferedImage image = ImageIO.read(input);
                

                File compressedImageFile = new File(compressed_img_path);
                OutputStream os = new FileOutputStream(compressedImageFile);

                Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
                ImageWriter writer = (ImageWriter) writers.next();

                ImageOutputStream ios = ImageIO.createImageOutputStream(os);
                writer.setOutput(ios);

                ImageWriteParam param = writer.getDefaultWriteParam();

                param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                param.setCompressionQuality(0.05f); // 0.05f  // Change the quality value you prefer
                System.out.println("Nothing is Printing : "+param.isCompressionLossless());
                writer.write(null, new IIOImage(image, null, null), param);

                os.close();
                ios.close();
                writer.dispose();
                
                return true;
            }
            catch(Exception e)
            {
                System.out.println("Error is : "+e);
                return false;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
}