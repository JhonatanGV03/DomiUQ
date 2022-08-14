package com.uq.domi.logic;

public class Cliente extends Persona {
    private String direccion;

    public Cliente(String nombre, String direccion, String telefono) {
        super(nombre, telefono);
        this.direccion = direccion;
    }
    public Cliente() {
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
