package com.example.muskan.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Counter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
    }

    int quantity = 2;

    public void increment(View view){
        if (quantity==50)
        {
            Toast.makeText(this, "You cannot have more than 50 cups", Toast.LENGTH_SHORT).show();
            return;
        }

        quantity++;
        display(quantity);
    }

    public void decrement(View view){
        if(quantity==1)
        {
            Toast.makeText(this, "You cannot have less than 1 cup", Toast.LENGTH_SHORT).show();
            return;
        }

        quantity--;
        display(quantity);
    }

    public void submitOrder(View view){

        CheckBox whippCream_checkbox = (CheckBox) findViewById(R.id.checkCream);
        boolean hasWhipCream = whippCream_checkbox.isChecked();
        Log.v("MainActivity", "Has whipped cream: "+ hasWhipCream );

        CheckBox chocolate_checkbox = (CheckBox) findViewById(R.id.checkChocolate);
        boolean hasChocolate = chocolate_checkbox.isChecked();

        EditText name_value = (EditText) findViewById(R.id.name_field);
        String value = name_value.getText().toString();

        String msg = createOrderSummary(hasWhipCream, hasChocolate, value);

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for "+ value);
            intent.putExtra(Intent.EXTRA_TEXT, msg);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
    }

    public String createOrderSummary(boolean addWhipcream, boolean addChocolate, String name){
        String Msg = "Name: "+ name + "\nHas whipped cream: "+addWhipcream;
        Msg+= "\nHas chocolate: "+addChocolate;
        Msg+="\nTotal: $";

        int price = 5;

        if(addWhipcream)
            price+=1;
        if(addChocolate)
            price+=2;
        Msg+=quantity*price;

        Msg += ".\nQuantity: "+quantity+" coffees.\nThank you!";
        return Msg;
    }

    private void display(int num){
        TextView quantity = (TextView)findViewById(R.id.quantity_text);
        quantity.setText(""+num);
    }

}
