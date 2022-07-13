# REST API fibonacci

Esta es una aplicación de back-end desarrollado en Java 8, con Spring Framework.

La misma consiste principalmente en una API que dado un número natural n, nos retornará el valor
para el n-esimo término de la sucesión de fibonacci.

## Base de datos

Se utiliza una base de datos relacional para almacenar los valores intermedios calculados, con
el fin de mejorar los tiempos de respuesta en futuras llamadas al endpoint.

Para que se logre apreciar el efecto de mejora del tiempo de respuesta durante sucesivas invocaciones, el algoritmo de cálculo se desarrolló con funciones recursivas, lo cual requiere un tiempo que crece de manera exponencial con relación a n cuando necesita calcular el término, es decir, si aún no existe en la base de datos.

## Estadísticas

Adicional a lo anterior, con cada solicitud al endpoint de la sucesión de fibonacci, se almacena en una tabla de Métricas
el término n solicitado, así como el Timestamp. Eso posibilita obtener datos estadísticos sobre los términos más solicitados, así como realizar gráficas con su distribución temporal.

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


## Métricas: Obtener los tres n términos de la sucesión más consultados

### Request

`GET "/metrics"`

    Ejemplo:
        https://fibonacci-lb.azurewebsites.net/metrics

### Response

    [
        {
            "frequency": 5,
            "nTerm": 8
        },
        {
            "frequency": 3,
            "nTerm": 15
        },
        {
            "frequency": 2,
            "nTerm": 9
        }
    ]
    
## Métricas: Obtener la cantidad de solicitudes del término n

### Request

`GET "/metrics/term/{n}"`

    Ejemplo:
        https://fibonacci-lb.azurewebsites.net/metrics/term/8

### Response

    {
        "Consultas al término n=8": 5,
        "metrics": [
            {
                "id": 32,
                "nTerm": 8,
                "timestamp": "2022-07-13T01:08:17.573"
            },
            {
                "id": 34,
                "nTerm": 8,
                "timestamp": "2022-07-13T01:08:29.332"
            },
            {
                "id": 35,
                "nTerm": 8,
                "timestamp": "2022-07-13T01:08:33.348"
            },
            {
                "id": 36,
                "nTerm": 8,
                "timestamp": "2022-07-13T01:09:27.542"
            },
            {
                "id": 37,
                "nTerm": 8,
                "timestamp": "2022-07-13T01:09:33.438"
            }
        ]
    }

    
## Métricas: Obtener la cantidad de solicitudes en la ÚLTIMA HORA del término n

### Request

`GET "/metrics/term/{n}/lasthour"`

    Ejemplo:
        https://fibonacci-lb.azurewebsites.net/metrics/term/8/lasthour

### Response

    {
        "Consultas al término n=8": 5,
        "metrics": [
            {
                "id": 32,
                "nTerm": 8,
                "timestamp": "2022-07-13T01:08:17.573"
            },
            {
                "id": 34,
                "nTerm": 8,
                "timestamp": "2022-07-13T01:08:29.332"
            },
            {
                "id": 35,
                "nTerm": 8,
                "timestamp": "2022-07-13T01:08:33.348"
            },
            {
                "id": 36,
                "nTerm": 8,
                "timestamp": "2022-07-13T01:09:27.542"
            },
            {
                "id": 37,
                "nTerm": 8,
                "timestamp": "2022-07-13T01:09:33.438"
            }
        ]
    }

