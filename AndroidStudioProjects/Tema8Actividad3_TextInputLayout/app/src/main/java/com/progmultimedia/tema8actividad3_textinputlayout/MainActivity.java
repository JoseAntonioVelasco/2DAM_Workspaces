package com.progmultimedia.tema8actividad3_textinputlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout controlNombre;
    private EditText campoNombre;
    private TextInputLayout controlCorreo;
    private EditText campoCorreo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controlNombre = findViewById(R.id.control_nombre);
        campoNombre = findViewById(R.id.campo_nombre);
        controlCorreo = findViewById(R.id.control_correo);
        campoCorreo = findViewById(R.id.campo_correo);

        campoNombre.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                controlNombre.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        campoCorreo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                esCorreoValido(String.valueOf(s));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Button boton_aceptar = findViewById(R.id.boton_aceptar);
        Button boton_cancelar = findViewById(R.id.boton_cancelar);
        boton_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDatos();
            }
        });

    }
    private boolean esNombreValido(String nombre){
        return true;
    }
    private boolean esCorreoValido(String correo){
        if(!Patterns.EMAIL_ADDRESS.matcher(correo).matches()){
            System.out.println("email valido");
            return true;
        }else{
            return false;
        }
    }
    private void validarDatos(){
        String nombre = controlNombre.getEditText().getText().toString();
        String correo = controlCorreo.getEditText().getText().toString();
        boolean nombreValido = esNombreValido(nombre);
        boolean correoValido = esCorreoValido(correo);
        if(nombreValido && correoValido){
            Toast toast=Toast.makeText(getApplicationContext(),"Los datos son validos",Toast. LENGTH_SHORT);
            toast.show();
        }else{
            Toast toast=Toast.makeText(getApplicationContext(),"Los datos son validos",Toast. LENGTH_SHORT);
            toast.show();
        }
    }
}