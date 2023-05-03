
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
                results.innerHTML = xhr.responseText;
                // document.getElementById('loadbutton').style.display = 'initial';
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
            console.log(xhr.responseText);
            // alert(xhr.responseText);
            // document.getElementById('loadbutton').style.display = 'initial';
        }
        else
        {
            //display loading css
            results.innerHTML = "";
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
                // document.getElementById('loadbutton').style.display = 'initial';
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

function loadMoreData()
{
    let offset = document.getElementById("rownum").value;
    console.log(offset);

    //Removing offset element tag for in case of duplicaty
    let offsetElement = document.getElementById("rownum");
    offsetElement.remove();

    //Fetching Data Using AJAX and appending it to previous data
    let search_query = document.getElementById("search_query");
    
    //Create an Ajax request
    let xhr = new XMLHttpRequest();

    let query = search_query.value;

    // if(query.trim() == '' || query.trim() == "")
    // {
    //     loadTabs();
    //     return;
    // }

    //Checking all rows is displayed or not
    let x = ""+results.innerHTML;
    console.log(x);
    if(x.includes("No More Row Selected..."))
    {
        return;
    }
    
    // console.log(`./SearchPlants?search=${query}`);
    //Prepare request
    console.log("offset"+offset);
    xhr.open('GET', `./SearchPlants?search=${query}&offset=${offset}`, true);
    
    //send request
    xhr.send();

    //process request

    xhr.onload = () => {
        if(xhr.status == 200 && xhr.readyState == 4)
        {
            results.innerHTML += xhr.responseText;
        }
        else
        {
            //display loading css
        }
    }

}

search_history = []

//Perform Enter Key press event on search bar
function addSearchHistory(event) {

  // Check if the key pressed was "Enter"
  if (event.key === 'Enter') {
    // Execute your function here
    
    console.log('Enter key pressed!');
    let search_query = document.getElementById("search_query").value;
    
    search_history.unshift(search_query);

  }
  
  //console.log(event.target.value);

  //search_history.unshift(event.target.value);

  ///displaying history


  //Adding selected value
  let datalist = document.getElementById("search_queries");
  let options = datalist.options;
  for (var i = 0; i < options.length; i++)
  {
    if(options[i].value == event.target.value)
    {
        //Checking already is search is on history or not
        let flag = false;
        for(let alreadyInHistory of search_history)
        {
            if(alreadyInHistory == event.target.value)
            {
                flag = true;
                break;
            }
        }
        if(flag) break;
        search_history.unshift(event.target.value);
    }
  }


  let recentsearch = document.getElementById("recentsearch");
  
  let historyTemplate = "";

//   historyTemplate += "<ul>";
//   historyTemplate += "<h1 style='font-size:20px; margin-top:20px;'>Recent Search</h1>"
  for(let x of search_history)
  {
    historyTemplate += '<li>';
    historyTemplate += `<button type='button' style='background:none;color:blue;  border:none; padding:0; margin:0; cursor:pointer; text-decoration: none;' onmouseover  = "this.style.textDecoration = 'underline' " onmouseout  = " this.style.textDecoration = 'none' " onclick='setData("${x}")'>${x}</button>`;
    historyTemplate += '</li>';
  }
//   historyTemplate += "</ul>";


  // Adding black Seperator lines

  recentsearch.innerHTML = historyTemplate;
}

function setData(searchHistory)
{
    let searchBox = document.getElementById("search_query");
    searchBox.value = searchHistory;
    search_item();
}