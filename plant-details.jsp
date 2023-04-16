<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans&family=Lora&family=Montserrat&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="style.css">
    <link rel="shortcut icon" href="images/ggu-logo.png" type="image/x-icon">
    <title>Ayurveda</title>
</head>

<!--<body onload="init()">-->
<body onload="">
    <script>var scientificName_, commonName_, rank_, familyName_, aboutPlant_;</script>
    <!-- mobile and tablet header -->
    <section class="lg:hidden flex flex-col w-full bg-white border-b gap-y-4">
        <header class=" w-full px-10 flex justify-between items-center md:flex-row flex-col gap-y-4">
            <div onclick="blankRedirect('https://www.ggu.ac.in/')" class="cursor-pointer"><img
                    class="max-h-[70px] object-cover" src="images/ggu-image.png"></div>
            <div onclick="blankRedirect('https://aiia.gov.in/')" class="cursor-pointer"><img
                    class="max-h-[60px] object-cover" src="images/aiia-image.png"></div>
        </header>

        <!-- Logo and navigation -->
        <div class="flex justify-end bg-white items-end">
            <nav class=" flex w-min items-center self-end justify-end gap-x-7 py-1 pl-14 px-10">
                <div
                    class="nav-font-size cursor-pointer px-2 py-1 font-medium tracking-wide hover:bg-gray-300 rounded ease-in duration-200">
                    Home</div>
                <div
                    class="nav-font-size cursor-pointer px-2 py-1 font-medium tracking-wide hover:bg-gray-300 rounded ease-in duration-200">
                    About</div>
                <div
                    class="nav-font-size cursor-pointer px-2 py-1 font-medium tracking-wide hover:bg-gray-300 rounded ease-in duration-200">
                    Academic</div>
                <div
                    class="nav-font-size cursor-pointer px-2 py-1 font-medium tracking-wide hover:bg-gray-300 rounded ease-in duration-200">
                    Administration</div>
            </nav>
        </div>

    </section>

    <section class="hero-section h-[70vh] sm:h-[80vh] md:h-screen flex flex-col">
        <!-- header -->
        <section class="hidden header-section h-[160px] lg:flex flex-col justify-between">

            <header class="w-full h-[90px] px-10 flex justify-between items-center ">
                <div onclick="blankRedirect('https://www.ggu.ac.in/')" class="cursor-pointer"><img
                        class="2xl:h-[90px] max-h-[90px] object-cover" src="images/ggu-image.png"></div>
                <img class="h-28 object-cover cursor-pointer" onclick="redirectHome()" src="images/gg.png">
                <div onclick="blankRedirect('https://aiia.gov.in/')" class="cursor-pointer"><img
                        class="2xl:h-[90px] max-h-[90px] object-cover" src="images/aiia-image.png"></div>
            </header>

            <!-- Logo and navigation -->
            <div class="flex justify-between items-end">
                <span class="xl:ml-[12%]">
                    <img src="images/ayurveda-logo.png" alt="Ayurveda Logo" width="250" height="60">
                </span>
                <nav class=" flex w-min items-center self-end justify-end gap-x-7 py-1 pl-14 px-10">
                    <div onclick="redirectHome()"
                        class="cursor-pointer px-2 py-1 text-xl font-medium tracking-wide hover:bg-gray-300 rounded ease-in duration-200">
                        Home</div>
                    <div
                        class="cursor-pointer px-2 py-1 text-xl font-medium tracking-wide hover:bg-gray-300 rounded ease-in duration-200">
                        About</div>
                    <div
                        class="cursor-pointer px-2 py-1 text-xl font-medium tracking-wide hover:bg-gray-300 rounded ease-in duration-200">
                        Academic</div>
                     <div>
                        <button id="menu-administration"
                            class="peer nav-font-size cursor-pointer px-2 py-1 font-medium tracking-wide hover:bg-gray-300 rounded ease-in duration-200">
                            Administration
                        </button>
                        <!-- the menu here -->
                        <div id="menu-item-administration" class="hidden peer-hover:grid hover:grid grid-flow-row
                     bg-white drop-shadow-lg absolute z-10">
                            <a class="px-5 py-3 hover:bg-gray-200" href="nav-pages/visitor.html">Visitor</a>
                            <a class="px-5 py-3 hover:bg-gray-200" href="nav-pages/chancellor.html">Chancellor</a>
                            <a class="px-5 py-3 hover:bg-gray-200" href="nav-pages/vice-chancellor.html">Vice
                                Chancellor</a>
                            <a class="px-5 py-3 hover:bg-gray-200" href="nav-pages/registrar.html">Registrar</a>
                        </div>
                    </div>
                </nav>
            </div>
        </section>
        <!-- header end -->

        
        <!--JSP Code-->
            <%!
                public final int searchPlant(String[] plants_CommanName_, String commanName_)
                {
                    int i = -1;
                    for(i = 0; i < plants_CommanName_.length; i++)
                    {
                        if(commanName_.trim().equalsIgnoreCase(plants_CommanName_[i].trim())) return i;
                    }
                    if(i > plants_CommanName_.length) return -1;
                    return i;

                }
            %>
            <%

                String[] plants_Sci = {"Ocimum tenuiflorum", " Withania somnifera", "Curcuma Longa", "Foeniculum Vulgare", "Asparagus Racemosus", "Brassica Nigra"};
                String[] plants_CommanName = {"Holy Basil", "Ashwagandha","Turmeric", "Saunf", "Shatavari", "Sarson"};
                String[] plants_rank = {"Species", "Species", "Genus", "Species", "Species", "Species"};
                String[] plants_family = {"Lamiaceae", "Solanaceae", "Zingiberaceae", "Umbellifers", "Asparagaceae", "Brassicaceae"};
                String[] plants_about = {
                    "Ocimum tenuiflorum, commonly known as holy basil, tulsi or tulasi, is an aromatic perennial plant in the family Lamiaceae. It is native to the Indian subcontinent and widespread as a cultivated plant throughout the Southeast Asian tropics",
                    "Withania somnifera, known commonly as ashwagandha or winter cherry, is an evergreen shrub in the Solanaceae or nightshade family that grows in India, the Middle East, and parts of Africa. Several other species in the genus Withania are morphologically similar.",
                    "Curcuma is a genus of plants in the family Zingiberaceae that contains such species as turmeric and Siam tulip. They are native to Southeast Asia, southern China, the Indian Subcontinent, New Guinea and northern Australia.",
                    "Fennel or Saunf is a flowering plant species in the carrot family. It is a hardy, perennial herb with yellow flowers and feathery leaves. It is indigenous to the shores of the Mediterranean but has become widely naturalized in many parts of the world, especially on dry soils near the sea-coast and on riverbanks.",
                    "Asparagus racemosus is a species of asparagus common throughout India and the Himalayas. and northern Australia. It grows 1–2 m tall and prefers to take root in gravelly, rocky soils high up in piedmont plains, at 1,300–1,400 m elevation. It was botanically described in 1799.",
                    "Brassica nigra, or black mustard, is an annual plant cultivated for its dark-brown-to-black seeds, which are commonly used as a spice. It is native to tropical regions of North Africa, temperate regions of Europe, and parts of Asia."
                };
                String[] plants_img_src = { "holy-basil.jpg", "ashwagandha.jpg", "curcuma.jpg", "saunf.jpg", "shatavari.jpg", "sarson.jpg" };



                String commanName = request.getParameter("plant");

                //serching for right parameter
                int getDataIndex = Integer.parseInt(commanName.trim());

                //if parameter is wrong
                if(getDataIndex == -1) response.sendRedirect("index.html");


            %>
        <!---->
        <section
            class="w-full xl:py-10 2xl:py-5 px-5 my-[18%] sm:my-auto grid grid-cols-1 sm:grid-cols-2 grid-rows-2 sm:grid-rows-1 justify-items-center items-center">
            <div class="flex">
                <img class="w-[35%] sm:w-11/12 lg:w-4/5 xl:w-3/4 2xl:w-4/5 object-scale-down" id="plantName"
                    src="images/showcase-plants/<%=plants_img_src[getDataIndex]%>" alt="Shatavari">
                <!-- names of plant -->
                <div class="flex flex-col sm:hidden mx-auto lora text-white text-sm justify-center">
                    Scientific Name:<span id="scientificName" class="text-lg">&#32;<%=plants_Sci[getDataIndex]%></span><br>
                    Common Name:<span id="commonName" class="text-lg">&#32;<%=plants_CommanName[getDataIndex]%></span><br>
                    Rank:<span id="rank" class="text-lg">&#32;<%=plants_rank[getDataIndex]%></span><br>
                    Family:<span id="familyName" class="text-lg">&#32;<%=plants_family[getDataIndex]%></span><br>
                </div>
            </div>
            <div class="text-white p-5 flex flex-col gap-5 md:gap-10">
                <!-- names of plant -->
                <div class="hidden sm:flex flex-col lora text-white text-sm ">
                     Scientific Name:<span id="scientificName" class="text-lg">&#32;<%=plants_Sci[getDataIndex]%></span><br>
                    Common Name:<span id="commonName" class="text-lg">&#32;<%=plants_CommanName[getDataIndex]%></span><br>
                    Rank:<span id="rank" class="text-lg">&#32;<%=plants_rank[getDataIndex]%></span><br>
                    Family:<span id="familyName" class="text-lg">&#32;<%=plants_family[getDataIndex]%></span><br>
                </div>
                <div>
                    <p class="text-xl">About - </p>
                    <p id="aboutPlant"><%=plants_about[getDataIndex]%>
                    </p>
                </div>
            </div>
        </section>

    </section>


    <!-- footer -->
    <footer class="h-[30vh] bg-gray-200 py-4 flex flex-col justify-end items-center ">

        <div class="w-full mb-auto grid grid-cols-2 justify-between">
            <div><img class="invert" src="images/ayurveda-logo.png" alt="Ayurveda logo"></div>
            <ul class="justify-self-end mx-5 md:mx-10 lg:mx-40">
                <li>More Links</li>
                <li><a href="https://www.ggu.ac.in/" class="underline text-blue-500" target="_blank"
                        rel="noopener noreferrer">GGU</a></li>
                <li><a href="https://aiia.gov.in/" class="underline text-blue-500" target="_blank"
                        rel="noopener noreferrer">AIIA</a></li>
            </ul>
        </div>
        <hr width="100%" style="height:1px;border-width:0;color:gray;background-color:gray;">
        <p class="text-center text-lg">Copyright &#169; 2022-2023</p>
    </footer>
    <!--<script src="js/script.js"></script>-->
</body>

</html>