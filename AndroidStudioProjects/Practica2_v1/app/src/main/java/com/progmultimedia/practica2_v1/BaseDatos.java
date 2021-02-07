package com.progmultimedia.practica2_v1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;

import java.util.ArrayList;

public class BaseDatos {
    private SQLiteDatabase db;
    private UsuariosSQLiteHelper usuariosBBDD;
    public void crearBaseDatos(Context contexto, String nombre_basedatos){
        usuariosBBDD = new UsuariosSQLiteHelper(contexto,nombre_basedatos,null,1);
        db = usuariosBBDD.getWritableDatabase();
    }
    //TODO No SQL injection Safe en la siguiente update se parchea :)
    public void insertarNota(Encapsulador nota){
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("id", nota.getId());
        nuevoRegistro.put("titulo", nota.getTitulo());
        nuevoRegistro.put("contenido", nota.getTexto());
        db.insert("Nota",null, nuevoRegistro);
    }
    public void modificarNota(Encapsulador nota){
        db.execSQL("UPDATE Nota SET titulo = '"+nota.getTitulo()+"', contenido = '"+nota.getTexto()+"' WHERE id = '"+nota.getId()+"'");
    }
    public void borrarNota(Encapsulador nota){
        db.execSQL("DELETE FROM Nota WHERE id ="+nota.getId());
    }

    public ArrayList<Encapsulador> getNotas(){
        //Retorna todas las notas
        ArrayList<Encapsulador> notas = new ArrayList<>();
        Cursor miCursor = db.rawQuery("SELECT * FROM Nota",null);
        if(miCursor.moveToFirst()){
            do{
                String id = miCursor.getString(0);
                String titulo = miCursor.getString(1);
                String contenido = miCursor.getString(2);
                notas.add(new Encapsulador(id,titulo,contenido));
            }while(miCursor.moveToNext());
        }
        return notas;
    }
    public ArrayList<Encapsulador> getNotas(String titulo){
        //Retorna todas las notas que tengan ese titulo
        ArrayList<Encapsulador> notas = new ArrayList<>();
        String[] args = new String[] {titulo.concat("%")};
        Cursor miCursor = db.rawQuery("SELECT * FROM Nota WHERE titulo LIKE ?",args);
        if(miCursor.moveToFirst()){
            do{
                String id = miCursor.getString(0);
                String tit = miCursor.getString(1);
                String contenido = miCursor.getString(2);
                notas.add(new Encapsulador(id,tit,contenido));
            }while(miCursor.moveToNext());
        }
        return notas;
    }
}
