package org.iesalandalus.programacion.damas;

import java.util.Objects;

public class Posicion {
    private int fila;
    private char columna;


    // Métodos getter y setter con validación y excepciones.
    public int getFila() { //Getter
        return fila;
    }

    public void setFila(int fila) { //Setter
        if (fila < 1 || fila > 8) {
            throw new IllegalArgumentException("La fila debe estar entre 1 y 8.");
        }
        this.fila = fila;
    }

    public char getColumna() { //Getter
        return columna;
    }

    public void setColumna(char columna) { //Setter
        if (columna < 'a' || columna > 'h') {
            throw new IllegalArgumentException("La columna debe estar entre 'a' y 'h'.");
        }
        this.columna = columna;
    }


    // Constructor
    public Posicion(int fila, char columna) throws IllegalArgumentException{
        if (fila < 1 || fila > 8) {
            throw new IllegalArgumentException("La fila debe estar entre 1 y 8.");
        }
        if(columna < 'a' || columna > 'h') {
            throw new IllegalArgumentException("La columna debe estar entre 'a' y 'h'.");
        }
        setFila(fila);
        setColumna(columna);
    }

    // Constructor copia
    public Posicion(Posicion coordenadas) {
        if (coordenadas == null) {
            throw new IllegalArgumentException("La posición no puede ser nula.");
        }
        this.fila=coordenadas.fila;
        this.columna=coordenadas.columna;
    }

    // Método equals
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Posicion coordenadas = (Posicion) o;
        return fila == coordenadas.fila && columna == coordenadas.columna;
    }

    // Método hashCode
    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }

    @Override
    public String toString() {
        return "fila=" + fila + ", columna=" + columna;
    }
}
