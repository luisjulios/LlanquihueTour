package cl.llanquihuetour.model;

import cl.llanquihuetour.utils.Validador;

public class Persona {
    private String nombreCompleto;
    private String email;
    private String telefono;
    private Direccion direccion;

    public Persona(String nombreCompleto, String email, String telefono, Direccion direccion) {
        setNombreCompleto(nombreCompleto);
        setEmail(email);
        setTelefono(telefono);
        setDireccion(direccion);
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = Validador.validarTexto(nombreCompleto, "nombreCompleto");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String emailValidado = Validador.validarTexto(email, "email");

        if(!emailValidado.contains("@")){
            throw new IllegalArgumentException("El email no tiene un formato válido");
        }
        this.email = emailValidado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = Validador.validarTexto(telefono, "teléfono");
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        if (direccion == null) {
            throw new IllegalArgumentException("La dirección es requerida");
        }
        this.direccion = direccion;
    }

    @Override
    public String  toString(){
        return """
                Persona:
                    Nombre: %s
                    Email: %s
                    Teléfono: %s
                %s
                """.formatted(nombreCompleto, email, telefono, direccion);
    }
}

