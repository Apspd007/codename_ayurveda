function loadTabs()
{
    let results = document.getElementById("results");
    try{
        //Create an Ajax request
        let xhr = new XMLHttpRequest();

        //Prepare request
        console.log("working");
        xhr.open('GET', './Onload', true);
        
        //send request
        xhr.send();

        //process request

        xhr.onload = () => {
            
            console.log("Loading data.........1");
            if(xhr.status == 200 && xhr.readyState == 4 )
            {
                document.getElementById("loading-container").style.display = "none";
                results.innerHTML = xhr.responseText;
            }
            else
            {
                //display loading css
                console.log("Loading data.........2");
            }
        }
        
        console.log("Loading data.........3");
    }
    catch(e)
    {
        console.log(e)
    }
}

function search_item()
{
    let search_query = document.getElementById("search_query");
    
    //Create an Ajax request
    let xhr = new XMLHttpRequest();

    let query = search_query.value;
    if(query.trim() == '' || query.trim() == "")
    {
        loadTabs();
        return;
    }
    // console.log(`./SearchPlants?search=${query}`);
    //Prepare request
    xhr.open('GET', `./SearchPlants?search=${query}`, true);
    
    //send request
    xhr.send();

    //process request

    xhr.onload = () => {
        if(xhr.status == 200 && xhr.readyState == 4)
        {
            results.innerHTML = xhr.responseText;
        }
        else
        {
            //display loading css
        }
    }
}

function loadSearchsTabs()
{
    let recentsearch = document.getElementById("recentsearch");
    try{
        //Create an Ajax request
        let xhr = new XMLHttpRequest();

        //Prepare request
        console.log("working");
        xhr.open('GET', './DisplayRecentSearch', true);
        
        //send request
        xhr.send();

        //process request
        console.log("Kya ho gya");
        xhr.onload = () => {
            
            console.log("Loading data.........1");
            if(xhr.status == 200 && xhr.readyState == 4 )
            {
                recentsearch.innerHTML = xhr.responseText;
            }
            else
            {
                //display loading css
                console.log("Loading data.........2");
            }
        }
        
        console.log("Loading data.........3");
    }
    catch(e)
    {
        console.log(e)
    }
}

function loadSuggestion()
{
    let suggetionList = document.getElementById("search_queries");
    try{
        //Create an Ajax request
        let xhr = new XMLHttpRequest();

        //Prepare request
        console.log("working");
        xhr.open('GET', './AddSearchSuggestion', true);
        
        //send request
        xhr.send();

        //process request
        console.log("datalist");
        xhr.onload = () => {
            
            console.log("datalist Loading data.........1");
            if(xhr.status == 200 && xhr.readyState == 4 )
            {
                suggetionList.innerHTML = xhr.responseText;
            }
            else
            {
                //display loading css
                console.log("datalist Loading data.........2");
            }
        }
        
        console.log("Loading data.........3");
    }
    catch(e)
    {
        console.log(e)
    }

}
