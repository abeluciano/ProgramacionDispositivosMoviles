/**
 * Este programa implementa una calculadora básica con las operaciones de suma, resta, multiplicación y división.
 * El usuario puede seleccionar la operación deseada a través de un menú y proporcionar los operandos.
 * La calculadora continuará ejecutándose hasta que el usuario elija la opción de salir.
 *
 * Autor: Abel Luciano Aragon Alvaro
 * Fecha de creación: 23/03/2024
 * Última modificación: 23/03/2024
 */

fun main() {
    var continuar = true

    // Bucle principal para el menú de la calculadora
    while (continuar) {
        println("==== Menú ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")

        print("Seleccione una opción: ")
        val opcion = readLine()?.toIntOrNull()

        // Realizar la operación seleccionada
        when (opcion) {
            1 -> {
                val (num1, num2) = obtenerOperandos()
                println("Resultado: ${num1 + num2}")
            }
            2 -> {
                val (num1, num2) = obtenerOperandos()
                println("Resultado: ${num1 - num2}")
            }
            3 -> {
                val (num1, num2) = obtenerOperandos()
                println("Resultado: ${num1 * num2}")
            }
            4 -> {
                val (num1, num2) = obtenerOperandos()
                if (num2 != 0.0) {
                    println("Resultado: ${num1 / num2}")
                } else {
                    println("No se puede dividir por cero.")
                }
            }
            5 -> {
                println("Saliendo de la calculadora.")
                continuar = false
            }
            else -> println("Opción no válida. Por favor seleccione una opción del menú.")
        }
        println()
    }
}

/**
 * Función para obtener los operandos de la calculadora desde la entrada del usuario.
 * @return Par de operandos (números) ingresados por el usuario.
 */
fun obtenerOperandos(): Pair<Double, Double> {
    print("Ingrese el primer número: ")
    val num1 = readLine()?.toDoubleOrNull() ?: 0.0

    print("Ingrese el segundo número: ")
    val num2 = readLine()?.toDoubleOrNull() ?: 0.0

    return Pair(num1, num2)
}
