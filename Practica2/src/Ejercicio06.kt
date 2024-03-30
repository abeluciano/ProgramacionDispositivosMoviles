/** Diseña un sistema de alquiler de vehículos que incluya interfaces
 * como VehiculoAlquilable con métodos para alquilar y devolver un
 * vehículo, y clases concretas como Coche y Moto que implementen esta interfaz.
 *  @author: Abel Luciano Aragon ALvaro
 *  @Fecha de Creación:26/03/2024
 *  @Ultima modificación:26/03/2024
 *  */

// Interfaz para los vehículos alquilables
interface VehiculoAlquilable {
    fun alquilar() // Método para alquilar un vehículo
    fun devolver() // Método para devolver un vehículo
}

// Clase base abstracta para los vehículos
abstract class Vehiculo(val modelo: String, val marca: String) {
    abstract fun mostrarDetalles() // Método abstracto para mostrar detalles del vehículo
}

// Clase concreta para los coches
class Coche(modelo: String, marca: String) : Vehiculo(modelo, marca), VehiculoAlquilable {
    var alquilado: Boolean = false // Indica si el coche está alquilado o no

    override fun alquilar() {
        if (!alquilado) {
            alquilado = true
            println("El coche $modelo de la marca $marca ha sido alquilado.")
        } else {
            println("El coche $modelo de la marca $marca ya está alquilado.")
        }
    }

    override fun devolver() {
        if (alquilado) {
            alquilado = false
            println("El coche $modelo de la marca $marca ha sido devuelto.")
        } else {
            println("El coche $modelo de la marca $marca ya está disponible.")
        }
    }

    override fun mostrarDetalles() {
        println("Detalles del coche:")
        println("Modelo: $modelo")
        println("Marca: $marca")
    }
}

// Clase concreta para las motos
class Moto(modelo: String, marca: String) : Vehiculo(modelo, marca), VehiculoAlquilable {
    var alquilado: Boolean = false // Indica si la moto está alquilada o no

    override fun alquilar() {
        if (!alquilado) {
            alquilado = true
            println("La moto $modelo de la marca $marca ha sido alquilada.")
        } else {
            println("La moto $modelo de la marca $marca ya está alquilada.")
        }
    }

    override fun devolver() {
        if (alquilado) {
            alquilado = false
            println("La moto $modelo de la marca $marca ha sido devuelta.")
        } else {
            println("La moto $modelo de la marca $marca ya está disponible.")
        }
    }

    override fun mostrarDetalles() {
        println("Detalles de la moto:")
        println("Modelo: $modelo")
        println("Marca: $marca")
    }
}

// Función principal del programa
fun main() {
    // Creación de un coche y una moto
    val coche = Coche("Golf", "Volkswagen")
    val moto = Moto("Ninja", "Kawasaki")

    // Mostrar detalles del coche
    coche.mostrarDetalles()
    // Alquilar el coche
    coche.alquilar()
    // Devolver el coche
    coche.devolver()
    // Intentar alquilar el coche nuevamente
    coche.alquilar()

    println()

    // Mostrar detalles de la moto
    moto.mostrarDetalles()
    // Alquilar la moto
    moto.alquilar()
    // Intentar alquilar la moto nuevamente
    moto.alquilar()
    // Devolver la moto
    moto.devolver()
}
