/**Clase para Cuenta Bancaria: Diseña una clase CuentaBancaria que tenga
 *  un saldo y un límite de retiro. Implementa métodos set y get para
 *  establecer y obtener el saldo, y añade un método para realizar retiros
 *  que tenga en cuenta el límite de retiro. Utilice el set para validar datos.
 *  @author: Abel Luciano Aragon ALvaro
 *  @Fecha de Creación:24/03/2024
 *  @Ultima modificación:26/03/2024
 *  */
// Definición de la clase CuentaBancaria
class CuentaBancaria(private var saldo: Double, private val limiteRetiro: Double) {

    // Método para obtener el saldo actual
    fun getSaldo(): Double {
        return saldo
    }

    // Método para establecer un nuevo saldo
    fun setSaldo(nuevoSaldo: Double) {
        saldo = nuevoSaldo
    }

    // Método para realizar un retiro de la cuenta
    fun realizarRetiro(cantidad: Double): Boolean {
        // Verifica si la cantidad a retirar es mayor que el saldo disponible
        // o si excede el límite de retiro permitido
        if (cantidad > saldo || cantidad > limiteRetiro) {
            println("No se puede retirar la cantidad especificada debido a saldo insuficiente o exceso de límite de retiro.")
            return false // Retorno false indicando que el retiro no fue exitoso
        }
        saldo -= cantidad // Realiza el retiro, disminuyendo el saldo
        println("Retiro exitoso. Saldo restante: $saldo") // Imprime un mensaje de retiro exitoso y muestra el saldo restante
        return true // Retorno true indicando que el retiro fue exitoso
    }
}

// Función principal del programa
fun main() {
    // Creación de una instancia de la clase CuentaBancaria con un saldo inicial de 1000 y un límite de retiro de 500
    val cuenta = CuentaBancaria(1000.0, 500.0)

    // Imprime el saldo inicial de la cuenta
    println("Saldo inicial: ${cuenta.getSaldo()}")

    // Realiza varios retiros de la cuenta y muestra los mensajes correspondientes
    cuenta.realizarRetiro(200.0)
    cuenta.realizarRetiro(800.0)
    cuenta.realizarRetiro(600.0)

    // Establece un nuevo saldo en la cuenta y muestra el saldo actualizado
    cuenta.setSaldo(2000.0)
    println("Nuevo saldo: ${cuenta.getSaldo()}")

    // Realiza un retiro después de haber actualizado el saldo y muestra el mensaje correspondiente
    cuenta.realizarRetiro(700.0)
}

