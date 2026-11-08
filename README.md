# Actividad 1 - Tema 4: Spring Boot y Despliegue en AWS (EC2)

*   **Ruíz Jiménez Erandi Camila**

## Objetivo de la Práctica
Configurar el entorno de desarrollo para Java y Spring Boot, crear un proyecto base desde Spring Initializr, desarrollar los primeros controladores (REST y MVC) para atender peticiones web, y desplegar el proyecto en VPS.

## Tecnologías Utilizadas
*   **Lenguaje:** Java (JDK 21)
*   **Framework:** Spring Boot (v4.1.2)
*   **IDE:** Visual Studio Code (con Extension Pack for Java)
*   **Servidor en la nube:** AWS EC2 (Amazon Linux 2023)
*   **Herramientas:** Maven (mvnw), Thymeleaf (para vistas HTML), Git/GitHub.

---

## Desarrollo Local (Fase 1)

### 1. Creación del Proyecto
El proyecto se generó usando [Spring Initializr](https://start.spring.io/) con las dependencias de **Spring Web** y **Thymeleaf**. Se importó a Visual Studio Code donde se configuró el entorno con las extensiones de Java.

### 2. Creación de los Controladores
Se crearon dos controladores principales dentro del paquete `controllers`:

*   **`EjemploRestController.java`**: Un `@RestController` que devuelve datos en formato JSON y texto plano. Contiene 3 endpoints:
    *   `/detalle_info2`: Devuelve un `Map` con información simulada (Título, Servidor, IP) en formato JSON.
    *   `/mis_materias`: Devuelve un arreglo de `String` con una lista de materias.
    *   `/proyecto`: Devuelve un texto con el nombre del proyecto y mis iniciales.
*   **`EjemploController.java`**: Un `@Controller` que devuelve una vista HTML usando **Thymeleaf**.
    *   `/detalle_info`: Renderiza el archivo `detalle_info.html` pasándole variables desde el modelo.

### 3. Pruebas Locales
Se ejecutó la aplicación en el puerto `9525` (configurado en el `application.properties`) y se comprobó que los 3 endpoints y la vista HTML respondieran correctamente usando el navegador en `localhost`.

---

## Despliegue en el VPS (Fase 2)

Para cumplir con el despliegue en un VPS, se utilizó una instancia de **AWS EC2 (Amazon Linux 2023)**. 

### Subida del archivo al servidor

Se utilizó el comando scp con la llave privada .pem de AWS para transferir el archivo .jar generado en la carpeta target/ hacia el servidor:

### Ejecución en el VPS
Al compartir el servidor con una compañera de equipo, se asignó el puerto 8081 para este proyecto (dejando el 8082 para ella). Se abrió el puerto en el Security Group de AWS y se ejecutó la aplicación en segundo plano con nohup:

---

## Enlaces

**Proyecto en el VPS:** 
    *   [JSON (REST):http://18.218.44.223:8081/detalle_info2](http://18.218.44.223:8081/detalle_info2)
    *   [Lista (REST):http://18.218.44.223:8081/mis_materias](http://18.218.44.223:8081/mis_materias)
    *   [Texto (REST): http://18.218.44.223:8081/proyecto](http://18.218.44.223:8081/proyecto)
    *   [Vista HTML (MVC): http://18.218.44.223:8081/detalle_info](http://18.218.44.223:8081/detalle_info)