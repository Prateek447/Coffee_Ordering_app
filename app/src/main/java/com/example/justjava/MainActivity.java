package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {


        int price = quantity*5;


        CheckBox  addWhippedCream =  findViewById(R.id.whipped_cream_add);
        boolean  hasAdd  =  addWhippedCream.isChecked();

        if (hasAdd){
            price += 1;
        }

        CheckBox  addChocolates = findViewById(R.id.chocolate_checkbox);
        boolean addChoco = addChocolates.isChecked();

        if(addChoco) {
            price = price+2;
        }

        EditText  inputName  = findViewById(R.id.name_field);
        String  name = inputName.getText().toString();

        String priceMessage = "Name: "+name+"\nAdd Whipped Cream?"+hasAdd+"\nAdd Chocolate?"+addChoco+"\nQuantity: "+ quantity +"\nTotal: $"+price+"\nThank You!";

        Intent intent  = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT,"Order By "+name);
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
//
//        displayMessage(priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView =  findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);

    }

    /**
     * This method displays the given price on the screen.
     */
//    private void displayPrice(int number) {
//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
//        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//    }

    public  void increment(View view){
        quantity =  ++quantity;
        display(quantity);
    }


    /**
     * This method displays the given text on the screen.
     */
//    private void displayMessage(String message) {
//        TextView priceTextView =  findViewById(R.id.price_text_view);
//        priceTextView.setText(message);
//    }


    public  void decrement(View view){
        if(quantity!=0)
         quantity =  --quantity;
       display(quantity);
    }
}