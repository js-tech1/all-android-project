package com.example.myexplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button1 = (Button)findViewById(R.id.Button01);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {

                // Creating explicit intent
                Intent i = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(i);
            }
        });
    }
}
