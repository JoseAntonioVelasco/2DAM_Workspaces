package com.progmultimedia.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class Actividad2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        //Intent ejemplo = new Intent(Intent.ACTION_VIEW);
        //ejemplo.setData(Uri.parse("http://www.google.es"));

        Intent intent = new Intent(this,Actividad3.class);
        PendingIntent miPending = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarma = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarma.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (5*1000), miPending);

        startActivity(intent);
       // startActivity(ejemplo);
    }
    @Override
    public void finish(){
        Intent data = new Intent();
        data.putExtra("RETORNO","Este es el valor de retorno");
        setResult(RESULT_OK, data);
        super.finish();
    }
}