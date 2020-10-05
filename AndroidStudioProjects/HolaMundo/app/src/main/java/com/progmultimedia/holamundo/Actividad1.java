package com.progmultimedia.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class Actividad1 extends AppCompatActivity {
    private static final int REQUEST_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ejemplo","Estoy onStart");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Intent ejemplo = new Intent(this, Actividad2.class);
        //startActivity(ejemplo);

        Intent ejemplo = new Intent(this, Actividad2.class);
        this.startActivityForResult(ejemplo, REQUEST_CODE);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("RETORNO")) {
                //codigo
            }
        }
    }
}