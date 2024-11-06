package org.iesalandalus.programacion.damas.modelo;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

    //Creado atributo de clase Dama
    private static Dama dama;

    //Creado método para ejecutar la opción pasada por parámetro según corresponda
    public static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                crearDamaDefecto();
                break;
            case 2:
                crearDamaColor();
                break;
            case 3:
                mover();
                break;
            case 4:
                mostrarDama();
                break;
            case 5:
                System.out.println("Saliendo del juego... ¡Adios, hasta pronto!");
            default:
                System.out.println("Opción no válida.");
        }
    }

    //Creado método crearDamaDefecto
    public static void crearDamaDefecto() {
        dama = new Dama();
        System.out.println("Creada Dama por defecto.");
    }

    //Creado método crearDamaColor
    public static void crearDamaColor() {
        System.out.println("Elige el color de la dama (1.Blanco, 2.Negro): ");
        int colorEntrada = Entrada.entero();

        try {
            switch (colorEntrada) {
                case 1:
                    dama = new Dama(Color.BLANCO);
                    break;
                case 2:
                    dama = new Dama(Color.NEGRO);
                    break;
            }

            System.out.println("Dama de color " + dama.getColor() + " creada.");
        } catch (IllegalArgumentException e) {
            System.out.println("Color no válido.");
        }


    }


	
	
}
