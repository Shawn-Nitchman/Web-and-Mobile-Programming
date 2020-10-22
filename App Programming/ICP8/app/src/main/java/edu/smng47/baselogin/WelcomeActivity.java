package edu.smng47.baselogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        changeName(); // too keep things clean this function is to change text feild to display name
    }

    // when user clicks on logout button this function takes them back to the main activity
    public void redirectToHomePage(View view){
        Intent redirect = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(redirect);
    }

    // when page is created this will change the textfeild to display username entered in last
    // acitivty
    public void changeName(){
        TextView textview = (TextView) findViewById(R.id.textView2);
        String name = getIntent().getExtras().getString("Name");

        textview.setText(name);
    }

}