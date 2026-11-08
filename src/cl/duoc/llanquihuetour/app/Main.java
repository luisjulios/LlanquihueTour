package cl.duoc.llanquihuetour.app;

import cl.duoc.llanquihuetour.model.Direccion;
import cl.duoc.llanquihuetour.model.Empleado;
import cl.duoc.llanquihuetour.model.Persona;

import java.time.LocalDate;


/**
 * Punto de entrada de Llanquihue Tour. Demuestra la creación de un empleado
 * y un cliente, representado por {@link Persona}, con sus respectivas direcciones.
 *
 * @author Luis Antonio Julio Saurith
 */
public class Main {
    /**
     * Muestra la bienvenida y los datos de ejemplo mediante sus métodos toString().
     * Las validaciones se ejecutan al construir los objetos; las excepciones
     * se propagan sin capturarse en este ejemplo.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        System.out.println("¡Bienvenido a Llanquihue Tour!");

        Direccion empleadoDireccion = new Direccion(
                "Av. General Calderon",
                "345",
                "Santiago",
                "Region Metropolitana"
        );

        Empleado empleadoDatos = new Empleado(
                "Luis Armando Casas",
                "luis.casas@llanquihuetour.cl",
                "+56948627913",
                empleadoDireccion,
                LocalDate.of(2022,10,4),
                true
        );

        System.out.println("*******Datos de Empleado*******");
        System.out.println(empleadoDatos);


        Direccion clienteDireccion = new Direccion(
                "Avenida Sucre",
                "2885",
                "Concepcion",
                "Bio Bio"
        );

        Persona clienteDatos = new Persona(
                "Alan Brito Paredes",
                "alan.brito@transportesmiau.com",
                "2236845892",
                clienteDireccion
        );



        System.out.println("*******Datos de Cliente*******");
        System.out.println(clienteDatos);


    }
}
