package com.progmultimedia.tema10actividad4_investigasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db;
        UsuariosSQLiteHelper usuariosBBDD = new UsuariosSQLiteHelper(this,"DBUsuarios",null,1);
        db = usuariosBBDD.getWritableDatabase();
        db.execSQL("INSERT INTO Usuarios(codigo,nombre) VALUES(5, 'usuarioprueba')");

        //INSERTAR REGISROS
        Integer valor1 = 6;
        String valor2 = "usuariospruebas2";

        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("codigo", valor1);
        nuevoRegistro.put("nombre", valor2);
        db.insert("Usuarios",null, nuevoRegistro);

        //ELIMINAR REGISTROS
        db.execSQL("DELETE FROM Usuarios WHERE codigo = 5");//forma1
        db.delete("Usuarios","codigo="+valor1,null);//forma2

        //ACTUALIZAR REGISTROS
        db.execSQL("UPDATE Usuarios SET nombre='usunuevo' WHERE codigo =5");//forma1
        //forma2
        String nuevovalor2 = "usupdate";
        ContentValues valores = new ContentValues();
        valores.put("nomre",nuevovalor2);
        db.update("Usuarios",valores,"codigo="+valor1,null);

        //CONSULTAR REGISTROS
        TextView txtResultado = null;
        String[] args = new String[] {"5"};
        Cursor miCursor = db.rawQuery("SELECT codigo, nobmre FROM Usuarios WHERE codigo=? ",args);
        txtResultado.setText("");
        if(miCursor.moveToFirst()){
            do{
                String codigo = miCursor.getString(0);
                String nombre = miCursor.getString(1);
                txtResultado.append(" "+codigo+ " - "+ nombre+"\n");
            }while(miCursor.moveToNext());
        }

        //CONSULTAR REGISTROS FORMA2
        String[] args2 = new String[] {"5"};
        String[] campos = new String[]{"codigo","nombre"};
        Cursor miCursor2 = db.query(false, "Usuarios", campos, "codigo=?", args2, null, null, null, null);
        txtResultado.setText("");
        if(miCursor.moveToFirst()){
            do{
                String codigo = miCursor.getString(0);
                String nombre = miCursor.getString(1);
                txtResultado.append(" "+codigo+ " - "+nombre+"\n");
            }while(miCursor.moveToNext());
        }
    }
}