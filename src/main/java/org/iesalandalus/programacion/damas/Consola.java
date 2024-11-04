package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    // Constructor
    private Consola() {

    }

    // Método para mostrar el Menú
    public static void mostrarMenu() {
        System.out.println("1. Crear dama por defecto");
        System.out.println("2. Crear dama eligiendo su color");
        System.out.println("3. Mover");
        System.out.println("4. Salir");
    }

    // Método para comprobar la opción elegida del menú
    public static int elegirOpcionMenu() {
        int opcionMenu;

        // Comprobamos que la opción elegida es válida
        do {
            System.out.println("Elige una opción del menú (1-4): ");
            opcionMenu= Entrada.entero();
        }while(opcionMenu < 1 || opcionMenu > 4);

        return opcionMenu;
    }

    // Método para elegir el color de la dama
    public static int elegirOpcion() {
       int color;

        // Comprobamos que la opción elegida es válida
        do {
            System.out.println("Elige un color (1.Blanco, 2.Negro): ");
            color = Entrada.entero();
        }while(color != 1 || color != 2);

        return color;
    }

    //Método para mostrar el Menú direcciones
    public static void mostrarMenuDirecciones() {
        System.out.println("Elige la dirección deseada en la que se moverá la dama: ");
        System.out.println("1. Noreste");
        System.out.println("2. Sureste");
        System.out.println("3. Suroeste");
        System.out.println("4. Noroeste");
    }

    //Método para eligir la dirección
    public static int elegirDireccion() {
        int direccion;

        // Comprobamos que la opción elegida es válida
        do {
            System.out.println("Elige una opción del menú (1-4): ");
            direccion = Entrada.entero();
        }while(direccion < 1 || direccion > 4);

        return direccion;
    }


}
