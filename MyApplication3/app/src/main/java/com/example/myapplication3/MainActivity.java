package com.example.myapplication3;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;
public class MainActivity extends AppCompatActivity {
    private ToggleButton tg1,tg2;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }
    @SuppressLint("WrongViewCast")
    private void addListenerOnButtonClick() {
        tg1=findViewById(R.id.tg1);
        tg2= findViewById(R.id.tg2);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result= new StringBuilder();
                result.append("ToggleButton1:").append(tg1.getText());
                result.append("ToggleButton2:").append(tg2.getText());
                Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}