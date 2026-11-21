package cl.duoc.llanquihuetour.data;

import cl.duoc.llanquihuetour.model.Direccion;
import cl.duoc.llanquihuetour.model.Empleado;
import cl.duoc.llanquihuetour.utils.Validador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LectorEmpleados {
    private static final Logger LOGGER = Logger.getLogger(LectorEmpleados.class.getName());

    public List<String> leerLineas(String ruta) throws IOException {
        return Files.readAllLines(Paths.get(ruta));
    }

    public List<Empleado> leerEmpleados(String ruta) throws IOException {
        List<Empleado> empleados = new ArrayList<>();
        List<String> lineas = leerLineas(ruta);

        for (int i = 1; i < lineas.size(); i++) {
            try {
                String linea = lineas.get(i);
                Empleado empleadoLinea = convertirEmpleado(linea);
                empleados.add(empleadoLinea);
            } catch (DateTimeParseException e) {
                // No registrar la excepción completa: su mensaje incluye el texto recibido del CSV.
                LOGGER.log(Level.WARNING, "Línea {0} omitida: formato de fecha inválido (DateTimeParseException). Use AAAA-MM-DD.", i + 1);
            } catch (IllegalArgumentException e) {
                LOGGER.log(Level.WARNING, "Línea " + (i + 1) + " omitida por validación.", e);
            }
        }
        LOGGER.log(Level.INFO, "Carga finalizada: {0} empleados aceptados.", empleados.size());
        return empleados;
    }

    private Empleado convertirEmpleado(String linea) {
        String[] campos = linea.split(";" , -1);

        if (campos.length != 9) {
            throw new IllegalArgumentException("Se esperaban 9 campos, pero se encontraron " + campos.length);        }

        String estado = campos[8];

        Direccion direccion = new Direccion(
                campos[3],
                campos[4],
                campos[5],
                campos[6]
        );

        return new Empleado(
                campos[0],
                campos[1],
                campos[2],
                direccion,
                LocalDate.parse(campos[7]),
                Validador.validarBooleano(estado)
        );
    }
}
