package org.iesalandalus.programacion.damas;

public class Dama {
    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

    // Métodos getter y setter con validación y excepciones.
    public Color getColor() { //Getter
        return color;
    }

    public void setColor(Color color) { //Setter
        if (color == null) {
            throw new NullPointerException("El color no puede ser nulo.");
        }
        this.color = color;
    }

    public Posicion getPosicion() { //Getter
        return posicion;
    }

    public void setPosicion(Posicion posicion) { //Setter
        if (posicion == null) {
            throw new NullPointerException("La posición no puede ser nula.");
        }
        this.posicion = posicion;
    }

    public boolean isEsDamaEspecial() { //Getter
        return esDamaEspecial;
    }

    public void setEsDamaEspecial(boolean esDamaEspecial) { //Setter
        if (esDamaEspecial!=true || esDamaEspecial!=false)
        {
            throw new IllegalArgumentException("El valor no es correcto. Debe ser Verdadero o Falso.");
        }
        this.esDamaEspecial = esDamaEspecial;
    }

    // Constructor por defecto
    public Dama() {
        this.color = Color.BLANCO;
        this.posicion = crearPosicionInicial(Color.BLANCO);
        this.esDamaEspecial = false;
    }

    // Constructor con parámetro de entrada COLOR
    public Dama(Color color) {
        if (color == null) {
            throw new NullPointerException("El color no puede ser nulo.");
        }
        this.color = color;
        this.posicion = crearPosicionInicial(color);
        this.esDamaEspecial = false;
    }

    // Método para crear la posición inicial aleatoria
    private Posicion crearPosicionInicial(Color color) {
        int fila;
        int columna;

        // Asigno un valor de fila dependiendo del color de la dama.
        if(color == Color.BLANCO) {
            fila = 1 + (int) (Math.random() * 3); // Con (int) quito decimales al resultado de Math.random (valor entre 0 y 1)
        }
        else {
            fila = 6 + (int) (Math.random() * 3);
        }


        do {
            columna = 1 + (int) (Math.random() * 8); // Obtengo el valor de la columna (1 a 8)
        } while ((fila + columna) % 2 == 0); // En el tablero, todas las posiciones (fila+columna) que el resto de la división sea 0, son casillas de color negro.

        return new Posicion(fila, columna);
    }
}


