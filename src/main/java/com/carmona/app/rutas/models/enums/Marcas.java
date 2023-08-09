package com.carmona.app.rutas.models.enums;

public enum Marcas {
    VOLVO("Volvo"),
    ALLIANCE("Alliance"),
    FORD("Ford"),
    DINA("Dina"),
    MERCEDES_BENZ("Mercedes_Benz");

    //atributos


    private String Descripcion;

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    Marcas(String descripcion) {
        Descripcion = descripcion;
    }
    public static Marcas getFromString(String estatus){
        switch (estatus){
            case "Volvo":
                return VOLVO;
            case "Allince":
                return ALLIANCE;
            case "Ford":
                return FORD;
            case "Dina":
                return DINA;
            case "Mercedes_Benz":
                return MERCEDES_BENZ;


            default:
                return null;

        }


    }
}
