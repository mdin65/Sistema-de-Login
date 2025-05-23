package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class DatosLoginTest {

    @Test
    public void testMetodoPrivado() throws Exception {
        DatosLogin datos = new DatosLogin();
        Method metodo = DatosLogin.class.getDeclaredMethod("cargarUsuarios", String.class);
        metodo.setAccessible(true);
        metodo.invoke(datos, "ruta/inexistente.txt");
    }

    @Test
    public void testUsuariosRepetidosLanzanExcepcion() {
        DatosLogin datos = new DatosLogin();
        String rutaDuplicados = "C:/Users/yasmi/IdeaProjects/Sistema-de-Login/files/Login.txt";

        Exception exception = assertThrows(IOException.class, () -> {
            datos.cargarUsuarios(rutaDuplicados);
        });

        assertTrue(exception.getMessage().contains("usuarios repetidos"));
    }
}




