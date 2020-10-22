package edu.smng47.baselogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // When the user clicks on Login button it goes to this functions to determine if they entered
    // in the right username and password to log in
    public void login(View view){
        // this gets the text field info and turns it into a string to use with java
        EditText userNameCtrl = (EditText) findViewById(R.id.Username);
        EditText userPassCtrl = (EditText) findViewById(R.id.Password);
        String username = userNameCtrl.getText().toString();
        String password = userPassCtrl.getText().toString();

        // this is used to determine if login was correct or not
        boolean validationFlag = false;

        //checks to see if text was entered into username and password and if it equeals
        // hardcoded username and passwords if it matches sets flag to true
        if(!username.isEmpty() && !password.isEmpty()){
            if(username.equals("Shawn") && password.equals("Password")){
                validationFlag = true;
            }
        }

        //if flag is true because no text was entered or a field was incorrect it displays a toast
        // telling the user to try again. if flag was correct goes to redict function
        if(!validationFlag){
            Context context = getApplicationContext();
            CharSequence text = "Invalid username or password";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context,text,duration);
            toast.show();

        }else{
            redirectToWelcomePage(view);
        }
    }

    // this function is to switch activities so it goes from login to welcome page it also passes
    // along the name that was entered in when it is changing activities
    public void redirectToWelcomePage(View view){
        Intent redirect = new Intent(MainActivity.this, WelcomeActivity.class);
        EditText userNameCtrl = (EditText) findViewById(R.id.Username);
        String username = userNameCtrl.getText().toString();
        redirect.putExtra("Name",username);
        startActivity(redirect);
    }

    // this function is when someone clicks on the sign me up button. It does not do anything
    // but display a toast saying not yet added.
    public void alert(View view){
        Context context = getApplicationContext();
        CharSequence text = "Feature not yet added";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context,text,duration);
        toast.show();
    }



}