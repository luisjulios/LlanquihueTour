package cl.duoc.llanquihuetour.service;

import cl.duoc.llanquihuetour.model.Empleado;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ServicioEmpleados {
    public int contarEmpleadosActivos(List<Empleado> empleados) {
        return filtrarPorEstado(empleados, true).size();
    }
    public List<Empleado> buscarPorNombre(List<Empleado> empleados, String nombre) {
        List<Empleado> resultados = new ArrayList<>();

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de búsqueda no puede estar vacío.");
        }

        String criterio = nombre.trim().toLowerCase(Locale.ROOT);

        for (Empleado empleado : empleados) {
            if (empleado.getNombreCompleto().toLowerCase(Locale.ROOT).contains(criterio)) {
                resultados.add(empleado);
            }
        }

        return resultados;
    }
    public List<Empleado> filtrarPorEstado(List<Empleado> empleados, boolean activo) {
        List<Empleado> resultados = new ArrayList<>();

        for (Empleado empleado : empleados) {
            if (empleado.isActivo() == activo) {
                resultados.add(empleado);
            }
        }

        return resultados;
    }
    public List<Empleado> buscarPorCiudad(List<Empleado> empleados, String ciudad) {
        if (ciudad == null || ciudad.isBlank()) {
            throw new IllegalArgumentException("La ciudad de búsqueda no puede estar vacía.");
        }

        String criterio = ciudad.trim().toLowerCase(Locale.ROOT);
        List<Empleado> resultados = new ArrayList<>();

        for (Empleado empleado : empleados) {
            String ciudadEmpleado = empleado.getDireccion().getCiudad();

            if (ciudadEmpleado.toLowerCase(Locale.ROOT).contains(criterio)) {
                resultados.add(empleado);
            }
        }

        return resultados;
    }
}
