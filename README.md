# Sistema de Gestión de Productos

## Autores 

### Jhojanth Camilo Alegria Escobar

### Andres Mauricio Quintero Rios


Este es un sistema de gestión de inventario desarrollado en Java que permite administrar productos, realizar compras, ventas y aplicar descuentos.

## Características Principales

- Registro de productos con nombre, categoría, precio y stock
- Control de inventario con seguimiento de stock mínimo
- Gestión de compras y ventas
- Aplicación de descuentos a productos
- Interfaz de consola interactiva

## Estructura del Proyecto

El proyecto consta de dos clases principales:

1. **Producto.java**: Clase que representa un producto con sus atributos y métodos.
2. **Main.java**: Clase principal que demuestra el uso de la clase Producto.

## Requisitos

- Java JDK 8 o superior
- No se requieren dependencias externas

## Instalación

1. Clona o descarga el repositorio
2. Navega hasta el directorio del proyecto
3. Compila los archivos Java:
   ```
   javac *.java
   ```
4. Ejecuta la aplicación:
   ```
   java Main
   ```

## Uso

La aplicación de demostración en `Main.java` muestra cómo:
- Crear productos
- Aplicar descuentos
- Registrar compras y ventas
- Gestionar el inventario
- Mostrar información de productos

## Métodos Principales

- `mostrarInformacion()`: Muestra todos los detalles de un producto
- `aplicarDescuento(double porcentaje)`: Aplica un descuento al precio
- `registrarCompra(int cantidad)`: Añade unidades al inventario
- `registrarVenta(int cantidad)`: Reduce el inventario por ventas
- `marcarComoDisponible()`: Cambia el estado de disponibilidad

## Ejemplo de Uso

```java
// Crear un nuevo producto
Producto laptop = new Producto("Laptop", "Tecnología", 1500.0, 10, true, 2);

// Aplicar descuento del 10%
laptop.aplicarDescuento(10);

// Registrar compra de 5 unidades
laptop.registrarCompra(5);

// Registrar venta de 3 unidades
laptop.registrarVenta(3);

// Mostrar información del producto
laptop.mostrarInformacion();
```

## Contribución

Las contribuciones son bienvenidas. Por favor, envía un Pull Request con tus mejoras propuestas.

## Licencia

Este proyecto está bajo la Licencia MIT.
