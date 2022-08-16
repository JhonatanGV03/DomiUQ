package com.uq.domi.logic;

public class Producto {
    private String codigo;
    private String nombre;
    private int valUnitario;
    public Producto(){
    }
    public Producto(String codigo, String nombre, int valUnitario) {
        this.nombre = nombre;
        this.valUnitario = valUnitario;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValUnitario() {
        return valUnitario;
    }
}
