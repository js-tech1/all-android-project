package com.example.loginsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button btnlogin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        btnlogin = findViewById(R.id.btnsignin1);
        DB = new DBHelper(this);

        btnlogin.setOnClickListener(v -> {

            String user = username.toString();
            String pass = password.toString();
            if(user.equals("")|| pass.equals(""))
                Toast.makeText(LoginActivity.this, "Please all the fields", Toast.LENGTH_SHORT).show();
            else{
                Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                if (checkuserpass==true){
                    Toast.makeText(LoginActivity.this, "Sign in Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Invalid Credentiale", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}