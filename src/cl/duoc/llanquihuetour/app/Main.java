package cl.duoc.llanquihuetour.app;

import cl.duoc.llanquihuetour.data.LectorEmpleados;
import cl.duoc.llanquihuetour.model.Empleado;
import cl.duoc.llanquihuetour.service.ServicioEmpleados;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Punto de entrada de Llanquihue Tour. Carga empleados desde un CSV
 * y demuestra siete casos de uso de consulta y listado.
 *
 * @author Luis Antonio Julio Saurith
 */
public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    /**
     * Muestra la bienvenida y los resultados de las consultas sobre empleados.
     * El lector omite registros inválidos y este método registra los errores de lectura.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        System.out.println("¡Bienvenido a Llanquihue Tour!");

        try {
            LectorEmpleados lector = new LectorEmpleados();
            ServicioEmpleados servicio = new ServicioEmpleados();
            List<Empleado> empleados = lector.leerEmpleados("resources/empleados.csv");

            // CASO 1: Resumen general
            System.out.println("\n=== RESUMEN GENERAL ===");
            System.out.println("Total registrados: " + empleados.size());
            System.out.println("Total activos: " + servicio.contarEmpleadosActivos(empleados));
            System.out.println("Total inactivos: " + servicio.filtrarPorEstado(empleados, false).size());

            // CASO 2: Listado completo
            System.out.println("\n=== LISTADO DE EMPLEADOS ===");
            empleados.forEach(System.out::println);

            // CASO 3: Búsqueda por nombre
            System.out.println("\n=== BÚSQUEDA POR NOMBRE ===");
            List<Empleado> encontrados = servicio.buscarPorNombre(empleados, "Usagi");
            System.out.println("Coincidencias: " + encontrados.size());
            encontrados.forEach(System.out::println);

            // CASO 4: Empleados activos
            System.out.println("\n=== EMPLEADOS ACTIVOS ===");
            List<Empleado> activos = servicio.filtrarPorEstado(empleados, true);
            System.out.println("Total activos: " + activos.size());
            activos.forEach(System.out::println);

            // CASO 5: Empleados inactivos
            System.out.println("\n=== EMPLEADOS INACTIVOS ===");
            List<Empleado> inactivos = servicio.filtrarPorEstado(empleados, false);
            System.out.println("Total inactivos: " + inactivos.size());
            inactivos.forEach(System.out::println);

            // CASO 6: Búsqueda por ciudad
            System.out.println("\n=== BÚSQUEDA POR CIUDAD ===");
            List<Empleado> porCiudad = servicio.buscarPorCiudad(empleados, "Puerto Montt");
            System.out.println("Coincidencias: " + porCiudad.size());
            porCiudad.forEach(System.out::println);

            // CASO 7: Búsqueda sin coincidencias
            System.out.println("\n=== BÚSQUEDA SIN RESULTADOS ===");
            List<Empleado> sinResultados = servicio.buscarPorNombre(empleados, "NombreInexistente");
            System.out.println("Coincidencias: " + sinResultados.size());
            sinResultados.forEach(System.out::println);

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "No se pudo leer resources/empleados.csv; no se ejecutarán los casos de uso.", e);
        }
    }
}
