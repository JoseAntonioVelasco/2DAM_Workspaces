package com.progmultimedia.tema9actividad3_progressbarthread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button)findViewById(R.id.button);
        ProgressBar pb = (ProgressBar)findViewById(R.id.progressBar);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                new Handler().postDelayed(new Runnable(){
                    public void run(){
                        pb.incrementProgressBy(50);
                    }
                },1000);
            }
        });
    }
}