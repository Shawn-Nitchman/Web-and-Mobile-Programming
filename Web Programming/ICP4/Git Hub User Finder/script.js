function getGithubInfo(user) {
    //1. Create an instance of XMLHttpRequest class and send a GET request using it.
    // The function should finally return the object(it now contains the response!)

    var xhttp = new XMLHttpRequest();
    xhttp.open("Get", "https://api.github.com/users/"+ user, true);

    xhttp.onload = function(){
        if(xhttp.status === 200){
            var data = JSON.parse(xhttp.responseText);
            showUser(data);
        }else{
            noSuchUser(user);
        }

    }
    xhttp.send();
}

function showUser(user) {
    //2. set the contents of the h2 and the two div elements in the div '#profile' with the user content

    $('#profile h2').html("U/N: " + user["login"]);

    var data = {"pic_url": user["avatar_url"]}
    $("#profilePic").attr("src",data.pic_url);

    document.getElementById("id").innerHTML = "ID: " + user["id"];

    var str = "Link to account: ";
    var result = str.link(user["html_url"],);
    document.getElementById("link").innerHTML = result;
}

function noSuchUser(username) {
    //3. set the elements such that a suitable message is displayed
    $('#profile h2').html("No user found try again.");

    $("#profilePic").attr("src","");

    $(".information").text("");
}



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
