package org.iesalandalus.programacion.damas;

import javax.naming.OperationNotSupportedException;

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
        int posicionColumna;
        char columna;

        // Asigno un valor de fila dependiendo del color de la dama.
        if(color == Color.BLANCO) {
            fila = 1 + (int) (Math.random() * 3); // Con (int) quito decimales al resultado de Math.random (valor entre 0 y 1)
        }
        else {
            fila = 6 + (int) (Math.random() * 3);
        }


        do {
            posicionColumna = 1 + (int) (Math.random() * 8); // Obtengo el valor de la columna (1 a 8)
        } while ((fila + posicionColumna) % 2 == 0); // En el tablero, todas las posiciones (fila+columna) que el resto de la división sea 0, son casillas de color negro.

            columna = (char) ('a' + posicionColumna);

        return new Posicion(fila, columna);
    }


    // Método mover
    public void mover(Direccion direccion, int numPasos) throws OperationNotSupportedException {

        //La dirección no puede ser nula.
        if (direccion == null) {
            throw new NullPointerException("La dirección no puede ser nula.");
        }

        //Si la dama no es especial, limitamos movimientos y mostramos excepción.
        if (!esDamaEspecial) {
            if (
            (color == Color.BLANCO && (direccion != Direccion.NORESTE && direccion != Direccion.NOROESTE))
            ||
            (color == Color.NEGRO && (direccion != Direccion.SURESTE && direccion != Direccion.SUROESTE))
            ) {
                throw new OperationNotSupportedException("Movimiento no permitido: la dama no puede retroceder.");
            }
        }

        // Controlamos el número de casillas a mover (pasos)
        if (numPasos < 1) {
            throw new IllegalArgumentException("El número de pasos debe ser mayor o igual que 1.");
        }

        // Si aún no es dama especial, controlamos el número de pasos
        if (!esDamaEspecial && numPasos != 1) {
            throw new OperationNotSupportedException("La dama solo puede moverse 1 casilla si no es una dama especial.");
        }

        // Declaramos variables para la nueva posición de la dama.
        int nuevaFila = posicion.getFila();
        char nuevaColumna = posicion.getColumna();

        // Según la dirección elegida de movimiento, recalculamos la posición.
        switch (direccion) {
            case NORESTE:
                nuevaFila += numPasos;
                nuevaColumna += numPasos;
                break;
            case NOROESTE:
                nuevaFila += numPasos;
                nuevaColumna -= numPasos;
                break;
            case SURESTE:
                nuevaFila -= numPasos;
                nuevaColumna += numPasos;
                break;
            case SUROESTE:
                nuevaFila -= numPasos;
                nuevaColumna -= numPasos;
                break;
            default:
                throw new IllegalArgumentException("Dirección no válida.");
        }

        // Convertir en dama especial si llega al extremo del tablero
        if ((color == Color.BLANCO && nuevaFila == 8) || (color == Color.NEGRO && nuevaFila == 1)) {
            esDamaEspecial = true;
        }

        // Verificar si el movimiento es válido
        if (nuevaFila < 1 || nuevaFila > 8 || nuevaColumna < 'a' || nuevaColumna > 'h') {
            throw new OperationNotSupportedException("Movimiento no permitido: la dama se sale del tablero.");
        }

        // Actualizamos la posición
        posicion = new Posicion(nuevaFila, nuevaColumna);

    }

    @Override
    public String toString() {
        return "Dama{" +
                "color=" + color +
                ", posicion=" + posicion +
                '}';
    }
}


