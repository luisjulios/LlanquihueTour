package cl.duoc.llanquihuetour.app;

import cl.duoc.llanquihuetour.model.Direccion;
import cl.duoc.llanquihuetour.model.Empleado;
import cl.duoc.llanquihuetour.model.Persona;

import java.time.LocalDate;


//Autor: Luis Antonio Julio Saurith

public class Main {
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




        System.out.println(empleadoDatos);
        System.out.println(clienteDatos);

        try {
            empleadoDatos.setNombreCompleto("");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: "  + e.getMessage() + "\nLinea: " + e.getStackTrace()[e.getStackTrace().length - 1]);
        } finally {
            System.out.println(empleadoDatos);
        }

        try {
            empleadoDatos.setFechaIngreso(LocalDate.of(2020, 5, 10));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }  finally {
            System.out.println(empleadoDatos);
        }


    }
}
