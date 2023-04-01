package com.example.alertdialog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button closeButton;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        closeButton = findViewById(R.id.button);
        builder = new AlertDialog.Builder(this);
        closeButton.setOnClickListener(v -> {


            builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

            builder.setMessage("Do you want to close this application ?").setCancelable(false)
                    .setPositiveButton("Yes", (dialog, id) -> {
                        finish();
                        Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
                                Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("No", (dialog, id) -> {
                        dialog.cancel();
                        Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
                                Toast.LENGTH_SHORT).show();
                    });
            AlertDialog alert = builder.create();
            alert.setTitle("AlertDialogExample");
            alert.show();
        });
    }
}