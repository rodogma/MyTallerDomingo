package com.example.mytallerdomingo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;





    public class ConexionBD extends SQLiteOpenHelper {




        private static  final  int DATABASE_VERSION =2;
        private static  final String DATABASE_NOMBRE ="administracion";
        public  static  final String TABLE_DATOS= "t_datos";


        public ConexionBD(@Nullable Context context) {
            super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
        }


        public ConexionBD(Context context, String administracion, Object o, int i) {
            super(context,administracion, (SQLiteDatabase.CursorFactory) o,i);
        }

        @Override
        public void onCreate(SQLiteDatabase bd) {
            bd.execSQL("create table datosrevision(codigo int primary key,fecha date, hora datetime,patente int,direccion boolean,frenos Boolean,neumaticos Boolean,suspencion Boolean,alineacion Boleean,seguridad Boolean,cinturon Boolean,Luces Boolean,puertas  Boolean,vidrios Boleean,tubo_escape Boolean,gases Boolean )");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


        }
}
