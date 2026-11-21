![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# 🧠 Semana 5: Organización modular y creación de una librería personalizada – Desarrollo Orientado a Objetos I

## 👤 Autor del proyecto
- **Nombre completo:** Luis Antonio Julio Saurith
- **Sección:** PRY2202-004A
- **Carrera:** Analista Programador Computacional
- **Sede:** Online

---

## 📘 Descripción y objetivo

LlanquihueTour es una aplicación de consola desarrollada para la actividad sumativa individual de la Semana 5 de Desarrollo Orientado a Objetos I, como continuación del proyecto de la Evaluación 1. Su objetivo es reforzar la organización en paquetes funcionales y la reutilización de código mediante la carga de archivos, el uso de colecciones dinámicas y las consultas por consola.

Representa personas, direcciones y empleados; carga empleados desde un CSV y demuestra consultas sobre colecciones en memoria. Aplica herencia, composición, encapsulamiento, validaciones y manejo de excepciones.

## ⚙️ Tecnologías utilizadas

- Java 21 y su biblioteca estándar: colecciones, `java.time`, `java.nio.file` y `java.util.logging` (JUL).
- IntelliJ IDEA para compilar y ejecutar.
- Git para el control de versiones.

No utiliza dependencias externas, frameworks, Maven ni Gradle. El repositorio no incluye pruebas automatizadas.

## 🧱 Estructura del proyecto

```plaintext
LlanquihueTour/
├── src/cl/duoc/llanquihuetour/
│   ├── app/Main.java
│   ├── data/LectorEmpleados.java
│   ├── exceptions/CampoVacioException.java
│   ├── model/
│   │   ├── Persona.java
│   │   ├── Empleado.java
│   │   └── Direccion.java
│   ├── service/ServicioEmpleados.java
│   └── utils/Validador.java
├── resources/empleados.csv
├── .gitignore
└── README.md
```

La configuración local de IntelliJ (`.idea/`, `*.iml`) y los archivos compilados están excluidos del control de versiones.

## Clases y responsabilidades

| Clase | Responsabilidad |
| --- | --- |
| `Main` | Cargar el archivo, ejecutar siete casos de uso y mostrar resultados; gestionar los errores de lectura. |
| `LectorEmpleados` | Leer líneas, separar las nueve columnas, construir empleados y omitir registros inválidos con una advertencia. |
| `Persona` | Encapsular nombre, email, teléfono y dirección; validar sus asignaciones. |
| `Empleado` | Extender `Persona` con fecha de ingreso y estado activo. |
| `Direccion` | Encapsular calle, número, ciudad y región. |
| `Validador` | Validar textos obligatorios y convertir el estado booleano de forma estricta. |
| `CampoVacioException` | Representar un texto obligatorio nulo, vacío o compuesto solo por espacios; hereda de `IllegalArgumentException`. |
| `ServicioEmpleados` | Contar empleados activos y consultar empleados por nombre, estado o ciudad. |

## Conceptos de POO y colecciones

- **Herencia:** `Empleado extends Persona` reutiliza los datos y validaciones de una persona y añade fecha de ingreso y estado. Su `toString()` incorpora la representación de la superclase.
- **Composición:** `Persona` contiene una referencia a `Direccion`, que agrupa los datos de ubicación.
- **Encapsulamiento:** los atributos del modelo son privados y se accede a ellos mediante getters y setters. Los constructores reutilizan setters para validar las asignaciones correspondientes.

Se utiliza la interfaz `List<Empleado>` en las variables y métodos, y `ArrayList<Empleado>` para almacenar empleados y resultados de consultas. `leerLineas()` devuelve `List<String>`. Las consultas crean listas de resultados sin modificar la lista recibida; los objetos contenidos son los mismos empleados, no copias.

## Lectura de empleados y estructura del CSV

`Main` carga `resources/empleados.csv`, con una ruta relativa al directorio de trabajo. `LectorEmpleados.leerLineas()` usa `Files.readAllLines()` con UTF-8. `leerEmpleados()` omite la primera línea, considerada encabezado, y procesa las siguientes en orden.

Cada registro se divide mediante `split(";", -1)`, que conserva las columnas vacías, y debe tener exactamente nueve campos:

| Posición | Columna | Contenido y validación |
| --- | --- | --- |
| 1 | `nombreCompleto` | Texto obligatorio. |
| 2 | `email` | Texto obligatorio que debe contener `@`. |
| 3 | `telefono` | Texto obligatorio; no se valida un formato telefónico. |
| 4 | `calle` | Texto obligatorio de la dirección. |
| 5 | `numero` | Texto obligatorio; se almacena como `String`. |
| 6 | `ciudad` | Texto obligatorio utilizado en la búsqueda por ciudad. |
| 7 | `region` | Texto obligatorio de la dirección. |
| 8 | `fechaIngreso` | Fecha ISO, por ejemplo `2020-04-01`, convertida con `LocalDate.parse()`; no puede ser futura. |
| 9 | `activo` | `true` o `false`; admite mayúsculas y espacios al principio o al final. |

El lector separa por punto y coma; no implementa escape de separadores ni campos entrecomillados. El archivo actual contiene 12 empleados válidos: 8 activos y 4 inactivos.

## Validaciones y manejo de excepciones

`Validador.validarTexto(texto, tipo)` rechaza `null`, cadenas vacías y textos compuestos solo por espacios con `CampoVacioException`. Devuelve el texto original cuando es válido.

`Persona` exige que el email contenga `@` y que la dirección no sea `null`. No realiza una validación completa del email. `Empleado` exige una fecha no nula y no posterior a `LocalDate.now()`. `Validador.validarBooleano()` rechaza valores distintos de `true` y `false`, en lugar de convertir silenciosamente cualquier texto a `false`.

Al leer el CSV, una cantidad incorrecta de columnas o una validación del modelo fallida produce `IllegalArgumentException` (incluida `CampoVacioException`). Un texto que no puede convertirse a fecha produce `DateTimeParseException` antes de construir el empleado. El lector captura ambos casos, registra una advertencia con el número de línea, omite ese registro y continúa con los siguientes.

Los errores de acceso al archivo se propagan como `IOException` hasta `Main`, que registra el fallo y termina sin ejecutar los casos de uso. Las búsquedas por nombre o ciudad rechazan criterios nulos o en blanco mediante `IllegalArgumentException`.

## Operaciones de ServicioEmpleados

| Método | Comportamiento |
| --- | --- |
| `contarEmpleadosActivos(empleados)` | Cuenta los elementos obtenidos al filtrar por estado activo. |
| `buscarPorNombre(empleados, nombre)` | Busca coincidencias parciales en el nombre. |
| `filtrarPorEstado(empleados, activo)` | Devuelve los empleados cuyo estado coincide con el solicitado. |
| `buscarPorCiudad(empleados, ciudad)` | Busca coincidencias parciales en la ciudad de la dirección. |

Las búsquedas por nombre y ciudad eliminan espacios de los extremos del criterio e ignoran mayúsculas mediante `Locale.ROOT`. Conservan el orden original y devuelven una lista vacía si no encuentran coincidencias.

## Casos de uso demostrados desde Main

1. **Resumen general:** total de empleados, activos e inactivos (12, 8 y 4 con el CSV actual).
2. **Listado completo:** muestra los 12 empleados mediante `toString()`.
3. **Búsqueda por nombre:** busca `Usagi` y encuentra un empleado.
4. **Empleados activos:** muestra los 8 empleados activos.
5. **Empleados inactivos:** muestra los 4 empleados inactivos.
6. **Búsqueda por ciudad:** busca `Puerto Montt`; el CSV actual no contiene coincidencias.
7. **Búsqueda sin resultados:** busca `NombreInexistente` y obtiene una lista vacía.

No se solicita ingreso de datos por teclado. Los criterios de demostración están definidos en `Main`.

## Compilar y ejecutar en IntelliJ IDEA

1. Instala un JDK 21 y abre la carpeta `LlanquihueTour` en IntelliJ IDEA. Para obtener el repositorio, puedes utilizar `git clone https://github.com/luisjulios/LlanquihueTour.git`.
2. En **File → Project Structure → Project**, selecciona JDK 21 como SDK y nivel de lenguaje 21. En **Modules**, utiliza el SDK del proyecto.
3. Marca `src` como **Sources Root** si IntelliJ no reconoce las clases. Si no existe un módulo Java, créalo a partir de las fuentes existentes y selecciona `src` como carpeta de fuentes.
4. En **Settings → Build, Execution, Deployment → Compiler → Java Compiler**, verifica que el bytecode objetivo sea 21.
5. Ejecuta **Build → Build Project** y comprueba que finalice sin errores.
6. Abre `src/cl/duoc/llanquihuetour/app/Main.java` y ejecuta `main` desde el icono de ejecución junto al método. La clase principal es `cl.duoc.llanquihuetour.app.Main`.
7. En **Run → Edit Configurations**, verifica que el directorio de trabajo sea la raíz `LlanquihueTour` y que se utilice JDK 21. El archivo `resources/empleados.csv` debe existir en esa raíz: se lee desde el sistema de archivos, no desde el classpath.
8. Revisa la consola: aparecerán la bienvenida, el resumen de carga y los siete casos de uso.

## Logging

Se utiliza JUL con un logger por clase en `Main` y `LectorEmpleados`, sin dependencias ni configuración adicional. El formato estándar de JUL incluye fecha, origen, nivel y mensaje; cuando se adjunta una excepción también muestra su traza. Los mensajes no repiten prefijos como `[WARN]`.

- **INFO:** informa cuántos empleados fueron aceptados al completar la carga.
- **WARNING:** informa que se omitió una línea inválida. Para validaciones se adjunta la excepción, cuyos mensajes actuales describen reglas o campos sin incluir valores personales. Para fechas se indica `DateTimeParseException` y el formato esperado, sin adjuntar el texto recibido que esa excepción contiene.
- **SEVERE:** informa un fallo de lectura del archivo, con la excepción y el contexto de la operación.

Los logs no incluyen nombres, correos, teléfonos, direcciones ni registros CSV completos. Los encabezados, listados, búsquedas y resultados de `Main` se conservan como salida funcional con `System.out`; estos listados sí muestran los datos del modelo como parte de la demostración académica.

---

**Repositorio GitHub:** https://github.com/luisjulios/LlanquihueTour.git

**Evaluación:** Actividad sumativa individual — Semana 5

© Duoc UC | Escuela de Informática y Telecomunicaciones | Sumativa Semana 5
