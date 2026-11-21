package cl.duoc.llanquihuetour.utils;

import cl.duoc.llanquihuetour.exceptions.CampoVacioException;

public class Validador {
    private Validador() {}

    public static String validarTexto(String texto, String tipo) {
        if (texto == null || texto.isBlank()) {
            throw new CampoVacioException(tipo);
        }
        return texto;
    }

    public static boolean validarBooleano(String valor) {
        if (valor == null) {
            throw new IllegalArgumentException("El campo activo no puede ser nulo.");
        }

        String normalizado = valor.trim();

        if (!normalizado.equalsIgnoreCase("true") && !normalizado.equalsIgnoreCase("false")) {
            throw new IllegalArgumentException("El campo activo debe contener true o false.");
        }

        return Boolean.parseBoolean(normalizado);
    }
}