# 📘 Sistema de Matrícula de Alumnos

Este es un sistema web simple para registrar alumnos, cursos y matrículas, desarrollado con **Spring Boot**, **MySQL** y **JdbcTemplate** (sin JPA).

---

## 🚀 Tecnologías usadas

- Java 17+
- Spring Boot (Web, JDBC)
- MySQL
- Maven
- Postman (para pruebas)

---

## 🏗️ Estructura del proyecto

```
com.ejemplo.matricula
├── controller     # Controladores REST
├── service        # Lógica de negocio
├── repository     # Acceso a base de datos con JdbcTemplate
├── model          # Entidades (POJOs)
├── response       # Clase de respuesta común (CommonsResponse)
└── MatriculaApplication.java
```

---

## ⚙️ Configuración

1. Crear la base de datos:

```sql
CREATE DATABASE matricula_db;
```

2. Ejecutar el script de tablas:

```sql
USE matricula_db;

CREATE TABLE alumno (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100),
  email VARCHAR(100)
);

CREATE TABLE curso (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100),
  descripcion TEXT
);

CREATE TABLE matricula (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  alumno_id BIGINT,
  curso_id BIGINT,
  FOREIGN KEY (alumno_id) REFERENCES alumno(id),
  FOREIGN KEY (curso_id) REFERENCES curso(id)
);
```

3. Configurar el archivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/matricula_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
server.port=8080
```

---

## 📫 Endpoints principales

### 👤 Alumnos

- `POST /api/alumnos` – Registrar alumno
- `GET /api/alumnos` – Listar alumnos
- `GET /api/alumnos/{id}` – Obtener alumno por ID

### 📚 Cursos

- `POST /api/cursos` – Registrar curso
- `GET /api/cursos` – Listar cursos
- `GET /api/cursos/{id}` – Obtener curso por ID

### 📝 Matrículas

- `POST /api/matriculas` – Matricular alumno en curso
- `GET /api/matriculas` – Listar todas las matrículas

---

## 🧪 Pruebas con Postman

Importa la colección Postman disponible en `/postman/MatriculaAPI.postman_collection.json` para probar todos los endpoints fácilmente.

## 📌 Notas

- No se utiliza JPA ni Hibernate: solo `JdbcTemplate` para acceso directo a SQL.

---

## 💡 Autor

Ronald Alejo Tuanama – https://www.linkedin.com/in/ronald-alejo-tuanama/
