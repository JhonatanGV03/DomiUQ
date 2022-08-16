package com.uq.domi;

import com.uq.domi.logic.Adapter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DomiController {

    //Variables
    private String nombre = "";
    private String direccion = "";
    private String telefono = "";
    private Adapter adapter = new Adapter();

    //Identificadores de las ventanas de la interfaz
    @FXML
    private Pane inicioPane;
    @FXML
    private Pane datosPane;
    @FXML
    private Pane categoriaPane;
    @FXML
    private Pane fastFoodPane;
    @FXML
    private Pane pharmacyPane;
    @FXML
    private Pane finalizarPane;
    private Stage stage;

    //Inicio
    @FXML
    void onActionBotonIniciar() { //Cambia de ventana de inicio a la de datos
        inicioPane.setVisible(false);
        inicioPane.setDisable(true);
        datosPane.setDisable(false);
        datosPane.setVisible(true);
        stage =(Stage) datosPane.getScene().getWindow();
        stage.setTitle("DOMI - Datos");

    }
    @FXML
    void onActionSalir() { //Cierra la aplicación
        System.exit(0);
    }

    //Datos
    //Identificadores de los campos de texto y boton de la interfaz en la ventana de datos
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtAdress;
    @FXML
    private TextField txtNumber;
    @FXML
    private Button botonSiguiente;

    @FXML
    void saveName() {//Guarda el nombre del cliente en la variable nombre y enfoca el siguiente campo de texto
        txtAdress.requestFocus();
        nombre = txtName.getText();
        System.out.println("Nombre: "+nombre);
    }
    @FXML
    void saveAddress() { //Guarda la dirección del cliente en la variable direccion y enfoca el siguiente campo de texto
        direccion = txtAdress.getText();
        txtNumber.requestFocus();
        System.out.println("Dirección: "+direccion);
    }
    @FXML
    void saveNumber() { //Guarda el número de teléfono del cliente en la variable telefono y el botonContinuar
        botonSiguiente.requestFocus();
        telefono = txtNumber.getText();
        System.out.println("Numero de Teléfono: "+telefono);
    }
    @FXML
    void onActionBotonSiguiente() { //Cambia de ventana de datos a la de categoría siempre y cuando los datos sean ingresados
                                    //y actualiza los datos del cliente con ayuda del adaptador
        if (nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty()) {
            System.out.println("No se puede continuar");
        } else {
            datosPane.setVisible(false);
            datosPane.setDisable(true);
            categoriaPane.setDisable(false);
            categoriaPane.setVisible(true);
            stage =(Stage) categoriaPane.getScene().getWindow();
            stage.setTitle("DOMI - Categorías");
        }
        adapter.actualizarCliente(nombre, direccion, telefono);
    }


    //Categorias
    @FXML
    void showFastFood() { //Cambia de ventana de categoría a la de fast food
        categoriaPane.setVisible(false);
        categoriaPane.setDisable(true);
        fastFoodPane.setDisable(false);
        fastFoodPane.setVisible(true);
        stage =(Stage) fastFoodPane.getScene().getWindow();
        stage.setTitle("DOMI - Fast Food");
    }
    @FXML
    void showPharmacy() { //Cambia de ventana de categoría a la de farmacia
        categoriaPane.setVisible(false);
        categoriaPane.setDisable(true);
        pharmacyPane.setDisable(false);
        pharmacyPane.setVisible(true);
        stage =(Stage) pharmacyPane.getScene().getWindow();
        stage.setTitle("DOMI - Pharmacy");
    }

    //FastFood

    //Las siguienres acciones agregan un producto a la lista de productos con ayuda del
    // adaptador enviando el codigo del producto
    @FXML
    void onActionPizza() {
        adapter.actualizarProductos("FF02");
        System.out.println(adapter.toString());
    }
    @FXML
    void onActionCombo() {
        adapter.actualizarProductos("FF03");
        System.out.println(adapter.toString());
    }
    @FXML
    void onActionCrepes() {
        adapter.actualizarProductos("FF04");
        System.out.println(adapter.toString());
    }
    @FXML
    void onActionTacos() {
        adapter.actualizarProductos("FF01");
        System.out.println(adapter.toString());
    }

    //Pharmacy
    @FXML
    void onActionEnsure() {
        adapter.actualizarProductos("PH03");
        System.out.println(adapter.toString());
    }
    @FXML
    void onActionAspirina() {
        adapter.actualizarProductos("PH04");
        System.out.println(adapter.toString());
    }
    @FXML
    void onActionTermometro() {
        adapter.actualizarProductos("PH02");
        System.out.println(adapter.toString());
    }
    @FXML
    void onActionPedialyte() {
        adapter.actualizarProductos("PH01");
        System.out.println(adapter.toString());
    }
    @FXML
    void onActionBotonAtras() { //Cambia la ventana actual a la de categoria
        if(fastFoodPane.isVisible()){
            fastFoodPane.setVisible(false);
            fastFoodPane.setDisable(true);
        } else if (pharmacyPane.isVisible()) {
            pharmacyPane.setVisible(false);
            pharmacyPane.setDisable(true);
        }
        categoriaPane.setDisable(false);
        categoriaPane.setVisible(true);
        stage =(Stage) categoriaPane.getScene().getWindow();
        stage.setTitle("DOMI - Categorías");
    }

    //pantalla Final

    //Identificadores de los campos de texto y boton de la interfaz en la ventana de finalizar
    @FXML
    private Text txtCodigo;
    @FXML
    private Text txtCantidad;
    @FXML
    private Text txtProducto;
    @FXML
    private Text txtValor;
    @FXML
    private Text txtTotal;
    @FXML
    private Text txtNombreR;
    @FXML
    private Text txtId;
    @FXML
    private Text txtMatricula;
    @FXML
    private Text txtContactoR;
    @FXML
    private Text txtNombreC;
    @FXML
    private Text txtContacto;
    @FXML
    private Text txtDireccion;

    @FXML
    void onActionFinalizar() { //Cambia la ventana actual (Pharmacy, FastFood o Categoría) a la de
        // finalizar y actualiza todos los campos de texto (lista de productos y datos del cliente y repartidor)
        if (categoriaPane.isVisible()){
            categoriaPane.setVisible(false);
            categoriaPane.setDisable(true);
        } else if (fastFoodPane.isVisible()) {
            fastFoodPane.setVisible(false);
            fastFoodPane.setDisable(true);
        } else if (pharmacyPane.isVisible()) {
            pharmacyPane.setVisible(false);
            pharmacyPane.setDisable(true);
        }
        finalizarPane.setDisable(false);
        finalizarPane.setVisible(true);
        stage =(Stage) finalizarPane.getScene().getWindow();
        stage.setTitle("DOMI - Resumen");

        adapter.actualizarFactura(txtCodigo, txtProducto, txtValor, txtCantidad, txtTotal);
        adapter.actualizarDatosEnvio(txtNombreR, txtId, txtMatricula, txtContactoR, txtNombreC, txtDireccion, txtContacto);
    }

}