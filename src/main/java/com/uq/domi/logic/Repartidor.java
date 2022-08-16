package com.uq.domi.logic;

public class Repartidor extends Persona {
    private String domiId;
    private String matricula;

    public Repartidor(String nombre, String telefono) {
        super(nombre, telefono);
        setDomiId();
        setMatricula();
    }

    public Repartidor() {
        nombreAleatorio(); //Genera un nombre aleatorio cada vez que sea intanciada la clase
        this.setTelefono("31"+String.valueOf(Math.random()).substring(2,10)); //Genera un telefono aleatorio
        setDomiId(); //Genera un id aleatorio
        setMatricula(); //Genera una matricula aleatoria
    }


    private void nombreAleatorio(){ //Genera un nombre aleatorio escogiendo entre 5 opciones predefinidas
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
    private void setDomiId() { //Genera un id aleatorio con una longitud de 6-7 digitos
        int random = (int) (Math.random() * 1000000)+10000;
        this.domiId =random+"";
    }
    private void setMatricula() { //Genera una matricula aleatoria Iniciando siempre con Domi y con 3 digitos aleatorios
        int random = (int) (Math.random() * 899)+100;
        this.matricula ="DOMI"+random;
    }

    public String getDomiId() {
        return domiId;
    }

    public String getMatricula() {
        return matricula;
    }
}
