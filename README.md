# 🚀 stripePayment – Integración moderna con Stripe y Spring Boot

Bienvenido a **stripePayment**, un proyecto de ejemplo que te muestra cómo integrar de forma sencilla y elegante la API de Stripe en una aplicación web Java usando Spring Boot y Thymeleaf. Ideal para aprender, experimentar o como base para tus propios desarrollos de pagos online.

---

## ✨ ¿Qué hace este proyecto?

- 🔗 **Conexión directa con Stripe:** Gestiona clientes y operaciones básicas desde una interfaz web.
- 🖥️ **Frontend atractivo:** Usa Thymeleaf y Bootstrap para una experiencia de usuario moderna y responsiva.
- ⚡ **Listo para ampliar:** Código limpio y modular, pensado para que puedas agregar más funcionalidades fácilmente.

---

## 🛠️ Requisitos previos

- **Java 17** o superior
- **Maven**
- **Cuenta de Stripe** (puedes crear una gratis en [stripe.com](https://dashboard.stripe.com/register))

---

## ⚙️ Configuración rápida

> **¡Atención!**  
> Por seguridad, el archivo `application.properties` **NO está incluido** en el repositorio.  
> **Debes crearlo tú mismo** en la siguiente ruta:

```
src/main/resources/application.properties
```

Y agregar tu clave secreta de Stripe así:

```
stripe.apikey=sk_test_xxxxxxxxxxxxxxxxxxxxxxxx
```

_Reemplaza `sk_test_xxxxxxxxxxxxxxxxxxxxxxxx` por tu propia API key de Stripe._

---

## 🚦 ¿Cómo lo ejecuto?

1. **Clona el repositorio**  
   ```sh
   git clone https://github.com/tuusuario/stripePayment.git
   cd stripePayment
   ```

2. **Agrega tu `application.properties`** (como se explicó arriba).

3. **Inicia la aplicación**  
   ```sh
   mvn spring-boot:run
   ```

4. **Abre tu navegador** y visita:  
   [http://localhost:8080](http://localhost:8080)

---

## 📝 Notas importantes

- **Nunca compartas tu API key de Stripe.**
- Este proyecto es solo para fines educativos y pruebas.
- Puedes personalizar y ampliar la lógica según tus necesidades.


