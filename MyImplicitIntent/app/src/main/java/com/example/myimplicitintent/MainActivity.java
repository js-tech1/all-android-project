package com.example.myimplicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editText =  findViewById(R.id.editText);
        button.setOnClickListener(view -> {
            String url=editText.getText().toString();
          Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//            Intent intent=new Intent(Intent.ACTION_VIEW);
//            intent.setData(Uri.parse(url));
           startActivity(intent);
        });
    }
}
