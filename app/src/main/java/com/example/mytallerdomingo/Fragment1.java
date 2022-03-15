package com.example.mytallerdomingo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;


import java.util.Calendar;


public class Fragment1 extends  Fragment  {
    EditText txtCodigo;
    EditText txtPatente;
    CheckBox check1, check2, check3, check4, check5, check6,
     check7,check8, check9, check10, check11,check12,check13, check14,check15, check16, check17, check18, check19, check20, check21,check22;
     Button  btnDireccion,btnFreno,btnNeumaticos,btnSuspension,btnAlineacion,btnKit,btnPuertas,btnVidrios,btnTuboEscape,btnGases;
     Button btnGuardar;
    Button btnFecha1;
    Button btnHora1;
    Button btnBuscar;
    EditText txtFecha1;
    Button btnBuscar2;
    RecyclerView ListaContacto;


    EditText txtHora1;
 int dia, mes , anio, hora, minuto;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View v = inflater.inflate(R.layout.fragment_1, container, false);

        txtFecha1 = v.findViewById(R.id.txtFecha1);
        btnFecha1 = v.findViewById(R.id.btnFecha1);
        txtHora1  = v.findViewById(R.id.txtHora1);
        btnHora1  = v.findViewById(R.id.btnHora1);
        txtCodigo = v.findViewById(R.id.txtCodigo);
        txtPatente= v.findViewById(R.id.txtPatente);
        btnGuardar =v.findViewById(R.id.btnGuardar);
        btnBuscar = v.findViewById(R.id.btnBuscar3);
        btnBuscar2 = v.findViewById(R.id.btnBuscar3);


       btnHora1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               mostrarHora();
           }
       });

       btnGuardar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               guardar();
           }
       });
       btnBuscar.setOnClickListener(new View.OnClickListener() {
           @Override
          public void onClick(View view) {
               buscar();
           }
       });

        btnFecha1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(), "Hola :D", Toast.LENGTH_SHORT).show();
                mostrarFecha();
                //mostrarHora();
            }
        });


        // Inflate the layout for this fragment
        return v;

    }



    public void  mostrarFecha(){

        Calendar c = Calendar.getInstance();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH);
        anio = c.get(Calendar.YEAR);
        DatePickerDialog   datePickerDialog =  new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                txtFecha1.setText(i + "-" + (i1+1 + "-" + i2));
            }
        },anio,mes,dia);
      datePickerDialog.show();


    }
    public void  mostrarHora(){


        Calendar c = Calendar.getInstance();
        hora = c.get(Calendar.HOUR_OF_DAY);
        minuto = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                txtHora1.setText(i + ":" + i1);
            }
        }, hora, minuto, true);

        timePickerDialog.show();


    }
    public void guardar(){
        ConexionBD conexion = new ConexionBD(getContext(), "administracion", null, 1);
        SQLiteDatabase bd = conexion.getWritableDatabase();

        String codigo = txtCodigo.getText().toString();
        String fecha =  txtFecha1.getText().toString();
        String hora =   txtHora1.getText().toString();
        String patente = txtPatente.getText().toString();


        ContentValues registro = new ContentValues();
        registro.put("codigo", codigo);
        registro.put("fecha", fecha);
        registro.put("hora", hora);
        registro.put("patente",patente);

        bd.insert("datosrevision", null, registro);
        bd.close();

        txtCodigo.setText("");
        txtFecha1.setText("");
        txtHora1.setText("");
        txtPatente.setText("");

        Toast.makeText(getContext(), "Registrado correctamente", Toast.LENGTH_SHORT).show();
    }

    public void buscar(){
        ConexionBD conexion = new ConexionBD(getContext(), "administracion", null, 1);
        SQLiteDatabase bd = conexion.getWritableDatabase();

        String codigo = txtCodigo.getText().toString();

        Cursor fila = bd.rawQuery("SELECT fecha, hora,patente FROM datosrevision WHERE codigo='"+codigo+"'", null);

        if(fila.moveToFirst()){
           txtFecha1.setText(fila.getString(0));
            txtHora1.setText(fila.getString(1));
            txtPatente.setText(fila.getString(2));
            bd.close();
            Toast.makeText(getContext(), "Producto encontrado!", Toast.LENGTH_SHORT).show();
       }
        else{
            bd.close();
           Toast.makeText(getContext(), "No se encuentra el producto", Toast.LENGTH_SHORT).show();
            txtCodigo.setText("");
           txtFecha1.setText("");
            txtHora1.setText("");
            txtPatente.setText("");

        }
    }


 }