# Foro.hub API

Este proyecto es una API REST creada como parte del Challenge "Foro Hub", que gestiona un foro de discusión. Utilizando **Spring Boot 3**, la API permite realizar operaciones CRUD sobre tópicos, usuarios, respuestas y otros recursos relacionados. También implementa autenticación y autorización mediante **JWT**.

## Funcionalidades

### 1. **Gestión de Tópicos**
   - **Crear, actualizar y eliminar tópicos.**
   - **Obtener lista de tópicos con soporte para paginación.**
   - **Consultar los 10 tópicos más recientes.**
   - **Buscar tópicos por curso**

### 2. **Gestión de Usuarios**
   - **Registro de usuarios.**
   - **Autenticación con JWT.**

### 3. **Gestión de Respuestas**
   - **Crear, actualizar y eliminar respuestas a los tópicos.**
   - **Marcar una respuesta como solución a un tópico.**

### 4. **Seguridad**
   - **Protección de endpoints con autenticación JWT.**
   - 
### 5. **Documentación de la API**
   - La API está documentada con **Swagger**.
   - Puedes acceder a la documentación interactiva en `http://localhost:8080/swagger-ui.html` después de iniciar la aplicación.

## Tecnologías

- **Java 22**
- **Spring Boot 3**
- **Spring Security**
- **JWT (JSON Web Tokens)**
- **JPA (Java Persistence API) con Hibernate**
- **MySQL**
- **Swagger para documentación de la API**

## Requisitos previos

- Java 17 o superior.
- MySQL.
- Maven (o tu herramienta preferida para gestionar dependencias).


## Endpoints

### 1. **Autenticación y Registro**

| Método | Endpoint         | Descripción                                      |
|--------|------------------|--------------------------------------------------|
| `POST` | `/login`          | Autenticación de usuario (Login)                 |
| `POST` | `/user`           | Registro de nuevo usuario                        |

### 2. **Tópicos**

| Método | Endpoint               | Descripción                                      |
|--------|------------------------|--------------------------------------------------|
| `GET`  | `/topics`              | Obtener todos los tópicos                        |
| `POST` | `/topics`              | Crear un nuevo tópico                            |
| `GET`  | `/topics/{id}`         | Obtener un tópico por ID                         |
| `PUT`  | `/topics/{id}`         | Actualizar un tópico por ID                      |
| `DELETE` | `/topics/{id}`       | Eliminar un tópico por ID                        |

