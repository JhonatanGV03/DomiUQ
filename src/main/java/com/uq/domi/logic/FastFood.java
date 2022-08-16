package com.uq.domi.logic;

import java.util.ArrayList;

public class FastFood extends Producto {
    private final ArrayList<FastFood> productosFF = new ArrayList<>();
    public FastFood(String codigo, String nombre, int valUnitario) {
        super(codigo, nombre, valUnitario);
    }
    public FastFood() {
        setProductosFF();
    }

    public ArrayList<FastFood> getProductosFF() {
        return productosFF;
    }

    private void setProductosFF() { //se llena el arraylist de productosFF
        this.productosFF.add(new FastFood("FF01", "Tacos", 20000 ));
        this.productosFF.add(new FastFood("FF02", "Pizza", 45000 ));
        this.productosFF.add(new FastFood("FF03", "Combo", 25500 ));
        this.productosFF.add(new FastFood("FF04", "Crepé", 10400 ));
        System.out.println(productosFF.get(0).getNombre()); //Prueba
    }
}
