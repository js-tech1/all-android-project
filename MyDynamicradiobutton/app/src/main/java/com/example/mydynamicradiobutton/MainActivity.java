package com.example.mydynamicradiobutton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RelativeLayout rl;
    RadioButton rb1,rb2;

    public MainActivity() {
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = new RadioGroup(this);
        rl = (RelativeLayout) findViewById(androidx.constraintlayout.widget.R.id.deltaRelative);
        rb1 = new RadioButton(this);
        rb2 = new RadioButton(this);

        rb1.setText("Male");
        rb2.setText("Female");
        rg.addView(rb1);
        rg.addView(rb2);
        rg.setOrientation(RadioGroup.HORIZONTAL);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((int) ViewGroup.LayoutParams.WRAP_CONTENT,(int) RadioGroup.LayoutParams.WRAP_CONTENT);
        params.leftMargin =200;
        params.topMargin = 100;

        rg.setLayoutParams(params);
        rl.addView(rg);

        rg.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton radioButton = (RadioButton) findViewById(checkedId);
            android.widget.Toast.makeText(getApplicationContext(),radioButton.getText(), android.widget.Toast.LENGTH_LONG).show();
        });
    }

}