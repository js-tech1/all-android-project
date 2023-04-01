package com.example.mymediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button start,pause,stop,On;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(Button)findViewById(R.id.button1);
        pause=(Button)findViewById(R.id.button2);
        stop=(Button)findViewById(R.id.button3);
        On=(Button) findViewById(R.id.button4);
        //creating media player
        final MediaPlayer mp=new MediaPlayer();
        try{
            mp.setDataSource("sdcard/Music/deep.mp3");
            mp.prepare();
            mp.start();

        }catch(Exception e){e.printStackTrace();}
        On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    mp.setDataSource("sdcard/Music/deep.mp3");
                    mp.prepare();
                    mp.start();

                }catch(Exception e){e.printStackTrace();}
            }
        });

       start.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mp.start();
           }
       });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
            }
        });
    }
}
