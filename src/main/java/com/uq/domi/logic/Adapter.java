package com.uq.domi.logic;

import java.util.ArrayList;

public class Adapter {
    private ArrayList<Producto> productosEscogidos = new ArrayList<>();
    private String c = " ";
    private String n = " ";
    private int v = 0;

    private Cliente cliente;
    private Repartidor repartidor = new Repartidor();
    private FastFood ff = new FastFood();
    private Pharmacy ph = new Pharmacy();

    public Adapter() {

    }

    //Metodo para agregar los datos del cliente al objeto cliente
    public void actualizarCliente(String nombre, String direccion, String telefono) {
        cliente = new Cliente(nombre, direccion, telefono);
        System.out.println(cliente.getNombre() + " " + cliente.getDireccion() + " " + cliente.getTelefono());
    }

    //Metodo para agregar los productos que escoja el cliente
    public void actualizarProductos(String codigo) {
        c = codigo;
        if (codigo.charAt(0) == 'F') {
            for (int i = 0; i < ff.getProductosFF().size(); i++) {
                if (ff.getProductosFF().get(i).getCodigo().equals(codigo)) {
                    n = ff.getProductosFF().get(i).getNombre();
                    v = ff.getProductosFF().get(i).getValUnitario();
                    productosEscogidos.add(new Producto(codigo, n, v));
                }
            }
        } else if (codigo.charAt(0) == 'P') {
            for (int i = 0; i < ph.getProductosPH().size(); i++) {
                if (ph.getProductosPH().get(i).getCodigo().equals(codigo)) {
                    n = ph.getProductosPH().get(i).getNombre();
                    v = ph.getProductosPH().get(i).getValUnitario();
                    productosEscogidos.add(new Producto(codigo, n, v));
                }
            }
        }
    }

    @Override
    public String toString() {
        String x = ".";
        for (int i = 0; i < productosEscogidos.size(); i++) {
            x = "Codigo: " + productosEscogidos.get(i).getCodigo() +
                    " Nombre: " + productosEscogidos.get(i).getNombre() +
                    " Valor Unitario: " + productosEscogidos.get(i).getValUnitario();
        }
        return x;
    }
}