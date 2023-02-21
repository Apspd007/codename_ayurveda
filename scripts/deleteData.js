
function loadTabs()
{
    let results = document.getElementById("results");
    try{
        //Create an Ajax request
        let xhr = new XMLHttpRequest();

        //Prepare request
        console.log("working");
        xhr.open('GET', './LoadModifyTable', true);
        
        //send request
        xhr.send();

        //process request

        xhr.onload = () => {
            
            console.log("Loading data.........1");
            if(xhr.status == 200 && xhr.readyState == 4 )
            {
                // document.getElementById("loading-container").style.display = "none";
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


function search_item()
{
    let search_query = document.getElementById("search_query");
    
    //Create an Ajax request
    let xhr = new XMLHttpRequest();

    let query = search_query.value;
    if(query.trim() == '' || query.trim() == "")
    {
        return;
    }
    // console.log(`./SearchPlants?search=${query}`);
    //Prepare request
    xhr.open('GET', `./SearchModifiedData?search=${query}`, true);
    
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


//////////////////////////////////////

function loadData(id, com_name, sci_name, family_name, img, pdf)
{
    document.getElementById("id").value = id;
    document.getElementById("id").disabled = false;

    
    document.getElementById("com_name").innerHTML = com_name;

    
    document.getElementById("sci_name").innerHTML = sci_name;

    document.getElementById("family_name").innerHTML = family_name;

    
    document.getElementById("deletePdf").href = "Viewer?id="+id;

    document.getElementById("deleteButton").disabled = false;

    document.getElementById("myImg").src = "images/plants/img-"+id+".jpg";


    location.href ="#UpdateSection";
}

const deleteform = document.querySelector('#delete-form');
deleteform.addEventListener('submit', (event) => {

//Conforming Deleting Data
let confirmMsg = confirm("Sure!! you want to delete data");
if(confirmMsg == false)
{
    return;
}

//Disabling Update button
document.getElementById("deleteButton").disabled = true;

//Enable Loading icon
document.getElementById("loadingIcon").style = "block";

event.preventDefault();

const formData = new FormData(deleteform);

const xhr = new XMLHttpRequest();
xhr.open('POST', './DeleteModifiedData', true);

xhr.onload = function() {
    if (xhr.status === 200) {
    console.log('File uploaded successfully.');
    alert('Data Deleted Successfully, Page Will be reload to reflect Changes');
    alert(xhr.response);

    //Enabling Update button
    document.getElementById("deleteButton").disabled = false;

    //Disabling Loading icon
    document.getElementById("loadingIcon").style = "none";

    location.reload(true);
    } else {
    console.log('Error uploading file.');
    }
};

xhr.send(formData);
});
