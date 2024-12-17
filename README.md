# Proyecto de Prueba: Spring Boot con OAuth2 y Spring Security

Este es un proyecto de prueba que utiliza **Spring Boot**, **Spring Security** y **OAuth2** para implementar autenticación a través de **GitHub** y **Google**. Incluye endpoints básicos protegidos y no protegidos para demostrar la configuración.

---

## 🚀 Tecnologías utilizadas

- **Spring Boot**: Framework principal para el desarrollo de la aplicación.
- **Spring Security**: Proporciona autenticación y autorización.
- **OAuth2**: Implementa autenticación externa con proveedores como **GitHub** y **Google**.

---

## 📝 Endpoints

### **GreetingsController**

La aplicación contiene dos endpoints principales:

| Método | Endpoint       | Seguridad                   | Descripción                               |
|--------|----------------|-----------------------------|-------------------------------------------|
| GET    | `/sayhi`       | `permitAll` (No protegido)  | Retorna un saludo accesible a cualquiera. |
| GET    | `/sayhisec`    | `isAuthenticated()`         | Retorna un saludo solo si estás autenticado.|

### Código del controlador:
```java
@RestController
public class GreetingsController {

    @GetMapping("/sayhi")
    @PreAuthorize("permitAll()")
    public String sayHi() {
        return "Hi! This is a not secured endpoint";
    }

    @GetMapping("/sayhisec")
    @PreAuthorize("isAuthenticated()")
    public String sayHiSec() {
        return "Hi! This is a secured endpoint";
    }
}

🔑 Autenticación
Este proyecto configura autenticación a través de:

GitHub
Google
Para configurarlo correctamente, asegúrate de tener tus credenciales de OAuth2:

Configuración en application.properties o application.yml
properties
# Configuración de OAuth2 con GitHub
spring.security.oauth2.client.registration.github.client-id=TU_CLIENT_ID_GITHUB
spring.security.oauth2.client.registration.github.client-secret=TU_CLIENT_SECRET_GITHUB

# Configuración de OAuth2 con Google
spring.security.oauth2.client.registration.google.client-id=TU_CLIENT_ID_GOOGLE
spring.security.oauth2.client.registration.google.client-secret=TU_CLIENT_SECRET_GOOGLE
Ejecución del proyecto
Clona el repositorio:

bash

git clone https://github.com/Hectorlag/exampleoauth2.git
cd exampleoauth2
Configura tus credenciales en application.properties (ver sección anterior).

Ejecuta la aplicación con Maven

bash

mvn spring-boot:run
Accede a los endpoints:

No protegido: http://localhost:8080/sayhi
Protegido (requiere autenticación): http://localhost:8080/sayhisec
🌟 Objetivo del proyecto
El objetivo es demostrar la integración de OAuth2 con Spring Boot, permitiendo la autenticación a través de proveedores externos como GitHub y Google, y restringiendo el acceso a endpoints protegidos según las reglas de seguridad definidas.

🛠️ Próximos pasos (mejoras futuras)
Implementar logout.
Agregar un frontend básico para visualizar la autenticación.
Configurar autorización con roles específicos.
