# ☕ Sistemas Orientados a Servicios – Práctica 2 (Servicio Web SOAP)

## 🧩 Descripción general
Proyecto correspondiente a la **segunda práctica de la asignatura Sistemas Orientados a Servicios (ETSIINF-UPM)**.  
Consiste en la **definición e implementación de un servicio web SOAP**, llamado **ETSIINFLibrary**, desarrollado en **Java** con **Apache Axis2 (v1.6.2)** y desplegable en **Tomcat**.  

El sistema simula una **biblioteca online**, permitiendo gestionar usuarios y libros, así como operaciones de préstamo y devolución.  
El proyecto se divide en dos módulos principales:
- **ETSIINFLibraryServiceSS** → Implementación del servicio SOAP.
- **ETSIINFLibraryCliente** → Cliente Java para invocar y probar las operaciones del servicio.

---

## 🎯 Objetivos principales
- Implementar un **servicio web completo (SOAP)** a partir del archivo **WSDL** proporcionado.  
- Integrar el servicio con otro web service externo:  
  **UPMAuthenticationAuthorization**, responsable de la autenticación de usuarios.  
- Implementar un **cliente Java** para probar las operaciones del servicio.  
- Gestionar el estado del sistema en **memoria** (sin base de datos).  
- Probar operaciones simultáneas con múltiples clientes activos.  

---

## ⚙️ Tecnologías utilizadas
- **Lenguaje:** Java 8  
- **Framework:** Apache Axis2 (v1.6.2)  
- **Servidor:** Apache Tomcat  
- **Entorno:** Eclipse IDE  
- **Arquitectura:** SOAP / WSDL  
- **Dependencias externas:**  
  - `ETSIINFLibrary.wsdl`  
  - `UPMAuthenticationAuthorization.wsdl`

---

## 🧱 Estructura del proyecto

### 📂 ETSIINFLibraryServiceSS (Servicio SOAP)
| Ruta / Archivo | Descripción |
|----------------|-------------|
| **`src/es/upm/sos/practica2/ETSIINFLibrarySkeleton.java`** | Clase principal del servicio. Implementa todas las operaciones definidas en el WSDL (añadir usuario, login, añadir libro, préstamo, etc.). |
| **`src/es/upm/sos/practica2/ETSIINFLibraryMessageReceiverInOut.java`** | Clase generada automáticamente por Axis2 para la comunicación SOAP (entrada/salida de mensajes). |
| **`src/es/upm/sos/model/`** | Clases generadas a partir del WSDL: `AddUser.java`, `Login.java`, `BorrowBook.java`, `ListBooks.java`, etc. |
| **`src/es/upm/upmauth/stub/`** | Clases del stub del servicio externo de autenticación (`UPMAuthenticationAuthorization`). |
| **`resources/ETSIINFLibrary.wsdl`** | Archivo WSDL principal del servicio ETSIINF. |
| **`resources/services.xml`** | Configuración de Axis2 para el despliegue del servicio (definición del endpoint). |
| **`build.xml`** | Script de construcción con **Ant** para generar el archivo `.aar` (Axis Archive) desplegable en Tomcat. |

### 📂 ETSIINFLibraryCliente (Cliente Java)
| Ruta / Archivo | Descripción |
|----------------|-------------|
| **`src/es/upm/sos/client/ETSIINFLibraryStub.java`** | Stub generado a partir del WSDL del servicio ETSIINFLibrary. |
| **`src/es/upm/sos/client/ETSIINFLibraryTestClient.java`** | Cliente de prueba principal que invoca todas las operaciones del servicio. |
| **`src/es/upm/sos/client/ETSIINFLibraryCallbackHandler.java`** | Clase auxiliar generada automáticamente para manejar callbacks SOAP. |
| **`ETSIINFLibrary.wsdl`** | Copia local del WSDL utilizado para generar el stub. |
| **`build.xml`** | Script de compilación y ejecución del cliente. |

---

## 🔧 Principales operaciones implementadas
| Operación | Descripción |
|------------|-------------|
| **addUser(Username)** | Añade un nuevo usuario (solo el admin puede hacerlo). Llama internamente al servicio externo UPMAuthenticationAuthorization. |
| **login(User)** | Inicia sesión de usuario; valida credenciales con el servicio externo. |
| **logout()** | Cierra todas las sesiones activas del usuario autenticado. |
| **deleteUser(Username)** | Elimina un usuario (solo el admin puede hacerlo). |
| **changePassword(PasswordPair)** | Cambia la contraseña de un usuario autenticado. |
| **addBook(Book)** | Añade un libro a la biblioteca (solo admin). |
| **deleteBook(String ISSN)** | Elimina un ejemplar de un libro. |
| **getBook(String ISSN)** | Devuelve la información de un libro. |
| **listBooks()** | Lista los libros de la biblioteca. |
| **getBooksFromAuthor(Author)** | Devuelve los libros de un autor específico. |
| **borrowBook(String ISSN)** | Permite al usuario pedir prestado un libro. |
| **returnBook(String ISSN)** | Devuelve un libro prestado. |
| **listBorrowedBooks()** | Muestra los libros que el usuario tiene actualmente prestados. |
