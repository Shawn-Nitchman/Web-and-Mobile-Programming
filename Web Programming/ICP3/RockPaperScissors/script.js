// this is the main and only function I have were it takes in the user input and calculates the result
function playerSelect(type){

    // this is to generate a random number, rock is 1, paper 2, scissor 3
    var x = Math.floor((Math.random() * 3) + 1);

    // this switch statement is so that the computer is not checking 9 different each time
    switch (x){
        // for case one the computer generated one so rock and will compare the user input.
        case 1:
            // once it is check it will display the correct output statments on the second square
            if(type == 1){
                document.getElementById("plaC").innerHTML = "You choose rock.";
                document.getElementById("comC").innerHTML = "The computer choose rock.";
                document.getElementById("outcome").innerHTML = "It is a draw.";
            }

            if(type == 2){
                document.getElementById("plaC").innerHTML = "You choose paper.";
                document.getElementById("comC").innerHTML = "The computer choose rock.";
                document.getElementById("outcome").innerHTML = "You Win!";
            }

            if(type == 3){
                document.getElementById("plaC").innerHTML = "You choose scissor.";
                document.getElementById("comC").innerHTML = "The computer choose rock.";
                document.getElementById("outcome").innerHTML = "You lose.";
            }
            break;

        case 2:
            if(type == 1){
                document.getElementById("plaC").innerHTML = "You choose rock.";
                document.getElementById("comC").innerHTML = "The computer choose paper.";
                document.getElementById("outcome").innerHTML = "You lose.";
            }

            if(type == 2){
                document.getElementById("plaC").innerHTML = "You choose paper.";
                document.getElementById("comC").innerHTML = "The computer choose paper.";
                document.getElementById("outcome").innerHTML = "It is a draw.";
            }

            if(type == 3){
                document.getElementById("plaC").innerHTML = "You choose scissor.";
                document.getElementById("comC").innerHTML = "The computer choose paper.";
                document.getElementById("outcome").innerHTML = "You Win!";
            }
            break;

        case 3:
            if(type == 1){
                document.getElementById("plaC").innerHTML = "You choose rock.";
                document.getElementById("comC").innerHTML = "The computer choose scissor.";
                document.getElementById("outcome").innerHTML = "You Win!";
            }

            if(type == 2){
                document.getElementById("plaC").innerHTML = "You choose paper.";
                document.getElementById("comC").innerHTML = "The computer choose scissor.";
                document.getElementById("outcome").innerHTML = "You lose.";
            }

            if(type == 3){
                document.getElementById("plaC").innerHTML = "You choose scissor.";
                document.getElementById("comC").innerHTML = "The computer choose scissor.";
                document.getElementById("outcome").innerHTML = "It is a draw.";
            }
            break;
    }

}