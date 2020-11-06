package com.progmultimedia.tema7actividades;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t7a4_principal);

        /*t7a1
        Button boton = (Button)findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,t7a1_preferences.class));
            }
        });

        Button boton2 = (Button)findViewById(R.id.button2);
        boton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                Log.i("","Opcion 1: "+ pref.getBoolean("clave1", false));
                Log.i("","Opcion 2: "+ pref.getString("clave2","No asignada"));
                Log.i("","Opcion 3: "+ pref.getString("clave3", "No asignada"));
            }
        });
        t7a1*/

        /*t7a2
        Button boton = (Button) findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast toast = new Toast(getApplicationContext());

                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.t7a2_toast, (ViewGroup) findViewById(R.id.lytLayout));

                TextView txtMsg = (TextView)layout.findViewById(R.id.texto2);
                txtMsg.setText("TOAST PERSONALIZADO");
                toast.setGravity(Gravity.CENTER | Gravity.CENTER,0,0);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();
            }
        });
        t7a2*/

        /*t7a3
            /*editText
            final EditText editText = (EditText) findViewById(R.id.editText);
            editText.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Toast toast = new Toast(getApplicationContext());

                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.t7a2_toast, (ViewGroup) findViewById(R.id.lytLayout));

                    TextView txtMsg = (TextView)layout.findViewById(R.id.texto2);
                    txtMsg.setText(editText.getText());
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER,0,0);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setView(layout);
                    toast.show();
                }
            });
            editText*/

            /*seekbar
                final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

                Button boton = (Button) findViewById(R.id.button);
                boton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Toast toast = new Toast(getApplicationContext());

                        LayoutInflater inflater = getLayoutInflater();
                        View layout = inflater.inflate(R.layout.t7a2_toast, (ViewGroup) findViewById(R.id.lytLayout));

                        TextView txtMsg = (TextView)layout.findViewById(R.id.texto2);
                        txtMsg.setText("TOAST PERSONALIZADO");

                        toast.setGravity(Gravity.CENTER | Gravity.CENTER,0,seekBar.getProgress());
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.setView(layout);
                        toast.show();
                    }
                });
            seekbar*/
        /*t7a3*/

        /*t7a4*/
        Button boton = (Button) findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                /*builder.setMessage("EJEMPLO DE DIALOGO")
                        .setTitle("TITULO DEL DIALOGO")
                        .setIcon(R.mipmap.ic_launcher);
                   builder.setPositiveButton("PRIMERO",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast toast = Toast.makeText(MainActivity.this, "TOCADO BOTON POSITIVO", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    });
                    builder.setNegativeButton("SEGUNDO",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast toast = Toast.makeText(MainActivity.this, "TOCADO BOTON NEGATIVO", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    });
                    builder.setNeutralButton("TERCERO",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast toast = Toast.makeText(MainActivity.this, "TOCADO BOTON NEUTRO", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    });*/

                    final CharSequence[] elementos = {"CASO 0", "CASO 1", "CASO 2","CASO 3", "CASO 4","CASO 5"};
                    builder.setItems(elementos, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast toast = Toast.makeText(MainActivity.this, "TOCADO "+elementos[which], Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    });
                    AlertDialog dialogo = builder.create();
                    dialogo.show();
            }
        });
        /*t7a4*/

        /*t7a5
        Button boton = (Button) findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 final Calendar calen = Calendar.getInstance();
                 int year = calen.get(Calendar.YEAR);
                 int month = calen.get(Calendar.MONTH);
                 int day = calen.get(Calendar.DAY_OF_MONTH);

                 DatePickerDialog fecha = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                     @Override
                     public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                         Toast toast = Toast.makeText(MainActivity.this, "FECHA: A:" + year + " M:" + month + " D:" + dayOfMonth, Toast.LENGTH_SHORT);
                         toast.show();
                     }
                 }, year, month, day);
                 fecha.show();
             }
         });
       t7a5*/

    }
}