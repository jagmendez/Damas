package org.iesalandalus.programacion.damas;

public class Posicion {
    private int fila;
    private char columna;


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
            throw new IllegalArgumentException("La columna debe estar entre 'a' y 'h'.")
        }
        this.columna = columna;
    }
}
