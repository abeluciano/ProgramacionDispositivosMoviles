/**
 * Este programa evalúa el rendimiento de un empleado según una puntuación dada en una evaluación y su salario mensual.
 * Calcula el nivel de rendimiento del empleado y la cantidad de dinero adicional que recibirá en función de su puntuación.
 * Luego, muestra los resultados al usuario.
 *
 * Autor: Abel Luciano Aragon Alvaro
 * Fecha de creación: 23/03/2024
 * Última modificación: 23/03/2024
 */

fun main() {
    println("Evaluación de Empleados")

    // Solicitar la puntuación del usuario y su salario mensual
    print("Ingrese su puntuación en la evaluación (0 a 10): ")
    val puntuacion = readLine()?.toDoubleOrNull()

    print("Ingrese su salario mensual: ")
    val salario = readLine()?.toDoubleOrNull()

    // Validar la entrada del usuario
    if (puntuacion == null || puntuacion !in 0.0..10.0 || salario == null || salario <= 0.0) {
        println("Entrada inválida. Asegúrese de ingresar una puntuación entre 0 y 10 y un salario mensual válido.")
        return
    }

    // Calcular el nivel de rendimiento y la cantidad de dinero recibido
    val nivel = calcularNivelRendimiento(puntuacion)
    val dineroRecibido = salario * (puntuacion / 10.0)

    // Imprimir los resultados
    println("Resultado:")
    println("Nivel de Rendimiento: $nivel")
    println("Cantidad de Dinero Recibido: $$dineroRecibido")
}

/**
 * Función para calcular el nivel de rendimiento del empleado en función de su puntuación.
 * @param puntuacion La puntuación del empleado en la evaluación.
 * @return El nivel de rendimiento del empleado (Excelente, Bueno, Aceptable, Insuficiente).
 */
fun calcularNivelRendimiento(puntuacion: Double): String {
    return when {
        puntuacion >= 9.0 -> "Excelente"
        puntuacion >= 7.0 -> "Bueno"
        puntuacion >= 5.0 -> "Aceptable"
        else -> "Insuficiente"
    }
}
