package com.example.android.justjava;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends Activity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     *
     */
    public void submitOrder(View view) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox);
        boolean checkbox1 = checkBox.isChecked();
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        boolean checkbox2 = checkBox2.isChecked();
        EditText Name = (EditText) findViewById(R.id.exittext);
        String name =Name.getText().toString();
        String summaryString = createOrderSummary(quantity,name,checkbox1,checkbox2);
        displayMessage(summaryString,checkbox1,checkbox2,name);

    }
    public void increment(View view)
    {
        quantity = quantity + 1;
        if(quantity > 100 ) {
            quantity =100;
            Toast.makeText(getApplicationContext(),"value above 100",Toast.LENGTH_SHORT).show();

        }
        display(quantity);
    }
    public void decrement (View view)
    {


        quantity -= 1;
        if (quantity<1){
            quantity = 1;
            Toast.makeText(getApplicationContext(),"value below 1",Toast.LENGTH_SHORT).show();
        }

        display(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
//    private void displayPrice(int number) {
//        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
//        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));

//    }
    private void displayMessage(String message, boolean checkbox1,boolean checkbox2,String name) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText("Hello "+name + "\n" +message+ "\n Cream : " + checkbox1 + "\nChocolate : " + checkbox2);
    }
    /**
     * Calculates the price of the order.
     *
     */
//    private int calculatePrice() {
//        int price = quantity * 5;
//        return price;
//    }
    private String createOrderSummary (int number,String name,boolean checkbox1,boolean checkbox2) {
        int price = number * 5;
        if(checkbox1){
            price =price + number;
        }
        if(checkbox2){
            price = price + number*2;
        }
        String summaryString = "thanks " +name;
        summaryString = summaryString + "\n your price is $ " + price;
        return summaryString;
    }

}