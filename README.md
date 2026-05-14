<div style="text-align: center;">
  <h1>Registro Estudiantes API</h1>
  <p><em>API REST minimalista para gestionar estudiantes y sus proyectos.</em></p>
</div>

<p style="text-align: center;">
  <img src="https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Java 21" />
  <img src="https://img.shields.io/badge/Spring%20Boot-4.0.6-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring Boot" />
  <img src="https://img.shields.io/badge/PostgreSQL-15%2B-316192?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL" />
</p>

---

## Descripción

`registroEstudiantes_api` es una API REST construida con **Spring Boot** para administrar:

- Estudiantes
- Proyectos asociados a cada estudiante

El proyecto sigue una estructura simple de capas: **Controller → Service → Repository → Model**.

## Funcionalidades

- Listar estudiantes
- Obtener un estudiante por ID
- Crear estudiantes con proyectos asociados
- Actualizar estudiantes existentes
- Eliminar estudiantes

## Stack tecnológico

<table>
  <tr>
    <td><strong>Lenguaje</strong></td>
    <td>Java 21</td>
  </tr>
  <tr>
    <td><strong>Framework</strong></td>
    <td>Spring Boot 4.0.6</td>
  </tr>
  <tr>
    <td><strong>Persistencia</strong></td>
    <td>Spring Data JPA</td>
  </tr>
  <tr>
    <td><strong>Base de datos</strong></td>
    <td>PostgreSQL</td>
  </tr>
  <tr>
    <td><strong>Build tool</strong></td>
    <td>Maven</td>
  </tr>
  <tr>
    <td><strong>Servidor</strong></td>
    <td>Embedded Tomcat</td>
  </tr>
</table>

## Estructura principal

```text
src/main/java/ni/edu/uam/registroEstudiantes_api/
├── controllers/
│   └── StudentController.java
├── models/
│   ├── Student.java
│   └── Proyect.java
├── repository/
│   ├── StudentRepo.java
│   └── ProyectRepo.java
└── Services/
    └── StudentService.java
```

## Endpoints

Base URL:

```text
http://localhost:8080/api/students
```

<table>
  <thead>
    <tr>
      <th>Método</th>
      <th>Endpoint</th>
      <th>Descripción</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>GET</td>
      <td><code>/api/students</code></td>
      <td>Lista todos los estudiantes</td>
    </tr>
    <tr>
      <td>GET</td>
      <td><code>/api/students/{id}</code></td>
      <td>Obtiene un estudiante por su ID</td>
    </tr>
    <tr>
      <td>POST</td>
      <td><code>/api/students</code></td>
      <td>Crea un nuevo estudiante</td>
    </tr>
    <tr>
      <td>PUT</td>
      <td><code>/api/students/{id}</code></td>
      <td>Actualiza un estudiante existente</td>
    </tr>
    <tr>
      <td>DELETE</td>
      <td><code>/api/students/{id}</code></td>
      <td>Elimina un estudiante</td>
    </tr>
  </tbody>
</table>

## Modelo de datos

### Student

| Campo | Tipo | Descripción |
|---|---:|---|
| `id` | Long | Identificador autogenerado |
| `nombre` | String | Nombre del estudiante |
| `carrera` | String | Carrera del estudiante |
| `proyectos` | List&lt;Proyect&gt; | Proyectos relacionados |

### Proyect

| Campo | Tipo | Descripción |
|---|---:|---|
| `id` | Long | Identificador autogenerado |
| `nombre` | String | Nombre del proyecto |
| `descripcion` | String | Descripción del proyecto |
| `student` | Student | Estudiante asociado |

## Ejemplo de solicitud

### Crear estudiante

```json
{
  "nombre": "Ana López",
  "carrera": "Ingeniería en Sistemas",
  "proyectos": [
    {
      "nombre": "Sistema de matrícula",
      "descripcion": "Plataforma para registrar estudiantes"
    },
    {
      "nombre": "Portal académico",
      "descripcion": "Consulta de notas y horarios"
    }
  ]
}
```

### Respuesta esperada

```json
{
  "id": 1,
  "nombre": "Ana López",
  "carrera": "Ingeniería en Sistemas",
  "proyectos": [
    {
      "id": 1,
      "nombre": "Sistema de matrícula",
      "descripcion": "Plataforma para registrar estudiantes"
    }
  ]
}
```

## Configuración local

El archivo `src/main/resources/application.properties` usa la siguiente configuración por defecto:

| Propiedad | Valor |
|---|---|
| `server.port` | `8080` |
| `spring.datasource.url` | `jdbc:postgresql://localhost:5432/registro_estudiantes_db` |
| `spring.datasource.username` | `postgres` |
| `spring.datasource.password` | `123` |
| `spring.jpa.hibernate.ddl-auto` | `update` |

## Requisitos

- Java 21
- Maven
- PostgreSQL en ejecución
- Base de datos `registro_estudiantes_db` creada

## Ejecución

### Windows PowerShell

```powershell
.\mvnw.cmd clean install
.\mvnw.cmd spring-boot:run
```

### Verificar el API

```text
GET http://localhost:8080/api/students
```

## Notas

- La relación entre `Student` y `Proyect` es de tipo **uno a muchos**.
- Al guardar un estudiante, sus proyectos quedan asociados automáticamente.
- Al eliminar un estudiante, sus proyectos también se eliminan por cascada.

---

<div style="text-align: center;">
  <p>Hecho con Spring Boot y un diseño simple.</p>
</div>


