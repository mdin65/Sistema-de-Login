package org.example;


public class Login {


    public boolean autenticar(String usuario, String clave, DatosLogin datos) {
        if (usuario == null || clave == null || datos == null || datos.credenciales == null) {
            return false;
        }

        String intento = usuario + ";" + clave;

        for (String credencial : datos.credenciales) {
            if (credencial.equals(intento)) {
                return true;
            }
        }

        return false;
    }
}
