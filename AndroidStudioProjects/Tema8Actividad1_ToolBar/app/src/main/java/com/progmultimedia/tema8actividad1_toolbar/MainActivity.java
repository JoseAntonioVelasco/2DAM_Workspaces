package com.progmultimedia.tema8actividad1_toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            //Back button
            case R.id.barra_nuevo:
                mensaje(R.string.cadena_barra_nuevo);
                return true;
            case R.id.barra_editar:
                mensaje(R.string.cadena_barra_editar);
                return true;
            case R.id.barra_acerca:
                mensaje(R.string.cadena_barra_acerca);
                return true;
            case R.id.barra_configurar:
                mensaje(R.string.cadena_barra_configurar);
                return true;
            case R.id.barra_ayuda:
                mensaje(R.string.cadena_barra_ayuda);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void mensaje(int id){
        String cadena = getString(id);
        Toast t = Toast.makeText(this,cadena,Toast.LENGTH_SHORT);
        t.show();
    }

}