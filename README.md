![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# 🧠 Actividad Sumativa 1: Realizando validación, excepciones y relaciones entre clases – Desarrollo Orientado a Objetos I

## 👤 Autor del proyecto
- **Nombre completo:** Luis Antonio Julio Saurith
- **Sección:** PRY2202-004A
- **Carrera:** Analista Programador Computacional
- **Sede:** Online

---

## 📘 Descripción general del sistema
Este proyecto corresponde a la Actividad Sumativa 1 de la asignatura *Desarrollo Orientado a Objetos I*. LlanquihueTour es una aplicación desarrollada en Java para representar la información de personas y empleados de Llanquihue Tour. En su versión actual, permite almacenar sus datos de contacto y dirección, además de la fecha de ingreso y el estado activo de los empleados. Su diseño aplica encapsulamiento, composición y herencia mediante las clases `Persona`, `Direccion` y `Empleado`.

El proyecto fue desarrollado a partir de un caso contextualizado, abordando problemáticas reales y proponiendo una solución estructurada, modular y reutilizable.

---

## 🧱 Estructura general del proyecto

Las clases se organizan bajo el paquete base `cl.duoc.llanquihuetour`, con los subpaquetes `app`, `model` y `utils`.

```plaintext
LlanquihueTour/
├── src/cl/duoc/llanquihuetour/
│   ├── app/
│   │   └── Main.java       # Punto de entrada y ejemplo de uso del sistema
│   ├── model/
│   │   ├── Persona.java    # Datos personales, de contacto y dirección
│   │   ├── Empleado.java   # Extiende Persona con fecha de ingreso y estado activo
│   │   └── Direccion.java  # Dirección asociada a una persona
│   └── utils/
│       └── Validador.java  # Validación reutilizable de textos nulos o en blanco
├── .gitignore             # Archivos y carpetas excluidos del control de versiones
└── README.md              # Descripción e instrucciones del proyecto
```

---



## ⚙️ Instrucciones para clonar y ejecutar el proyecto

1. Instala Git, IntelliJ IDEA y un JDK 21, que es la versión configurada para el proyecto.

2. Clona el repositorio desde GitHub:

```bash
git clone https://github.com/luisjulios/LlanquihueTour.git
```

3. Abre la carpeta `LlanquihueTour` en IntelliJ IDEA.

4. En **File → Project Structure → Project**, selecciona el JDK 21 como SDK del proyecto. Si IntelliJ no reconoce las clases, haz clic derecho sobre `src` y selecciona **Mark Directory as → Sources Root**.

5. Abre `src/cl/duoc/llanquihuetour/app/Main.java`, correspondiente a la clase `cl.duoc.llanquihuetour.app.Main`, y ejecuta el método `main` mediante el botón de ejecución junto a su declaración.

6. Revisa la consola de IntelliJ: el programa muestra los datos de un empleado y una persona, y ejecuta ejemplos de validación y manejo de excepciones. Los datos de ejemplo están definidos en `Main.java`; la ejecución no requiere archivos externos ni ingreso de datos por teclado.


---

**Repositorio GitHub:** https://github.com/luisjulios/LlanquihueTour.git

**Fecha de entrega:** \[08/11/2026]

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Sumativa Semana 3



