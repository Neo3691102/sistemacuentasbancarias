# 💳 Sistema de Manejo de Cuentas Bancarias

Aplicación web para la gestión de cuentas bancarias desarrollada con **Spring Boot 3**, **Jakarta Faces (JSF)** y **PrimeFaces**, utilizando **Spring Data JPA (Hibernate)** y **MySQL** como base de datos.

El sistema permite realizar operaciones CRUD completas (Crear, Leer, Actualizar y Eliminar) mediante una interfaz web dinámica con soporte AJAX.

---

## 🚀 Tecnologías Utilizadas

- ☕ Java 21  
- 🌱 Spring Boot 3.1.12  
- 🖥 Jakarta Faces (JSF 3+)  
- 🎨 PrimeFaces  
- 🔗 JoinFaces  
- 🗄 Spring Data JPA (Hibernate)  
- 🐬 MySQL  
- 📦 Maven  

---

## 🏗 Arquitectura del Proyecto

El proyecto sigue una arquitectura en capas:

```
Controller (JSF Managed Bean)
        ↓
Service (Lógica de negocio)
        ↓
Repository (Spring Data JPA)
        ↓
Base de Datos (MySQL)
```

### 🔹 Controller

`IndexController`

Responsabilidades:

- Gestionar la interacción con la vista (JSF)
- Manejar el estado de la vista con `@ViewScoped`
- Ejecutar operaciones CRUD
- Actualizar componentes mediante AJAX (PrimeFaces)

Anotaciones utilizadas:

```java
@Component
@ViewScoped
```

---

## 🧱 Entidad JPA

```java
@Entity
public class Cuenta
```

Campos:

- `idCuenta` → Identificador único (Primary Key)
- `nombre` → Nombre de la cuenta
- `tipoCuenta` → Tipo (Ahorro, Crédito, Inversión)
- `saldo` → Saldo disponible

---

## ⚙️ Funcionalidades

- ✔ Listar cuentas  
- ✔ Crear nueva cuenta  
- ✔ Editar cuenta existente  
- ✔ Eliminar cuenta  
- ✔ Confirmación de eliminación  
- ✔ Formato de moneda  
- ✔ Actualización dinámica con AJAX  
- ✔ Mensajes dinámicos con Growl  

---

## 🖥 Interfaz de Usuario

Componentes principales de PrimeFaces utilizados:

- `<p:dataTable>` → Tabla dinámica de cuentas
- `<p:dialog>` → Formulario modal para crear/editar
- `<p:confirmDialog>` → Confirmación de eliminación
- `<p:growl>` → Mensajes informativos
- `<p:commandButton>` → Acciones AJAX

---

## 🛠 Instalación y Ejecución

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/tu-repo.git
cd tu-repo
```

---

### 2️⃣ Crear base de datos MySQL

```sql
CREATE DATABASE cuentas_db;
```

---

### 3️⃣ Configurar `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/cuentas_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 4️⃣ Ejecutar la aplicación

Desde consola:

```bash
mvn spring-boot:run
```

O ejecutarlo desde tu IDE.

La aplicación estará disponible en:

```
http://localhost:8080
```

---

## 📂 Estructura del Proyecto

```
src/main/java/
│
├── controllers/
│   └── IndexController.java
│
├── modelo/
│   └── Cuenta.java
│
├── servicio/
│   └── CuentaServicio.java
│
└── repository/
    └── CuentaRepository.java
```

---

## 🔄 Flujo de Operaciones

### ➕ Agregar Cuenta

1. Se abre el diálogo modal.
2. Se crea una nueva instancia de `Cuenta`.
3. Se guarda en base de datos.
4. Se actualiza la tabla vía AJAX.

### ✏ Editar Cuenta

1. Se selecciona una cuenta desde la tabla.
2. Se asigna a `cuentaSeleccionada`.
3. Se actualiza en base de datos.
4. Se refresca la vista dinámicamente.

### 🗑 Eliminar Cuenta

1. Se muestra diálogo de confirmación.
2. Se elimina el registro en base de datos.
3. Se actualiza la lista en memoria.
4. Se refresca la tabla.

---

## 📊 Modelo de Datos

```
Cuenta
--------------------------------
idCuenta    INT (PK)
nombre      VARCHAR
tipoCuenta  VARCHAR
saldo       DOUBLE
```

---

## 🎯 Objetivo del Proyecto

Este proyecto fue desarrollado para:

- Practicar integración de Spring Boot con JSF
- Implementar PrimeFaces en entorno Jakarta EE 10
- Aplicar arquitectura en capas
- Gestionar estado con ViewScoped
- Implementar operaciones AJAX con PrimeFaces
- Desarrollar una aplicación web empresarial básica

---

## 🔮 Posibles Mejoras Futuras

- Implementar autenticación con Spring Security  
- Validaciones avanzadas con Bean Validation  
- Paginación y filtros en DataTable  
- Dockerización  
- API REST complementaria  
- Pruebas unitarias y de integración  

---

## 👨‍💻 Autor

**Néstor Castañeda**  
Desarrollador backend junior  

---

## 📄 Licencia

Proyecto de uso académico y demostrativo.
