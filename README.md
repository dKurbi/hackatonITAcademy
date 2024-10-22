# API de Distritos de Barcelona

### Descripción:
Esta API permite consultar información sobre los distritos de Barcelona, incluidos datos de renta y número de actividades educativas por distrito. Está construida usando Spring WebFlux y documentada con Swagger/OpenAPI.

### Endpoints:

1. **GET `/api/districts/`**
    - **Descripción**: Obtiene una lista de todos los distritos con sus datos de renta.
    - **Respuesta**:
        - **200**: Lista de distritos con sus datos de renta.
        - **404**: No se encontraron distritos.
        - **500**: Error interno del servidor.
```json
[
  {
    "id": 0,
    "name": "string",
    "valor": 0,
    "colorIndex": 0
  }
]
```

### Tecnologías:

- **Spring Boot**
- **Base de Datos**: H2 (en memoria) configurada usando `JdbcTemplate`.
- **Swagger**: Documentación automática con `springdoc-openapi`.
- **Spring WebFlux** (programación reactiva)
- **Java 21**

### Documentación de la API

Una vez que la aplicación se esté ejecutando, puede acceder a la documentación de Swagger en:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
