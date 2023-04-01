package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText txt1=findViewById(R.id.ne);
        EditText txt2=findViewById(R.id.nem);
        Button btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dd=txt1.getText().toString();
                String dd2=txt2.getText().toString();
                //int a=Integer.parseInt(dd);
                int b=Integer.parseInt(dd2);
               // int c=a+b;
                Toast.makeText(MainActivity2.this,"Hello Pradip successful", Toast.LENGTH_SHORT).show();
            }
        });

    }
}