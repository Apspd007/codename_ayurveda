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

<!-- <body onload="init()"> -->
<body>
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

    <!-- header -->
    <section class="hidden header-section h-[160px] lg:flex flex-col justify-between">

        <header class="w-full h-[90px] px-10 flex justify-between items-center ">
            <div onclick="blankRedirect('https://www.ggu.ac.in/')" class="cursor-pointer"><img
                    class="2xl:h-[90px] max-h-[90px] object-cover" src="images/ggu-image.png"></div>
            <img class="h-28 object-cover cursor-pointer" onclick="redirectHome()" src="images/gg.png">
            <div onclick="blankRedirect('https://aiia.gov.in/')" class="cursor-pointer">
                <img class="2xl:h-[90px] max-h-[90px] object-cover" src="images/aiia-image.png">
            </div>
        </header>

        <!-- Logo and navigation -->
        <div class="flex justify-between items-end">
            <span class="xl:ml-[12%]">
                <img class="filter invert" src="images/ayurveda-logo.png" alt="Ayurveda Logo" width="250" height="60">
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

    <!-- Breadcrumb CSS -->

    <div class="container mt-2" style="margin-top: 30px; background-color: aliceblue;width:80%; margin: auto;">
    
        <nav class="flex" aria-label="Breadcrumb" style="margin-top: 30px;">
            <ol class="inline-flex items-center space-x-1 md:space-x-3">
            <li class="inline-flex items-center">
                <a href="index.html" class="inline-flex items-center text-sm font-medium text-gray-700 hover:text-blue-600 dark:text-gray-400 dark:hover:text-white">
                <svg aria-hidden="true" class="w-4 h-4 mr-2" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path d="M10.707 2.293a1 1 0 00-1.414 0l-7 7a1 1 0 001.414 1.414L4 10.414V17a1 1 0 001 1h2a1 1 0 001-1v-2a1 1 0 011-1h2a1 1 0 011 1v2a1 1 0 001 1h2a1 1 0 001-1v-6.586l.293.293a1 1 0 001.414-1.414l-7-7z"></path></svg>
                Home
                </a>
            </li>
            <li aria-current="page">
                <div class="flex items-center">
                <svg aria-hidden="true" class="w-6 h-6 text-gray-400" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z" clip-rule="evenodd"></path></svg>
                <span class="ml-1 text-sm font-medium text-gray-500 md:ml-2 dark:text-gray-400">Admin</span>
                </div>
            </li>
            </ol>
        </nav>
  
    </div>
    <!-- Breadcrumb Css -->

    

    <!-- admin login -->
    <section class="my-10">
        <div class="px-6 py-12 h-full">
            <div class="flex justify-center items-center flex-wrap h-full g-6 text-gray-800">
                <div class="md:w-8/12 lg:w-5/12 lg:ml-20">
                    <!-- <form id="LoginForm" method="get"> -->
                        <h2 class="IBM-Plex text-center text-2xl leading-[5rem]">Admin Login</h2>
                        <!-- Email input -->
                        <div class="mb-6">
                            <input type="text"
                                class="form-control block w-full px-4 py-2 text-xl font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                placeholder="Username" id="username"/>
                        </div>

                        <!-- Password input -->
                        <div class="mb-6">
                            <input type="password"
                                class="form-control block w-full px-4 py-2 text-xl font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                placeholder="Password" id="password"/>
                        </div>

                        <div class="flex justify-between items-center mb-6">
                            <a href="#!"
                                class="text-blue-600 hover:text-blue-700 focus:text-blue-700 active:text-blue-800 duration-200 transition ease-in-out">Forgot
                                password?</a>
                        </div>

                        <!-- Submit button -->
                        <button type="submit"
                            class="inline-block px-7 py-3 bg-blue-600 text-white font-medium leading-snug rounded shadow-md hover:bg-blue-700 hover:shadow-lg focus:bg-blue-700 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-blue-800 active:shadow-lg transition duration-150 ease-in-out w-full"
                            data-mdb-ripple="true" data-mdb-ripple-color="light" id="submit" onclick="aoth_system()">
                            Sign In
                        </button>

                    <!-- </form> -->
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
    <script src="scripts/aoth_system.js"></script>
    <!-- <script src="js/script.js"></script> -->
</body>

</html>