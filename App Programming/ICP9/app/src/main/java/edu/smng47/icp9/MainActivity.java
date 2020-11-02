package edu.smng47.icp9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int PIZZA = 10;
    final int PEPPERONI = 3;
    final int SAUSAGE = 3;
    final int ONION = 2;
    final int MUSHROOM = 2;
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void redirctToSummaryPage(View view){
        Intent redirect = new Intent(MainActivity.this, SummaryActivity.class);

        EditText editText = (EditText) findViewById(R.id.nameInput);
        String username = editText.getText().toString();
        redirect.putExtra("Name", username);

        CheckBox getPepperoni = (CheckBox) findViewById(R.id.pepCheckBox);
        boolean hasPepperoni = getPepperoni.isChecked();

        CheckBox getSausage = (CheckBox) findViewById(R.id.sauCheckBox);
        boolean hasSausage = getSausage.isChecked();

        CheckBox getOnion = (CheckBox) findViewById(R.id.oniCheckBox);
        boolean hasOnion = getOnion.isChecked();

        CheckBox getMushroom = (CheckBox) findViewById(R.id.musCheckBox);
        boolean hasMushroom = getMushroom.isChecked();

        float totalPrice = calculatePrice(hasPepperoni,hasSausage,hasOnion,hasMushroom);
        String x = Float.toString(totalPrice);
        String y = Integer.toString(quantity);
        redirect.putExtra("Price", x);
        redirect.putExtra("Quantity", y);

        startActivity(redirect);
    }

    public void redirectToOrder(View view){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, quantity);
        sendIntent.setType("text.plain");

        if(sendIntent.resolveActivity(getPackageManager()) != null){
            startActivity(sendIntent);
        }
    }

    private float calculatePrice(boolean pepperoni, boolean sausage, boolean onion, boolean mushroom){
        int basePrice = PIZZA;
        if(pepperoni){
            basePrice += PEPPERONI;
        }
        if(sausage) {
            basePrice += SAUSAGE;
        }
        if(onion){
            basePrice += ONION;
        }
        if(mushroom){
            basePrice += MUSHROOM;
        }

        return quantity * basePrice;
    }


    public void display(int quantity){
        TextView textView = (TextView) findViewById(R.id.pizzaQuanty);
        textView.setText(String.valueOf(quantity));

    }

    public void increment(View view){
        if(quantity < 100){
            quantity = quantity + 1;
            display(quantity);
        } else{
            Context context = getApplicationContext();
            String quantityTooHigh = "Please select less than 100 pizzas";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context,quantityTooHigh,duration);
            toast.show();
        }
    }

    public void decrement(View view){
        if(quantity > 1){
            quantity = quantity - 1;
            display(quantity);
        }else{
            Context context = getApplicationContext();
            String quantityTooLow = "Please select more than 1 pizza";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context,quantityTooLow,duration);
            toast.show();
        }
    }
}