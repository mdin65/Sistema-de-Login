package org.example;

import java.util.Scanner;

public class ConsolaLogin {
    Scanner scanner = new Scanner(System.in);
    DatosLogin datos = new DatosLogin();
    Login login = new Login();

    public void menu() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = obtenerOpcion();
            ejecutarOpcion(opcion);

        } while (opcion != 2);
    }

    /**
     * Muestra las opciones disponibles para el usuario.
     */
    private void mostrarOpciones() {
        System.out.println("\n============ Bienvenido ============");
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Salir");
        System.out.print("Seleccione una opción: ");
    }
    private int obtenerOpcion() {
        int opcion;
        String entrada;
        while (true) {
            entrada = scanner.nextLine();

            if (entrada.trim().isEmpty()) {
                System.out.println("Entrada vacía. Intente nuevamente.");
                continue;
            }

            try {
                opcion = Integer.parseInt(entrada);
                if (opcion < 1 || opcion > 4) {
                    System.out.println("Opción no válida. Debe ser 1 o 2.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }
        return opcion;
    }


    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                manejarLogin();
                break;
            case 2:
                System.out.println("Saliendo del sistema...");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }


    private void manejarLogin() {
        System.out.print("Ingrese el usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Ingrese la contraseña: ");
        String clave = scanner.nextLine();

        if (login.autenticar(usuario, clave, datos)) {
            System.out.println("¡Bienvenido " + usuario + "!");
            System.exit(0);
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }
}
