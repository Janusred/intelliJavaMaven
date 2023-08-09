package com.carmona.app.rutas.models.enums;

public enum Tipos {
    TRAILER("Trailer"),
    TORTON("Torton"),
    DOBLE_REMOLQUE("Doble_Remolque"),
    VOLTEO("Volteo"),
    SEMI_REMOLQUE("Semi_Remolque");

    //ATRIBUTOS
    private String descripcion;
    //get and set

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    Tipos(String descripcion) {
        this.descripcion = descripcion;
    }


    public static Tipos getFromString(String estatus){
        switch (estatus) {
            case "Trailer":
                return TRAILER;
            case "Torton":
                return TORTON;
            case "Doble_Remolque":
                return DOBLE_REMOLQUE;
            case "Volteo":
                return VOLTEO;
            case "Semi_Remolque":
                return SEMI_REMOLQUE;


            default:
                return null;
        }
    }

}
