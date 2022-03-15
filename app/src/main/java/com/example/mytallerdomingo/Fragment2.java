package com.example.mytallerdomingo;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Fragment2 extends Fragment  {
    //Button btnBuscar3;
    EditText txtModificar;
    EditText txtHora1;

    EditText txtCodigo2;
    EditText txtPatente;
    CheckBox check1, check2, check3, check4, check5, check6,
            check7, check8, check9, check10, check11, check12, check13, check14, check15, check16, check17, check18, check19, check20, check21, check22;
    Button btnDireccion, btnFreno, btnNeumaticos, btnSuspension, btnAlineacion, btnKit, btnPuertas, btnVidrios, btnTuboEscape, btnGases;
    Button btnGuardar;
    Button btnFecha1;
    Button btnHora1;
    Button btnBuscar3;
    EditText txtFecha1;

    ListView lstLista;
    Adaptador adaptador;
    EditText txtBuscar;
    RecyclerView listaContactos;
    //Registro Registro;

     ArrayList<Datos> listaArrayRegistro= new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_2, container, false);
        // Registro = v.findViewById(R.id.R);
        txtFecha1 = v.findViewById(R.id.txtFecha1);
        btnFecha1 = v.findViewById(R.id.btnFecha1);
        txtHora1 = v.findViewById(R.id.txtHora1);
        btnHora1 = v.findViewById(R.id.btnHora1);
        txtCodigo2 = v.findViewById(R.id.txtCodigo2);
        txtPatente = v.findViewById(R.id.txtPatente);
        btnGuardar = v.findViewById(R.id.btnGuardar);
        listaContactos= v.findViewById(R.id.listaDatos);

        //listaContactos = v.findViewById(R.id.listaContactos);
        btnBuscar3= v.findViewById(R.id.btnBuscar3);
       // listaContactos.setLayoutManager(new LinearLayoutManager(getContext()));
        // DbContacto dbContacto = new DbContacto(Fragment2.this);

        //listaArrayRegistro = new ArrayList<>();
        //adaptador =new Adaptador(DbContacto.





        btnBuscar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Hola :D", Toast.LENGTH_SHORT).show();
                buscar();
            }


        });


        // Inflate the layout for this fragment
        return v;


    }


    public void buscar(){
        ConexionBD conexion = new ConexionBD(getContext(), "administracion", null, 1);
        SQLiteDatabase bd = conexion.getWritableDatabase();

        String codigo = txtCodigo2.getText().toString();

        Cursor fila = bd.rawQuery("SELECT fecha, hora,patente FROM datosrevision WHERE codigo='"+codigo+"'", null);

        if(fila.moveToFirst()){
            listaArrayRegistro.add(new Datos(codigo,fila.getString(0), fila.getString(1), fila.getString(2) ));
            adaptador= new Adaptador(getContext(),listaArrayRegistro);
            LinearLayoutManager  layoutManager=new LinearLayoutManager(getContext());
            listaContactos.setLayoutManager(layoutManager);
            listaContactos.setAdapter(adaptador);
            bd.close();

        }
        else{
            bd.close();
            Toast.makeText(getContext(), "No se encuentra el producto", Toast.LENGTH_SHORT).show();

            //listaContactos.setAdapter(adaptador);

        }
    }




//listaArrayRegistro = new ArrayList<>();
//adaptador =new Adaptador(dbContacto.mostrarContactos());
//ListaContacto.setAdapter(adaptador);


}
