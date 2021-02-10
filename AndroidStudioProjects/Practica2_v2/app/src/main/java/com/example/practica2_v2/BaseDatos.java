package com.example.practica2_v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
        nuevoRegistro.put("fecha", nota.getFech());
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
                String fecha = miCursor.getString(3);
                notas.add(new Encapsulador(id,titulo,contenido,fecha));
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
                String fecha = miCursor.getString(3);
                notas.add(new Encapsulador(id,tit,contenido,fecha));
            }while(miCursor.moveToNext());
        }
        return notas;
    }

    public void insertarCheckbox(Checkbox ck){
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("id", ck.getId());
        nuevoRegistro.put("contenido", ck.getContenido());
        nuevoRegistro.put("terminado", ck.getTerminado());
        db.insert("Checkbox",null, nuevoRegistro);
    }
    public void borrarCheckbox(Checkbox ck){
        db.execSQL("DELETE FROM Checkbox WHERE id ="+ck.getId());
    }
    public ArrayList<Checkbox> getCheckboxes(){
        //Retorna todas los checkboxes
        ArrayList<Checkbox> cks = new ArrayList<>();
        Cursor miCursor = db.rawQuery("SELECT * FROM Checkbox",null);
        if(miCursor.moveToFirst()){
            do{
                String id = miCursor.getString(0);
                String contenido = miCursor.getString(1);
                Integer bool = miCursor.getInt(2);
                Boolean terminado = false;
                if(bool == 1){
                    terminado = true;
                }
                cks.add(new Checkbox(id,contenido,terminado));
            }while(miCursor.moveToNext());
        }
        return cks;
    }
    public void modificarCheckbox(Checkbox ck){
        Integer term = 0;
        if(ck.getTerminado()){
            term = 1;
        }
        db.execSQL("UPDATE Checkbox SET terminado = '"+term+"' WHERE id = '"+ck.getId()+"'");
    }
}
