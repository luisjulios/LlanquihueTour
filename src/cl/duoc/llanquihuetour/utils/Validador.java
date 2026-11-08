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
}