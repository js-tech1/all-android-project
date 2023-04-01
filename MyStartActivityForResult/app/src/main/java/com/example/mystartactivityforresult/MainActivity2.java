package com.example.mystartactivityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    EditText editText1;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText1= findViewById(R.id.editText1);
        button1= findViewById(R.id.button1);
        button1.setOnClickListener(arg0 -> {
            String message=editText1.getText().toString();
            Intent intent=new Intent();
            intent.putExtra("MESSAGE",message);
            setResult(2,intent);
            finish();//finishing activity
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second, menu);
        return true;

    }
}
