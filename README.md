# Prueba tecnica para el puesto de desarrollador fullstack

Este proyecto es una aplicación CRUD básica desarrollada con Spring Boot y MySQL para la gestión de datos de personas.

## Requisitos previos

Antes de comenzar, asegúrate de tener instalados los siguientes programas:

- Git

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

## Configuración de la base de datos

- Inicia sesión en MySQL desde la terminal o usa MySQL Workbench.

- Carga el script schema.sql proporcionado en el repositorio:

- Usa la base de datos creada:

```
USE bd_garrido;
```

- Crea un nuevo usuario en MySQL y otórgale permisos de administrador:

```
CREATE USER 'conexion'@'localhost' IDENTIFIED BY '2Y;9~HK=uyLH@r`6h7\BkRHu!+iRi/';

GRANT ALL PRIVILEGES ON bd_garrido.* TO 'conexion'@'localhost';

FLUSH PRIVILEGES;
```

- Una vez ejecutado el archivo, podemos salir.
```
exit;
```