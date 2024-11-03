package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    // Constructor
    private Consola() {

    }

    //
    public static void mostrarMenu() {
        System.out.println("1. Crear dama por defecto");
        System.out.println("1. Crear dama eligiendo su color");
        System.out.println("3. Mover");
        System.out.println("4. Salir");
    }

    public static int elegirOpcionMenu() {
        int opcionMenu;

        // Comprobamos que la opción elegida es válida
        do {
            System.out.println("Elige una opción del menú (1-4): ");
            opcionMenu= Entrada.entero();
        }while(opcionMenu < 1 || opcionMenu > 4);

        return opcionMenu;
    }
}
