package com.uq.domi.logic;

import java.util.ArrayList;

public class Pharmacy extends Producto {
    private final ArrayList<Pharmacy> productosPH = new ArrayList<>();
    public Pharmacy(String codigo, String nombre, int valUnitario) {
        super(codigo, nombre, valUnitario);
    }
    public Pharmacy(){
        setProductosFF();
    }
    public ArrayList<Pharmacy> getProductosPH() {
        return productosPH;
    }
    private void setProductosFF() {
        this.productosPH.add(new Pharmacy("PH01", "Pedialyte", 7650 ));
        this.productosPH.add(new Pharmacy("PH02", "Termometro", 14000 ));
        this.productosPH.add(new Pharmacy("PH03", "Ensure Advance", 8200 ));
        this.productosPH.add(new Pharmacy("PH04", "Aspirina 100", 13000 ));
    }
}
