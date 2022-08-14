package com.uq.domi.logic;

import com.uq.domi.logic.Persona;
public class Repartidor extends Persona {
    private String domiId;
    private String matricula;

    public Repartidor(String nombre, String telefono) {
        super(nombre, telefono);
        setDomiId();
        setMatricula();
    }

    public Repartidor() {
        nombreAleatorio();
        this.setTelefono("31"+String.valueOf(Math.random()).substring(2,10));
        setDomiId();
        setMatricula();
    }


    private void nombreAleatorio(){
        int n = (int) (Math.random()*5)+1;

        switch (n) {
            case 1 -> this.setNombre("Juan Perez");
            case 2 -> this.setNombre("Pedro Lopez");
            case 3 -> this.setNombre("Luis Acero");
            case 4 -> this.setNombre("Ana Martinez");
            case 5 -> this.setNombre("Jose Smith");
            default -> this.setNombre("pedro");
        }
    }
    private void setDomiId() {
        int random = (int) (Math.random() * 1000000)+10000;
        this.domiId =random+"";
    }
    private void setMatricula() {
        int random = (int) (Math.random() * 899)+100;
        this.matricula ="DOMI"+random;
    }

    private String getDomiId() {
        return domiId;
    }

    private String getMatricula() {
        return matricula;
    }
}
