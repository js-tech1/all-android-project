package com.example.myedittextwithtextwatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter <String> adapter;

    private final String[] products = {"Pradip", "Brijesh","Deep", "Mayank", "Nirmal", "Raj",
            "Prit", "Vinay","Harsh", "Gourav", "Satish", "Jonny"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = findViewById(R.id.listView);
        EditText editText = findViewById(R.id.editText);
        adapter = new ArrayAdapter<>(this, R.layout.listview, R.id.product_name, products);
        lv.setAdapter(adapter);
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                Toast.makeText(getApplicationContext(),"before text change",Toast.LENGTH_LONG).show();
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                Toast.makeText(getApplicationContext(),"after text change",Toast.LENGTH_LONG).show();
            }
        });
    }
}
