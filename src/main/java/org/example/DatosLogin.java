package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class DatosLogin {

    public ArrayList<String> credenciales = new ArrayList<>();


    public DatosLogin() {
        try {
            cargarUsuarios("C:/Users/yasmi/IdeaProjects/Sistema-de-Login/files/Login.txt");
        } catch (IOException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
        }
    }

    private boolean tieneUsuariosRepetidos() {
        Set<String> set = new HashSet<>(credenciales);
        return set.size() < credenciales.size();
    }

    void cargarUsuarios(String rutaArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty() || !linea.contains(";")) {
                    continue;
                }
                credenciales.add(linea);
            }
        } catch (java.io.FileNotFoundException e) {
            throw new IOException("Archivo login.txt no existe o no accesible", e);
        }

        if (tieneUsuariosRepetidos()) {
            throw new IOException("Hay usuarios repetidos en el archivo.");
        }
    }
}