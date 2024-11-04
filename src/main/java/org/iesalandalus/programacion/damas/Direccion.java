package org.iesalandalus.programacion.damas;

public enum Direccion {
    NORESTE("Noreste"),
    SURESTE("Sureste"),
    SUROESTE("Suroeste"),
    NOROESTE("Noroeste");

    private String mensajeAMostrar;

    private Direccion(String mensajeAMostrar)
    {
        this.mensajeAMostrar=mensajeAMostrar;
    }

    @Override
    public String toString() {
        return mensajeAMostrar;
    }
}
