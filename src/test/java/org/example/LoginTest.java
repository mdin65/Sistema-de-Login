package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

class LoginTest {
    private Login login;
    private DatosLogin datos;

    @BeforeEach
    public void autenticar() {
        login = new Login();
        datos = new DatosLogin();
        datos.credenciales = new ArrayList<>();
        datos.credenciales.add("usuario1;clave1");
        datos.credenciales.add("usuario2;clave2");
    }
        @Test
        public void testIngresoCorrecto () {
            assertTrue(login.autenticar("usuario1", "clave1", datos));
            assertTrue(login.autenticar("usuario2", "clave2", datos));

        }

        @Test
        void usuarioinexistente () {
            assertFalse(login.autenticar("usuarioNoExiste", "clave1", datos));
        }

        @Test
        void contraseñainvalida () {
            assertFalse(login.autenticar("usuario1", "claveErronea", datos));
        }
        }



