package com.example.myprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnStartProgress;
    ProgressDialog progressBar;
    private int progressBarStatus = 0;
    private Handler progressBarHandler = new Handler();
    private long fileSize = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }
    public void addListenerOnButtonClick() {
        btnStartProgress = findViewById(R.id.button1);
        btnStartProgress.setOnClickListener(new View.OnClickListener(){  @Override
        public void onClick(View v) {
            // creating progress bar dialog
            progressBar = new ProgressDialog(v.getContext());
            progressBar.setCancelable(true);
            progressBar.setMessage("File downloading ...");
            progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressBar.setProgress(0);
            progressBar.setMax(100);
            progressBar.show();
            //reset progress bar and filesize status
            progressBarStatus = 0;
            fileSize = 0;
            new Thread(new Runnable() {
                public void run() {
                    while (progressBarStatus < 100) {
                        // performing operation
                        progressBarStatus = doOperation();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        progressBarHandler.post(new Runnable() {
                            public void run() {
                                progressBar.setProgress(progressBarStatus);
                            }
                        });
                    }
                    // performing operation if file is downloaded,
                    if (progressBarStatus >= 100) {
                        // sleeping for 1 second after operation completed
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // close the progress bar dialog
                        progressBar.dismiss();
                    }
                }
            }).start();
        }//end of onClick method
        });
    }

    public int doOperation() {
        //The range of ProgressDialog starts from 0 to 10000
        while (fileSize <= 10000) {
            fileSize++;
            if (fileSize == 1000) {
                return 10;
            } else if (fileSize == 2000) {
                return 20;
            } else if (fileSize == 3000) {
                return 30;
            } else if (fileSize == 4000) {
                return 40;
            }
            else if (fileSize == 4500) {
                return 45;
            }
            else if (fileSize == 5000) {
                return 50; // you can add more else if
            }
            else if (fileSize == 5500) {
                return 55; // you can add more else if
            }
            else if (fileSize == 6000) {
                return 60;
            }
            else if (fileSize == 7000) {
                return 70;
            }
            else if (fileSize == 8000) {
                return 80;
            }
            else if (fileSize == 9000) {
                return 90;
            }
            else if (fileSize == 10000) {
                return 100;
            }
        }
        return 100;
    }
}