## Franquicias

Este proyecto es una API desarrollada en **Spring Boot** para manejar una lista de franquicias, sus sucursales y los productos ofrecidos en cada sucursal. La aplicación ha sido empaquetada utilizando **Docker** para facilitar su despliegue.

## Descripción General

* **Franquicia**: Compuesta por un nombre y un listado de sucursales.
* **Sucursal**: Compuesta por un nombre y un listado de productos.
* **Producto**: Compuesto por un nombre y una cantidad de stock.

## Características Principales

* **Agregar nueva franquicia**: Endpoint para crear una nueva franquicia en el sistema.
* **Agregar nueva sucursal**: Endpoint para añadir una sucursal a una franquicia existente.
* **Agregar nuevo producto**: Endpoint para incorporar un producto a una sucursal.
* **Eliminar producto**: Endpoint para eliminar un producto de una sucursal.
* **Modificar stock de producto**: Endpoint para actualizar la cantidad de stock de un producto.
* **Obtener producto con mayor stock por sucursal**: Endpoint que muestra el producto con mayor stock por cada sucursal de una franquicia específica.

## Bonus Implementados

* **Aplicación empaquetada con Docker**: La aplicación se puede construir y ejecutar en contenedores Docker para un despliegue más sencillo y escalable.
* **Actualización de nombres**:
  + **Actualizar nombre de franquicia**: Endpoint para modificar el nombre de una franquicia.
  + **Actualizar nombre de sucursal**: Endpoint para cambiar el nombre de una sucursal.
  + **Actualizar nombre de producto**: Endpoint para actualizar el nombre de un producto.
* **Persistencia en la nube**: Se ha utilizado una base de datos MySQL alojada en un proveedor de nube para la persistencia de datos.
* **Despliegue en la nube**: Toda la solución está preparada para ser desplegada en un entorno cloud.

## Instrucciones para Ejecutar la Aplicación

1. **Clonar el repositorio**:

```
git clone git@github.com:jdanielkc/franquicias.git
```

2. **Construir y ejecutar con Docker Compose:** 

Para ello navega al directorio del proyecto y ejecuta en linea de comandos:

```
docker-compose up -d
```

Esto construirá la imagen y levantará el proyecto.

3. **Acceder a la API:** 

La Api estará disponible en `

```
http://localhost:8080/api/...
```

## Endpoints Disponibles

* Agregar nueva franquicia:
    - **Método**: POST
    - **URL**: /api/nueva-franquicia
* Agregar nueva sucursal:
    - **Método**: POST
    - **URL**: /api/nueva-sucursal
* Agregar nuevo producto:
    - **Método**: POST
    - **URL**: /api/nuevo-producto
* Eliminar producto:
    - **Método**: DELETE
    - **URL**: /api/eliminar-producto/{idProducto}
* Modificar stock de producto:
    - **Método**: PUT
    - **URL**: /api/modificar-stock/{idProducto}
* Obtener producto con mayor stock por sucursal:
    - **Método**: GET
    - **URL**: /api/franquicia/{idFranquicia}/producto-mayor-stock
* Actualizar nombre de franquicia:
    - **Método**: PUT
    - **URL**: /api/modificar-nombre-franquicia/{idFranquicia}
* Actualizar nombre de sucursal:
    - **Método**: PUT
    - **URL**: /api/modificar-nombre-sucursal/{idSucursal}
* Actualizar nombre de producto:
    - **Método**: PUT
    - **URL**: /api/modificar-nombre-producto/{idProducto}*

## Consumo endpoints mediante Postman

Para el consumo de los endpoints se facilita en la raíz del proyecto el archivo ***  

## Tecnologías Utilizadas

* Spring Boot
* Spring Data JPA
* MySQL (base de datos en la nube, alojada en AWS RDS)
* Docker y Docker Compose
* AWS (para el despliegue en la nube)
* Maven (para la gestión de dependencias y construcción del proyecto)
* Java Doc
* Hibernate
* Entre otras

## Consideraciones

* **Configuración de la base de datos**: La aplicación está configurada para conectarse a una base de datos MySQL en la nube. Es necesario asegurarse de que las credenciales y la URL de la base de datos estén correctamente configuradas en las variables de entorno o en el archivo application.properties.

* **Despliegue en la nube**: Aunque la aplicación está lista para ser desplegada en la nube, se recomienda revisar la configuración específica del proveedor de servicios cloud que se utilice.
