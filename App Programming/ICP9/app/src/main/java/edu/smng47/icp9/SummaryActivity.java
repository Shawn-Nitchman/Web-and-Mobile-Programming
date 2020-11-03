package edu.smng47.icp9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        changeTextFields();
    }

    // switches to main acitity when the user hits a button
    public void redirectToMainPage(View view){
        Intent redirect = new Intent(SummaryActivity.this, MainActivity.class);
        startActivity(redirect);
    }

    // this changes the dummy values on the pages to the info from the past page
    public void changeTextFields(){
        TextView nameText = findViewById(R.id.order_name);
        String name = getIntent().getExtras().getString("Name");
        nameText.setText("Dear " + name);

        TextView toppingText = findViewById(R.id.order_topping);
        String topping = getIntent().getExtras().getString("Topping");
        toppingText.setText("Toppings " + topping);

        TextView quatText = findViewById(R.id.order_quantity);
        String quantity = getIntent().getExtras().getString("Quantity");
        quatText.setText("Quantity " + quantity);

        TextView pricText = findViewById(R.id.order_price);
        String price = getIntent().getExtras().getString("Price");
        pricText.setText("Price " + price);

    }
}