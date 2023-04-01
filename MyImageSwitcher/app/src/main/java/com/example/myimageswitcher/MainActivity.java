package com.example.myimageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    ImageButton button1,button2;
    ImageSwitcher imageSwitcher;
    int index=0;
    int gorseller[] ={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img2};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        imageSwitcher = findViewById(R.id.imageSwitcher);

        button1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 imageSwitcher.setInAnimation(MainActivity.this,R.anim.right);
                 imageSwitcher.setOutAnimation(MainActivity.this,R.anim.to_left);
                 --index;
                 if (index<0){
                     index=gorseller.length-1;
                 }
                 imageSwitcher.setImageResource(gorseller[index]);
             }
         });
         button2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 imageSwitcher.setInAnimation(MainActivity.this,R.anim.left);
                 imageSwitcher.setOutAnimation(MainActivity.this,R.anim.to_right);
                 index++;
                 if (index == gorseller.length){
                     index=0;
                 }
                 imageSwitcher.setImageResource(gorseller[index]);
             }
         });
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setMaxWidth(250);
                imageView.setMaxWidth(250);
                return imageView;
            }
        });
        imageSwitcher.setImageResource(gorseller[index]);
    }
}