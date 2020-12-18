package com.progmultimedia.tema9actividad3_progressbarthread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Thread t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.button);
        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        /*Timer timer = new Timer();
                        timer.scheduleAtFixedRate(new TimerTask() {
                            @Override
                            public void run() {
                                pb.incrementProgressBy(50);
                            }
                        }, 1000, 1000);*/
                        iniciarProgreso(pb);
                    }
                }, 0);
            }
        });
    }

    public void iniciarProgreso(ProgressBar pb) {
        pb.setProgress(0);
        t = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 20; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //ENLACE MEDIANTE post
                    pb.post(new Runnable() {
                        @Override
                        public void run() {
                            pb.incrementProgressBy(50);
                        }
                    });
                    //ENLACE MEDIANTE runOnUIThread
                    /*runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            pb.incrementProgressBy(50);
                        }
                    });*/
                }
            }
        };
        t.start();
    }
}