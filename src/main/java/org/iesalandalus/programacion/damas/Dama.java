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
        if (esDamaEspecial<>true || esDamaEspecial<>false)
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
        this.posicion = creaPosicionInicial(color);
        this.esDamaEspecial = false;
    }
}


