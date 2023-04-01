package com.example.mysqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText num;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        num=findViewById(R.id.num);
        submit=findViewById(R.id.button);
        DatabaseHandler db = new DatabaseHandler(this);
        Log.d("Insert: ", "Inserting ..");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addContact(new Contact.Contact1(name.getText().toString(),num.getText().toString()));
//              getTextToast.makeText(getBaseContext(), name.getText().toString() , Toast.LENGTH_SHORT ).show();
            }
        });

//        db.addContact(new Contact.Contact1("Pradip", "9199999999"));
//        db.addContact(new Contact.Contact1("Brijesh", "9522222222"))
//        db.addContact(new Contact.Contact1("Prit", "9533333333"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact.Contact1> contact1= db.getAllContacts();

        for (Contact.Contact1 cn : contact1) {
            String log = "Id: " + cn.getName() + " ,Name: " + cn.getName() + " ,Phone: " +
                    cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }
}
