package com.example.practica;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface font = Typeface.createFromAsset( getAssets(), "fonts/fontawesome-webfont.ttf" );
        Button button = (Button)findViewById( R.id.button );
        button.setTypeface(font);
    }
}