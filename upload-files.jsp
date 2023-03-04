<!-- Auth System -->
<%

    //Checking Session

    if(session.getAttribute("username") == null ) 
    {
        response.sendRedirect("admin.jsp");
    }
    
    HttpSession session_ = request.getSession(false);
    if (session_ == null || session_.equals("null")) {
        session_ = request.getSession();
        if( session_ == null || session_.equals("null"))
        {
            response.sendRedirect("admin.jsp");
        }
    }

%>

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
    <title>Upload File</title>
</head>
<body>
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
                <img class="filter invert" src="../images/ayurveda-logo.png" alt="Ayurveda Logo" width="250"
                    height="60">
            </span>
            <nav class=" flex w-min items-center self-end justify-end gap-x-7 py-1 pl-14 px-10">
                <div onclick="redirectHome()"
                    class="cursor-pointer px-2 py-1 text-xl font-medium tracking-wide hover:bg-gray-300 rounded ease-in duration-200">
                    Home</div>
                <div>
                    <button id="menu-about"
                        class="peer nav-font-size cursor-pointer px-2 py-1 text-xl font-medium tracking-wide hover:bg-gray-300 rounded ease-in duration-200">
                        About
                    </button>
                    <!-- the menu here -->
                    <div id="menu-item-about" class="hidden peer-hover:grid hover:grid grid-flow-row
                         bg-white drop-shadow-lg absolute z-10">
                        <a class="px-5 py-3 hover:bg-gray-200" href="nav-pages/about-ggu.html">About GGU</a>
                        <a class="px-5 py-3 hover:bg-gray-200" href="https://aiia.gov.in/about/">About AIIA</a>
                    </div>
                </div>
                <div
                    class="cursor-pointer px-2 py-1 text-xl font-medium tracking-wide hover:bg-gray-300 rounded ease-in duration-200">
                    Academic</div>
                <div>
                    <button id="menu-administration"
                        class="peer nav-font-size cursor-pointer px-2 py-1 text-xl font-medium tracking-wide hover:bg-gray-300 rounded ease-in duration-200">
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

    <section class="my-20">
        <div class="px-6 py-12 h-full">
            <div class="flex justify-center items-center flex-wrap h-full g-6 text-gray-800">
                <div class="md:w-8/12 lg:w-5/12 lg:ml-20">
                    <form action="./FilesUpload" method="post" enctype="multipart/form-data">
                        <h2 class="IBM-Plex text-center text-2xl leading-[5rem]">Upload Plant Details</h2>
                        <!-- Common Name-->
                        <div class="mb-6">
                            <label for='com' class='text-xl'>Common Name</label>
                            <input type="text"
                                id='com'
                                class="form-control block w-full px-4 py-2 text-lg font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                placeholder="Ex. Holy Basil"
                                name="com_name"
                                required />
                        </div>

                        <!-- Scientific Name-->
                        <div class="mb-6">
                            <label for='sci' class='text-xl'>Scientific Name</label>
                            <input type="text"
                                id='sci'
                                class="form-control block w-full px-4 py-2 text-lg font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                placeholder="Ex. Ocimum tenuiflorum"
                                name="sci_name"
                                required />
                        </div>

                        <!-- Family Name-->
                        <div class="mb-6">
                            <label for='family' class='text-xl'>Family Name</label>
                            <input type="text"
                                id='family'
                                class="form-control block w-full px-4 py-2 text-lg font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                placeholder="Ex. Mints"
                                name="family"
                                required />
                        </div>

                        <!-- Plant Image-->
                        <div class="mb-6">
                            <label for='img' class='text-xl'>Plant Image</label>
                            <input type="file"
                                id='img'
                                class="form-control block w-full px-4 py-2 text-lg font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                placeholder="Upload Image"
                                accept="image/*" 
                                name="img_file"
                                required />
                        </div>

                        <!-- Plant pdf-->
                        <div class="mb-6">
                            <label for='pdf' class='text-xl'>Plant Pdf</label>
                            <input type="file"
                                id='pdf'
                                class="form-control block w-full px-4 py-2 text-lg font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                placeholder="Upload Image"
                                accept=".pdf" 
                                name="pdf_file"
                                required />
                        </div>

                        <!-- Submit button -->
                        <button type="submit"
                            class="inline-block px-7 py-3 bg-blue-600 text-white font-medium leading-snug rounded shadow-md hover:bg-blue-700 hover:shadow-lg focus:bg-blue-700 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-blue-800 active:shadow-lg transition duration-150 ease-in-out w-full"
                            data-mdb-ripple="true" data-mdb-ripple-color="light">
                            Upload
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </section>
    
    <!-- footer -->
    <footer class="h-[30vh] bg-gray-200 py-4 flex flex-col justify-end items-center">
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
    
    <script src="js/script.js"></script>
</body>
</html>