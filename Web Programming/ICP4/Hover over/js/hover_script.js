/*Name this external file hover_script.js*/

// this function passes the picture and then changes the div with the image id to the picture that is passed along with
// it alt text. The function already activates when the mouse is over the picture
function upDate(previewPic) {

    // created two variables to hold url and text that are passed from the picture
    var imageurl = previewPic.getAttribute("src");
    var imagetext = previewPic.getAttribute("alt");

    //this part uses jQuery to select the image and change the image css background image and defualt text
    $('#image').css("background-image", "url(" + imageurl + ")");
    $('#image').text(imagetext);

}
// this function activates when the mouse leaves the picture and changes the url to null and text back to the what
// it was originially
function unDo() {

    $('#image').css("background-image", "url(" + ")");
    $('#image').text("Hover over an image below to display here.")
}


