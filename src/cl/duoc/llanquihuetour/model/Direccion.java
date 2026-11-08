package cl.duoc.llanquihuetour.model;

import cl.duoc.llanquihuetour.utils.Validador;

public class Direccion {
    private String calle;
    private String numero;
    private String ciudad;
    private String region;


    public Direccion (String calle, String numero, String ciudad, String region){
        setCalle(calle);
        setNumero(numero);
        setCiudad(ciudad);
        setRegion(region);
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = Validador.validarTexto(calle, "calle");
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = Validador.validarTexto(numero, "numero");
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = Validador.validarTexto(ciudad, "ciudad");
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = Validador.validarTexto(region, "region");
    }

    @Override
    public String toString() {
        return """
                Dirección:
                    Calle: %s
                    Número: %s
                    Ciudad: %s
                    Region: %s
                """.formatted(calle, numero, ciudad, region);
    }
}

