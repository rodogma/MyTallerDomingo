package com.example.mytallerdomingo;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbContacto extends ConexionBD {
    Context context;


    public DbContacto(@Nullable Context context, Context context1) {
        super(context);
        this.context = context1;
    }



// private static Context getContext() {
       /// return null;
    //}


    public long insertarDatos(String codigo, String fecha, String hora) {

            long id = 0;

            try {
                ConexionBD conexionBD = new ConexionBD(context);
                SQLiteDatabase db = conexionBD.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("codigo", codigo);
                values.put("fecha", fecha);
                values.put("hora", hora);

                id = db.insert("datosrevision", null, values);
            } catch (Exception ex) {
                ex.toString();
            }

            return id;
        }

        public ArrayList<Datos> mostrarDatos() {

            ConexionBD conexionBD = new ConexionBD(context);
            SQLiteDatabase db = conexionBD.getWritableDatabase();

            ArrayList<Datos> listaDatos = new ArrayList<>();

            Datos datos;
            Cursor cursorDatos;

            cursorDatos = db.rawQuery("SELECT * FROM datosrevision ORDER BY nombre ASC", null);

            if (cursorDatos.moveToFirst()) {
                do {
                    datos = new Datos();
                    datos.setCodigo(cursorDatos.getString(0));
                    datos.setFecha(cursorDatos.getString(1));
                    datos.setHora(cursorDatos.getString(2));
                    datos.setPatente(cursorDatos.getString(3));
                    listaDatos.add(datos);
                } while (cursorDatos.moveToNext());
            }

            cursorDatos.close();

            return listaDatos;
        }


    }

