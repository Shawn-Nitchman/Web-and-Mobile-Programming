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
        EditText editText = (EditText) findViewById(R.id.nameInput);
        String username = editText.getText().toString();

        CheckBox getPepperoni = (CheckBox) findViewById(R.id.pepCheckBox);
        boolean hasPepperoni = getPepperoni.isChecked();

        CheckBox getSausage = (CheckBox) findViewById(R.id.sauCheckBox);
        boolean hasSausage = getSausage.isChecked();

        CheckBox getOnion = (CheckBox) findViewById(R.id.oniCheckBox);
        boolean hasOnion = getOnion.isChecked();

        CheckBox getMushroom = (CheckBox) findViewById(R.id.musCheckBox);
        boolean hasMushroom = getMushroom.isChecked();

        float totalPrice = calculatePrice(hasPepperoni,hasSausage,hasOnion,hasMushroom);

        String selectedToppings = createOrderSummary(hasPepperoni, hasSausage, hasOnion, hasPepperoni);

        Intent redirect = new Intent(MainActivity.this, SummaryActivity.class);
        redirect.putExtra("Name", username);

        String x = Float.toString(totalPrice);
        String y = Integer.toString(quantity);

        redirect.putExtra("Price", x);
        redirect.putExtra("Quantity", y);
        redirect.putExtra("Topping", selectedToppings);
        startActivity(redirect);
    }


    public String createOrderSummary(boolean hasPep, boolean hasSau, boolean hasOni, boolean hasMus){
        String orderSummarymessage = "";

        if(hasPep){
            orderSummarymessage += getString(R.string.pepperoni) + " ";
        }
        if(hasSau){
            orderSummarymessage += getString(R.string.sausage) + " ";
        }
        if(hasOni){
            orderSummarymessage += getString(R.string.onion) + " ";
        }
        if(hasMus){
            orderSummarymessage += getString(R.string.mushroom) + " ";
        }

        return orderSummarymessage;
    }

    public void redirectToOrder(View view){
        EditText editText = (EditText) findViewById(R.id.nameInput);
        String name = editText.getText().toString();

        CheckBox getPepperoni = (CheckBox) findViewById(R.id.pepCheckBox);
        boolean hasPepperoni = getPepperoni.isChecked();

        CheckBox getSausage = (CheckBox) findViewById(R.id.sauCheckBox);
        boolean hasSausage = getSausage.isChecked();

        CheckBox getOnion = (CheckBox) findViewById(R.id.oniCheckBox);
        boolean hasOnion = getOnion.isChecked();

        CheckBox getMushroom = (CheckBox) findViewById(R.id.musCheckBox);
        boolean hasMushroom = getMushroom.isChecked();

        float totalPrice = calculatePrice(hasPepperoni,hasSausage,hasOnion,hasMushroom);

        String selectedToppings = createOrderSummary(hasPepperoni, hasSausage, hasOnion, hasPepperoni);

        String message = "Dear " + name + ", \n" +
                "Number of pizzas " + quantity + "\n" +
                "Toppings " + selectedToppings + "\n" +
                "Price " + totalPrice;

        String[] address = {"smng47@umsyst.edu"};
        
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("*/*");
        sendIntent.putExtra(Intent.EXTRA_EMAIL, address);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, name + "'s order");
        sendIntent.putExtra(Intent.EXTRA_TEXT, message);


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