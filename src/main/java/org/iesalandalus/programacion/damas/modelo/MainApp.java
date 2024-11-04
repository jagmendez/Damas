package org.iesalandalus.programacion.damas.modelo;

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
	
	
}
