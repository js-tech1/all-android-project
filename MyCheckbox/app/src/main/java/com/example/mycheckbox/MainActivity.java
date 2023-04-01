package com.example.mycheckbox;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    CheckBox pizza,coffee,burger;
    Button buttonOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }
    public void addListenerOnButtonClick(){
        pizza= findViewById(R.id.checkBox);
        coffee= findViewById(R.id.checkBox2);
        burger= findViewById(R.id.checkBox3);
        buttonOrder= findViewById(R.id.button);
        buttonOrder.setOnClickListener(view -> {
            int totalamount=0;
            StringBuilder result=new StringBuilder();
            result.append("Selected Items:");
            if(pizza.isChecked()){
                result.append("\nPizza 100Rs");
                totalamount+=100;
            }
            if(coffee.isChecked()){
                result.append("\nCoffee 50Rs");
                totalamount+=50;
            }
            if(burger.isChecked()){
                result.append("\nBurger 120Rs");
                totalamount+=120;
            }
            result.append("\nTotal: "+totalamount+"Rs");
            Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG).show();
        });
    }
}
