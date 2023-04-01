package com.example.phonecall;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editext1;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editext1 =(EditText) findViewById(R.id.editText1);
        button1 =(Button) findViewById(R.id.button1);
        button1.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=editext1.getText().toString();
                Intent calllntent = new Intent(Intent.ACTION_CALL);
                calllntent.setData(Uri.parse("tel:"+number));
                startActivity(calllntent);
            }
        });
    }
    @SuppressLint("ResourceType")
    public boolean onCreatOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.layout.activity_main, menu);
        return true;
    }
}