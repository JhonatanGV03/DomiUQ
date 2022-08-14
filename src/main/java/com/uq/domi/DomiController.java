package com.uq.domi;

import com.uq.domi.logic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class DomiController {

    //Variables
    private String nombre = "";
    private String direccion = "";
    private String telefono = "";

    //private ArrayList<Producto> productosEscogidos = new ArrayList<>();
    private Adapter adapter = new Adapter();

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

    //Inicio
    @FXML
    void onActionBotonIniciar(ActionEvent event) {
        inicioPane.setVisible(false);
        inicioPane.setDisable(true);
        datosPane.setDisable(false);
        datosPane.setVisible(true);
    }
    @FXML
    void onActionSalir(ActionEvent event) {
        System.exit(0);
    }

    //Datos
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtAdress;
    @FXML
    private TextField txtNumber;
    @FXML
    private Button botonSiguiente;

    @FXML
    void saveName(ActionEvent event) {//Variable nombre cliente
        txtAdress.requestFocus();
        nombre = txtName.getText();
        System.out.println("Nombre: "+nombre);
    }
    @FXML
    void saveAdress() {
        direccion = txtAdress.getText();  //Variable dirección cliente
        txtNumber.requestFocus();
        System.out.println("Dirección: "+direccion);
    }
    @FXML
    void saveNumber() {
        botonSiguiente.requestFocus();
        telefono = txtNumber.getText();
        System.out.println("Numero de Teléfono: "+telefono);
    }
    @FXML
    void onActionBotonSiguiente(ActionEvent event) {
        datosPane.setDisable(true);
        datosPane.setVisible(false);
        categoriaPane.setDisable(false);
        categoriaPane.setVisible(true);
        adapter.actualizarCliente(nombre, direccion, telefono);
    }


    //Categorias
    //Accion del boton salir (Cancelar) se liga a onActionSalir de la ventana Inicio
    @FXML
    private Button botonFinalizarC;
    @FXML
    void showFastFood(ActionEvent event) {
        categoriaPane.setVisible(false);
        categoriaPane.setDisable(true);
        fastFoodPane.setDisable(false);
        fastFoodPane.setVisible(true);
    } //Terminado

    @FXML
    void showPharmacy(ActionEvent event) {
        categoriaPane.setVisible(false);
        categoriaPane.setDisable(true);
        pharmacyPane.setDisable(false);
        pharmacyPane.setVisible(true);
    } //Terminado

    //FastFood
    @FXML
    void onActionPizza(ActionEvent event) {
        adapter.actualizarProductos("FF02");
        System.out.println(adapter.toString());
    }
    @FXML
    void onActionCombo(ActionEvent event) {
        adapter.actualizarProductos("FF03");
        System.out.println(adapter.toString());
    }

    @FXML
    void onActionCrepes(ActionEvent event) {
        adapter.actualizarProductos("FF04");
        System.out.println(adapter.toString());
    }
    @FXML
    void onActionTacos(ActionEvent event) {
        adapter.actualizarProductos("FF01");
        System.out.println(adapter.toString());
    }

    //Pharmacy
    @FXML
    private Button botonFinalizarPh;
    @FXML
    void onActionEnsure(ActionEvent event) {
        adapter.actualizarProductos("PH03");
        System.out.println(adapter.toString());
        ;
    }
    @FXML
    void onActionAspirina(ActionEvent event) {
        adapter.actualizarProductos("PH04");
        System.out.println(adapter.toString());
    }

    @FXML
    void onActionTermometro(ActionEvent event) {
        adapter.actualizarProductos("PH02");
        System.out.println(adapter.toString());
    }
    @FXML
    void onActionPedialyte(ActionEvent event) {
        adapter.actualizarProductos("PH01");
        System.out.println(adapter.toString());
    }

    @FXML
    void onActionBotonAtras(ActionEvent event) {
        if(fastFoodPane.isVisible()){
            fastFoodPane.setVisible(false);
            fastFoodPane.setDisable(true);
        } else if (pharmacyPane.isVisible()) {
            pharmacyPane.setVisible(false);
            pharmacyPane.setDisable(true);
        }
        categoriaPane.setDisable(false);
        categoriaPane.setVisible(true);
    } //Terminado
    @FXML
    void onActionFinalizar(ActionEvent event) {
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
    } //No terminado

    //pantalla Final
    @FXML
    private Text txtEnvio;
    @FXML
    private Text txtFactura;
}




