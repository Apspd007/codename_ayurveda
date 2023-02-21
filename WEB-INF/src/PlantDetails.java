import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.PrintWriter;

class PlantsInfo {
    String sciName, commanName, rank, family, about;

    PlantsInfo(String sciName, String commanName, String rank, String family, String about) {
        this.sciName = sciName;
        this.commanName = commanName;
        this.rank = rank;
        this.family = family;
        this.about = about;
    }
}

public class PlantDetails extends HttpServlet {
    void addPlants(ArrayList<PlantsInfo> plants) {
        plants.add(new PlantsInfo("Ocimum tenuiflorum", "Holy Basil", "Species", "Lamiaceae",
                "Ocimum tenuiflorum, commonly known as holy basil, tulsi or tulasi, is an aromatic perennial plant in the family Lamiaceae. It is native to the Indian subcontinent and widespread as a cultivated plant throughout the Southeast Asian tropics"));
        plants.add(new PlantsInfo(" Withania somnifera", "Ashwagandha", "Species", "Solanaceae",
                "Withania somnifera, known commonly as ashwagandha or winter cherry, is an evergreen shrub in the Solanaceae or nightshade family that grows in India, the Middle East, and parts of Africa. Several other species in the genus Withania are morphologically similar."));
        plants.add(new PlantsInfo("Curcuma Longa", "Turmeric", "Genus", "Zingiberaceae",
                "Curcuma is a genus of plants in the family Zingiberaceae that contains such species as turmeric and Siam tulip. They are native to Southeast Asia, southern China, the Indian Subcontinent, New Guinea and northern Australia."));
        plants.add(new PlantsInfo("Foeniculum Vulgare", "Saunf", "Species", "Umbellifers",
                "Fennel or Saunf is a flowering plant species in the carrot family. It is a hardy, perennial herb with yellow flowers and feathery leaves. It is indigenous to the shores of the Mediterranean but has become widely naturalized in many parts of the world, especially on dry soils near the sea-coast and on riverbanks."));
        plants.add(new PlantsInfo("Asparagus Racemosus", "Shatavari", "Species", "Asparagaceae",
                "Asparagus racemosus is a species of asparagus common throughout India and the Himalayas. and northern Australia. It grows 1–2 m tall and prefers to take root in gravelly, rocky soils high up in piedmont plains, at 1,300–1,400 m elevation. It was botanically described in 1799."));
        plants.add(new PlantsInfo("Brassica Nigra", "Sarson", "Species", "Brassicaceae",
                "Brassica nigra, or black mustard, is an annual plant cultivated for its dark-brown-to-black seeds, which are commonly used as a spice. It is native to tropical regions of North Africa, temperate regions of Europe, and parts of Asia."));
    }

    int searchPlant(ArrayList<PlantsInfo> plants, String commanName)
    {
        int i = -1;
        for(i = 0; i < plants.size(); i++)
        {
            if(commanName.trim().equalsIgnoreCase(plants.get(i).commanName.trim())) return i;
        }
        if(i > plants.size()) return -1;
        return i;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<PlantsInfo> plants = new ArrayList<PlantsInfo>();

        //addPlant
        addPlants(plants);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/plant-details.html");
        requestDispatcher.include(req, resp);

        //getting parameter value
        String commanName = req.getParameter("plant");

        //serching for right parameter
        int getDataIndex = searchPlant(plants, commanName);

        //if parameter is wrong
        //if(getDataIndex == -1) resp.sendRedirect("index.html");

        //Writing Response
        // PrintWriter out = resp.getWriter();
        // out.print("<script>");
        // out.print("scientificName_ = "++";");
        
        // out.print("commonName_ = "+plants.get(getDataIndex).commanName+";");
        // out.print("rank_ = "+plants.get(getDataIndex).rank+";");
        // out.print("familyName_ = "+plants.get(getDataIndex).family+";");
        // out.print("aboutPlant_ = "+plants.get(getDataIndex).about+";");
        // out.print("</script>");
    }
}