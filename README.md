# Prueba tecnica para el puesto de desarrollador fullstack

Este proyecto es una aplicación CRUD básica desarrollada con Spring Boot y MySQL para la gestión de datos de personas.

## Requisitos previos

Antes de comenzar, asegúrate de tener instalados los siguientes programas:

- Git

- Java JDK 17+

- Maven

- Visual Studio Code (opcional)

- MySQL Server

- MySQL Workbench (opcional)


## Pasos para clonar el repositorio

- Abre una terminal o línea de comandos.

- Ejecuta el siguiente comando para clonar el repositorio:

```
git clone https://github.com/DraketRomero/tesffulstack.git
```

- Navega a la carpeta donde clonaste el proyecto:

```
cd tesffulstack
```

- Navega a la rama donde se encuentra la aplicacion spring boot

```
git checkout garrido_backend
```


## Configuración del proyecto

- Renombra el archivo application-example.properties a application.properties.

- Modifica el archivo application.properties con las credenciales de la base de datos, creada en el punto anterior:


spring.datasource.url=jdbc:mysql://localhost:3306/garrido_db
spring.datasource.username=root
spring.datasource.password=


- Ejecutar la aplicación

- Compila el proyecto con Maven:

```
mvn clean package
```

- Ejecuta la aplicación:

```
mvn spring-boot:run
```

Despues de esto, la aplicación se estará esjecutanoo en http://localhost:8080.