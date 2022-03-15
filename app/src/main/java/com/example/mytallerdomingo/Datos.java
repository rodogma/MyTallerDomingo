package com.example.mytallerdomingo;

public class Datos {
private String codigo;
private String fecha;
private  String hora;
private String  patente;

    public Datos(String codigo, String fecha, String hora, String patente) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.patente = patente;
    }

    public Datos() {

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
}
