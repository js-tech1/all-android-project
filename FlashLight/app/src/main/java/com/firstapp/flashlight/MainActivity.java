package com.firstapp.flashlight;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton toggleButton;

    boolean hasCameraFlash = false;

    boolean flashOn = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton = findViewById(R.id.toggleButton);

        hasCameraFlash = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if(hasCameraFlash){
                    if(flashOn){
                        flashOn = false;
                        toggleButton.setImageResource(R.drawable.onbutton);
                        try {
                            flashLighton();
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        flashOn = true;
                        toggleButton.setImageResource(R.drawable.offbutton);
                        try {
                            flashLightoff();
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "No Flash available on you device", Toast.LENGTH_SHORT).show();
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            private void flashLightoff()
                    throws CameraAccessException {
                CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                String cameraId = cameraManager.getCameraIdList()[0];
                try {
                    cameraManager.setTorchMode(cameraId,false);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this,"FlashLight is OFF", Toast.LENGTH_SHORT).show();

            }

        });
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private  void  flashLighton() throws CameraAccessException {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String cameraId = cameraManager.getCameraIdList()[0];
        try {
            cameraManager.setTorchMode(cameraId,true);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
        Toast.makeText(MainActivity.this,"FlashLight is ON", Toast.LENGTH_SHORT).show();

    }
}