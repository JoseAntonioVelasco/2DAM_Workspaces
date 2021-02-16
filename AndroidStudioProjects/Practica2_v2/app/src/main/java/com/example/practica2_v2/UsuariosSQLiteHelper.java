package com.example.practica2_v2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UsuariosSQLiteHelper extends SQLiteOpenHelper {
    //Strings de creacion de tablas en la base de datos
    String sqlCreateTableNota = "CREATE TABLE Nota(id TEXT PRIMARY KEY, titulo TEXT, contenido TEXT, fecha TEXT)";
    String sqlCreateTableCheckbox = "CREATE TABLE Checkbox(id TEXT PRIMARY KEY, contenido TEXT, terminado INTEGER)";
    String sqlDeleteNota = "DROP TABLE IF EXISTS nota";
    String sqlDeleteCheckbox = "DROP TABLE IF EXISTS Checkbox";
    public UsuariosSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //las tablas que queramos crear se añaden aqui
        db.execSQL(sqlCreateTableNota);
        db.execSQL(sqlCreateTableCheckbox);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //actualizacion de la base de datos
        db.execSQL(sqlDeleteNota);
        db.execSQL(sqlDeleteCheckbox);
        db.execSQL(sqlCreateTableNota);
        db.execSQL(sqlCreateTableCheckbox);
        onCreate(db);
    }
}
