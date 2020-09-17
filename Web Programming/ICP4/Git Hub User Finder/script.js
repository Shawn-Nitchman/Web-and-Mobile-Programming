function getGithubInfo(user) {
    //1. Create an instance of XMLHttpRequest class and send a GET request using it.
    // The function should finally return the object(it now contains the response!)

    var xhttp = new XMLHttpRequest();
    xhttp.open("Get", "https://api.github.com/users/"+ user, true);

    // this waits until until the api returns data and if it does it will procced to the show user funtion
    xhttp.onload = function(){
        if(xhttp.status === 200){
            var data = JSON.parse(xhttp.responseText);
            showUser(data);
        }else{
            noSuchUser(user);
        }

    }

    // I was not able to figure out how to get it to return the object and every resoucre I looked up did not use a
    // return. Maybe I am just stupid but this was the only way I could get the program to work.
    xhttp.send();
}

// this function will take a JSON file and then display the data by changing HTML and CSS data
function showUser(user) {
    //2. set the contents of the h2 and the two div elements in the div '#profile' with the user content

    // changign the header with user name
    $('#profile h2').html("U/N: " + user["login"]);

    // to get it make a photo I had to make a photo in the html and have it change the src here.
    var data = {"pic_url": user["avatar_url"]}
    $("#profilePic").attr("src",data.pic_url);

    // add text below photo of id
    document.getElementById("id").innerHTML = "ID: " + user["id"];

    // add the link below so the user can click on it and go the user profile
    var str = "Link to account: ";
    var result = str.link(user["html_url"],);
    document.getElementById("link").innerHTML = result;
}

// if there is an error in the data it comes here and all data is deleted
function noSuchUser(username) {
    //3. set the elements such that a suitable message is displayed
    $('#profile h2').html("No user found try again.");

    $("#profilePic").attr("src","");

    $(".information").text("");
}

// I mutated the file becuase I could not get it to return a value so it just calls the function
$(document).ready(function () {
    $(document).on('keypress', '#username', function (e) {
        //check if the enter(i.e return) key is pressed
        if (e.which == 13) {
            //get what the user enters
            username = $(this).val();
            //reset the text typed in the input
            $(this).val("");
            //Goes to find the user
            getGithubInfo(username);
        }
    })
});
