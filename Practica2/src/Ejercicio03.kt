/** Crea un sistema de gestión de empleados que incluya las siguientes clases:
 * Empleado: Una clase base abstracta que tiene propiedades como nombre,
 * apellido, edad, salario y un método abstracto calcularPago() para calcular el pago.
 * EmpleadoTiempoCompleto: Una subclase de Empleado que tiene propiedades
 * adicionales como horasTrabajadas, tarifaHora y un método para calcular el
 * pago teniendo en cuenta las horas trabajadas.
 * EmpleadoMedioTiempo: Una subclase de Empleado que tiene propiedades como
 * horasTrabajadas, tarifaHora, diasTrabajados y un método para calcular el
 * pago tomando en cuenta las horas y los días trabajados.
 * Crear instancias de las subclases y ejecutar las operaciones para
 * realizar las pruebas necesarias.
 *  @author: Abel Luciano Aragon ALvaro
 *  @Fecha de Creación:26/03/2024
 *  @Ultima modificación:26/03/2024
 *  */

// Definición de la clase abstracta Empleado
abstract class Empleado(
    val nombre: String,
    val apellido: String,
    val edad: Int,
    var salario: Double
) {
    // Método abstracto para calcular el pago del empleado, debe ser implementado por las subclases
    abstract fun calcularPago(): Double
}

// Definición de la subclase EmpleadoTiempoCompleto que hereda de Empleado
class EmpleadoTiempoCompleto(
    nombre: String,
    apellido: String,
    edad: Int,
    salario: Double,
    val horasTrabajadas: Int,
    val tarifaHora: Double
) : Empleado(nombre, apellido, edad, salario) {
    // Implementación del método abstracto para calcular el pago del empleado a tiempo completo
    override fun calcularPago(): Double {
        return horasTrabajadas * tarifaHora
    }
}

// Definición de la subclase EmpleadoMedioTiempo que hereda de Empleado
class EmpleadoMedioTiempo(
    nombre: String,
    apellido: String,
    edad: Int,
    salario: Double,
    val horasTrabajadas: Int,
    val tarifaHora: Double,
    val diasTrabajados: Int
) : Empleado(nombre, apellido, edad, salario) {
    // Implementación del método abstracto para calcular el pago del empleado a medio tiempo
    override fun calcularPago(): Double {
        return horasTrabajadas * tarifaHora * diasTrabajados
    }
}

// Función principal del programa
fun main() {
    // Creación de una instancia de EmpleadoTiempoCompleto y cálculo de su pago
    val empleadoTiempoCompleto = EmpleadoTiempoCompleto("Juan", "Perez", 30, 0.0, 40, 10.0)
    println("Pago del empleado a tiempo completo: ${empleadoTiempoCompleto.calcularPago()}")

    // Creación de una instancia de EmpleadoMedioTiempo y cálculo de su pago
    val empleadoMedioTiempo = EmpleadoMedioTiempo("Maria", "Gomez", 25, 0.0, 20, 8.0, 5)
    println("Pago del empleado a medio tiempo: ${empleadoMedioTiempo.calcularPago()}")
}

