package cl.duoc.llanquihuetour.utils;

public class Validador {
    private Validador() {};

    public static String validarTexto(String texto, String tipo) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException("El campo " + tipo + " no puede estar vacío.");
        }
        return texto;
    }
}
