package com.example.mytallerdomingo;



import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHoldeDatos> {


    Context context;
        ArrayList<Datos> listadatos;
        //rayList<Datos> listaOriginal;


    public Adaptador(Context context, ArrayList<Datos> listadatos) {
        this.context = context;
        this.listadatos = listadatos;
    }

    @NonNull
    @Override
    public Adaptador.ViewHoldeDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_2, null, false);
        return new ViewHoldeDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoldeDatos holder, int position) {
        holder.txtCodigo.setText(listadatos.get(position).getCodigo());
        holder.txtHora1.setText(listadatos.get(position).getHora());
        holder.txtPatente.setText(listadatos.get(position).getPatente());

    }



    @Override
    public int getItemCount() {
        return listadatos.size();
    }

    public class ViewHoldeDatos extends RecyclerView.ViewHolder {

        EditText txtCodigo,txtPatente, txtHora1;

        public ViewHoldeDatos(@NonNull View itemView) {
            super(itemView);


            txtCodigo = itemView.findViewById(R.id.txtCodigo);
             txtPatente= itemView.findViewById(R.id.txtPatente);
             txtHora1= itemView.findViewById(R.id.txtHora1);


        }



        }
    }























