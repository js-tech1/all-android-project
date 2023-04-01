package com.example.myexplicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.Button01);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {

                // Creating explicit intent
                Intent i = new Intent(getApplicationContext(),
                        MainActivity2.class);
                startActivity(i);
            }
        });
    }
}

