package com.example.loginsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username,password,repassword;
    Button signup,signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        signup = findViewById(R.id.btnsignup);
        signin = findViewById(R.id.btnsignin);
        DB = new DBHelper(this);

        signup.setOnClickListener(v -> {
        String user = username.getText().toString();
        String pass = password.getText().toString();
        String repass = repassword.getText().toString();

        if(user.equals("") || pass.equals("") || repass.equals(""))
            Toast.makeText(MainActivity.this, "Please enter the fields", Toast.LENGTH_SHORT).show();
        else{
            if(pass.equals(repass)){
                Boolean checkuser = DB.checkusername(user);
                if(checkuser==false){
                    Boolean insert = DB.insertData(user,pass);
                    if(insert==true){
                        Toast.makeText(MainActivity.this,"Ragistered Successfully",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(MainActivity.this, "Ragistration failed",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast .makeText(MainActivity.this,"User already exists! Please sign in",Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(MainActivity.this,"Password not matching",Toast.LENGTH_SHORT).show();
            }
          }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new
                        Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}