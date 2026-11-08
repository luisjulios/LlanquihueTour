package cl.duoc.llanquihuetour.model;

import java.time.LocalDate;

public class Empleado extends Persona {
    private LocalDate fechaIngreso;
    private boolean activo;

    public Empleado (String nombreCompleto, String email, String telefono, Direccion direccion, LocalDate fechaIngreso, boolean activo) {
        super(nombreCompleto, email, telefono, direccion);
        setFechaIngreso(fechaIngreso);
        this.activo = activo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        if (fechaIngreso == null || fechaIngreso.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de ingreso debe ser válida y no puede ser futura");
        }
        this.fechaIngreso = fechaIngreso;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return """
                %s
                Empleado:
                    Fecha de ingreso: %s
                    Activo: %s
                """.formatted(
                        super.toString().stripTrailing(),
                        fechaIngreso,
                        activo
        );
    }
}
