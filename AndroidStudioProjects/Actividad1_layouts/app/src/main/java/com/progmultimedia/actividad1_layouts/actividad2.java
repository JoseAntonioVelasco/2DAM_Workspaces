package com.progmultimedia.actividad1_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class actividad2 extends AppCompatActivity {
    private View.OnClickListener corkyListener1 = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
        }
    };
    private View.OnDragListener corkyListener2 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            return false;
        }
    };
    private View.OnFocusChangeListener corkyListener3 = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {

        }
    };
    private View.OnKeyListener corkyListener4 = new View.OnKeyListener(){

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            return false;
        }
    };
    private View.OnLongClickListener corkyListener5 = new View.OnLongClickListener(){

        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    };
    private View.OnTouchListener corkyListener6 = new View.OnTouchListener(){

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act3_boton);


        Button button =(Button)findViewById(R.id.button);
        button.setOnClickListener(corkyListener1);
        button.setOnDragListener(corkyListener2);
    }
    protected void onDestroy() {
        super.onDestroy();
        Intent ejemplo = new Intent(this, actividad3.class);
        startActivity(ejemplo);
    }

}