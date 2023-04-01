package com.example.myoptionmenu;

import static com.example.myoptionmenu.R.id.search_item;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.search_item:

                Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);

                return true;
            case R.id.upload_item:
                Intent up = new Intent(MainActivity.this,MainUpload.class);
                startActivity(up);
                return true;
            case R.id.copy_item:
                // do your code
                return true;
            case R.id.print_item:
                // do your code
                return true;
            case R.id.share_item:
                // do your code
                return true;
            case R.id.bookmark_item:
                // do your code
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}