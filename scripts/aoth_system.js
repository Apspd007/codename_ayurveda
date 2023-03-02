console.log("Hii")
function aoth_system()
{
    console.log("Hh")
    let username = document.getElementById("username");
    let password = document.getElementById("password");
    
    //Create an Ajax request
    let xhr = new XMLHttpRequest();

    let username_ = username.value;
    let password_ = password.value;

    console.log(username_)
    console.log(password_)

    if(username_.trim() == '' || username_.trim() == "" || password_.trim() == '' || password_.trim() == "")
    {
        alert('Id or Password can\'t be blank')
        return;
    }
    console.log(username_);
    console.log(password_);
    // console.log(`./SearchPlants?search=${query}`);
    //Prepare request
    xhr.open('GET', `loginValidation.jsp?username=${username_}&password=${password_}`, true);
    
    //send request
    xhr.send();

    //process request

    xhr.onload = () => {
        if(xhr.status == 200 && xhr.readyState == 4)
        {
            if(xhr.response.trim() == "success"){
                window.location.href = "admin-menu.jsp";
                alert("Success");
            }
            else if(xhr.response.trim() == "Invalid username or password!"){
                alert('Invalid id or password');
            }
            else
            {
                alert(xhr.response);
            }
        }
        else
        {
            //display loading css
        }
    }
}
