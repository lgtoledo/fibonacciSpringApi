# REST API fibonacci

Esta aplicación es un back-end desarrollado en Java 8, con Spring Framework.

El funcionamiento consiste en que dado un número natural n, nos retornará el valor
para el n-esimo término de la sucesión de fibonacci.

## Base de datos

Se utilizará una base de datos para almacenar los valores intermedios calculados, con
el fin de mejorar los tiempos de respuesta en futuras llamadas al endpoint.

Para que se logre apreciar mejor este efecto en la mejora del tiempo de respuesta durante sucesivas invocaciones, el algoritmo de cálculo se desarrolló con funciones recursivas, lo cual requiere un tiempo que crece de manera exponencial con relación a n.

## Estadísticas

Adicional a lo anterior, con cada solicitud al endpoint de la sucesión de fibonacci, se almacena en una tabla de Métricas
el término n solicitado, así como el Timestamp. Eso permitiría obtener datos estadísticos sobre los términos más solicitados, así como realizar gráficas con su distribución temporal.

## Despliegue

La aplicación se despliega en la nube de Azure, al igual que la base de datos MySQL v5.7

# REST API

A continuación se describe la REST API

## Obtener el n-esimo término de la sucesión de fibonacci

### Request

`GET "/fibonacci/{n}"`

Ejemplo:

    https://fibonacci-lb.azurewebsites.net/fibonacci/6

### Response

    {
      "n": 6,
      "value": 8
    }

## Elimina todos los datos de la base de datos

### Request

`GET "/fibonacci/reset"`

    Ejemplo:
        https://fibonacci-lb.azurewebsites.net/fibonacci/reset

### Response

    {
      "message": "Contenido de la Base de datos borrado correctamente"
    }
