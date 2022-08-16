package com.uq.domi.logic;

import javafx.scene.text.Text;

import java.util.ArrayList;

public class Adapter {
    private ArrayList<Producto> productosEscogidos = new ArrayList<>();

    private Cliente cliente;
    private final Repartidor repartidor = new Repartidor();
    private final FastFood ff = new FastFood();
    private final Pharmacy ph = new Pharmacy();

    public Adapter() {

    }

    //Metodo para agregar los datos del cliente al objeto cliente
    public void actualizarCliente(String nombre, String direccion, String telefono) {
        cliente = new Cliente(nombre, direccion, telefono);
        System.out.println(cliente.getNombre() + " " + cliente.getDireccion() + " " + cliente.getTelefono());
    }

    //Metodo para agregar los productos que escoja el cliente
    public void actualizarProductos(String codigo) {
        String n;
        int v;
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

    //Metodo para llenar datos de Factura
    public void actualizarFactura(Text codigo, Text producto, Text valor, Text cantidad, Text total){
        int totalFactura = 0;
        String vUnitario = "";
        String codigos = "";
        String productos = "";
        for(int i = 0; i < productosEscogidos.size(); i++){
            totalFactura += productosEscogidos.get(i).getValUnitario();
            codigos += productosEscogidos.get(i).getCodigo() + "\n";
            productos += productosEscogidos.get(i).getNombre() + "\n";
            vUnitario += productosEscogidos.get(i).getValUnitario() + "\n";
        }
        codigo.setText(codigos + repartidor.getDomiId());
        producto.setText(productos + "Costo de envío");
        valor.setText(vUnitario + "6000");
        cantidad.setText(String.valueOf(productosEscogidos.size()));
        total.setText("$"+(totalFactura+6000));
    }

    //Metodo para llenar datos de cliente y repartidor
    public void actualizarDatosEnvio(Text nombreR, Text domiId, Text matricula, Text contactoR,
                                     Text nombre, Text direccion, Text telefono){
        nombreR.setText(repartidor.getNombre());
        domiId.setText(repartidor.getDomiId());
        matricula.setText(repartidor.getMatricula());
        contactoR.setText(repartidor.getTelefono());
        nombre.setText(cliente.getNombre());
        direccion.setText(cliente.getDireccion());
        telefono.setText(cliente.getTelefono());
    }
    @Override
    public String toString() {
        String x    ;
        int t = productosEscogidos.size()-1;
        x = "Codigo: " + productosEscogidos.get(t).getCodigo() +
                " Nombre: " + productosEscogidos.get(t).getNombre() +
                " Valor Unitario: " + productosEscogidos.get(t).getValUnitario();
        return x;
    }
}