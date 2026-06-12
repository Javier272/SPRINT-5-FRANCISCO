
---

## Tecnologías
* **Frontend:** React, Axios para peticiones HTTP.
* **Backend:** Java 21, Spring Boot, Spring Data JPA, Lombok, Maven.
* **Base de Datos:** MySQL Alojada en Hostinger remoto.

---

---

## 2. Mejoras de Modularidad

Para solucionar los problemas detectados y asegurar la mantenibilidad del sistema, se aplicaron los siguientes principios:

### En el Backend (Spring Boot)
Se implementó una estricta **Arquitectura por Capas**:
* **Controllers** 
* **Services** 
* **Repositories** 
* **DTOs:** Se utilizaron objetos de transferencia de datos para evitar exponer las entidades de la base de datos directamente al cliente.

### En el Frontend (React)
Se modularizó el código evitando componentes monolíticos:
* Se separó la configuración y llamadas a la API en un módulo de servicios `src/services/metricsService.js`.
* Se encapsuló la lógica de creación de métricas en un componente independiente `AddMetricForm.jsx`.
* El componente principal `Dashboard.jsx` se dedicó exclusivamente al manejo de estados locales y la renderización del lienzo de Chart.js.

---

## Propuesta de Mejora Técnica Implementada (Destacado)

 Uso de DTOs para Creación de Registros y asi mejorar la separación de Capas.

* **Problema Identificado:** Si el sistema crece y requiere registrar nuevas métricas desde el dashboard, utilizar la entidad original (`DeveloperMetric`) directamente en los controladores HTTP expone la estructura interna de la base de datos a vulnerabilidades de manipulación de datos.
* **Justificación Técnica:** Acoplar la capa de presentación a la capa de persistencia viola los principios SOLID y reduce la seguridad del API.
* **Implementación Realizada:** 1. Se creó la clase **`CreateMetricRequestDTO`** que actúa como un escudo protector, aceptando únicamente los campos seguros que el usuario tiene permitido enviar.
  2. Se desarrolló un nuevo endpoint `POST /metrics` en el controlador.
  3. En la capa Service, se implementó un mapeo seguro para trasladar los datos del DTO a una nueva Entidad real antes de guardarla en MySQL.
  4. En el Frontend, se construyó el componente `AddMetricForm` que consume este nuevo endpoint, permitiendo actualizar la base de datos en tiempo real y refrescando automáticamente la gráfica.

---

## Instrucciones de Ejecución

### Requisitos
* JDK 21 instalado.
* Node.js y npm instalados.

### Corre el Backend
1. Navegar a la carpeta backFinalProgramacionWeb/demo (`demo`).
2. Abrir una terminal y ejecutar el comando:
   mvn clean spring-boot:run

## Corre el frontend
1. Navega a la carpeta gitFinalFrontProgramacionWeb/productivity-dashboard