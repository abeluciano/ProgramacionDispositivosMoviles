/**Diseña una clase Producto que tenga un precio y un descuento aplicable.
 * Implementa métodos set y get para establecer y obtener el precio y el
 * descuento, y añade un método para calcular el precio final después de
 * aplicar el descuento. Utilice el set para validar datos.
 *  @author: Abel Luciano Aragon ALvaro
 *  @Fecha de Creación:26/03/2024
 *  @Ultima modificación:26/03/2024
 *  */
// Definición de la clase Producto
class Producto(private var precio: Double, private var descuento: Double) {

    // Inicializador de la clase
    init {
        // Verifica si el precio es negativo
        if (precio < 0) {
            throw IllegalArgumentException("El precio no puede ser negativo")
        }
        // Verifica si el descuento está fuera del rango permitido (0-100)
        if (descuento < 0 || descuento > 100) {
            throw IllegalArgumentException("El descuento debe estar entre 0 y 100")
        }
    }

    // Método para obtener el precio del producto
    fun getPrecio(): Double {
        return precio
    }

    // Método para establecer un nuevo precio al producto
    fun setPrecio(nuevoPrecio: Double) {
        // Verifica si el nuevo precio es negativo
        if (nuevoPrecio < 0) {
            throw IllegalArgumentException("El precio no puede ser negativo")
        }
        precio = nuevoPrecio
    }

    // Método para obtener el descuento aplicado al producto
    fun getDescuento(): Double {
        return descuento
    }

    // Método para establecer un nuevo descuento al producto
    fun setDescuento(nuevoDescuento: Double) {
        // Verifica si el nuevo descuento está fuera del rango permitido (0-100)
        if (nuevoDescuento < 0 || nuevoDescuento > 100) {
            throw IllegalArgumentException("El descuento debe estar entre 0 y 100")
        }
        descuento = nuevoDescuento
    }

    // Método para calcular el precio final del producto después de aplicar el descuento
    fun calcularPrecioFinal(): Double {
        return precio * (1 - descuento / 100)
    }
}

// Función principal del programa
fun main() {
    // Creación de una instancia de la clase Producto con un precio inicial de 100 y un descuento del 10%
    val producto = Producto(100.0, 10.0)

    // Imprime el precio inicial, el descuento aplicable y el precio final del producto
    println("Precio inicial: ${producto.getPrecio()}")
    println("Descuento aplicable: ${producto.getDescuento()}%")
    println("Precio final: ${producto.calcularPrecioFinal()}")

    // Cambiando el precio y el descuento del producto
    producto.setPrecio(120.0)
    producto.setDescuento(20.0)

    // Imprime el precio actualizado, el descuento aplicable y el nuevo precio final del producto
    println("\nPrecio actualizado: ${producto.getPrecio()}")
    println("Descuento aplicable: ${producto.getDescuento()}%")
    println("Nuevo precio final: ${producto.calcularPrecioFinal()}")
}

