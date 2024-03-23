/**
 * Este programa solicita al usuario la cantidad de alumnos en un salón y luego solicita la edad de cada alumno.
 * Calcula la edad máxima, la edad mínima y muestra todas las edades ingresadas.
 * Si se ingresa una cantidad de alumnos no válida o una edad no válida, muestra un mensaje de error.
 *
 * Autor: Abel Luciano Aragon Alvaro
 * Fecha de creación: 23/03/2024
 * Última modificación: 23/03/2024
 */

import kotlin.math.max
import kotlin.math.min

fun main() {
    // Solicitar al usuario la cantidad de alumnos en el salón
    println("Ingrese la cantidad de alumnos en el salón:")
    val cantidadAlumnos = readLine()?.toIntOrNull()

    // Verificar si la cantidad de alumnos ingresada es válida
    if (cantidadAlumnos == null || cantidadAlumnos <= 0) {
        println("Cantidad de alumnos inválida. Por favor, ingrese un número entero positivo.")
        return
    }

    // Inicializar variables para la edad máxima, la edad mínima y las edades ingresadas
    var edadMaxima = Int.MIN_VALUE
    var edadMinima = Int.MAX_VALUE
    var todasLasEdades = ""

    // Solicitar la edad de cada alumno y calcular la edad máxima y mínima
    println("Ingrese la edad de cada alumno:")
    for (i in 1..cantidadAlumnos) {
        println("Edad del alumno $i:")
        val edad = readLine()?.toIntOrNull()

        // Verificar si la edad ingresada es válida
        if (edad == null || edad <= 0) {
            println("Edad inválida para el alumno $i. Por favor, ingrese un número entero positivo.")
            return
        }

        // Actualizar la edad máxima y mínima
        edadMaxima = max(edadMaxima, edad)
        edadMinima = min(edadMinima, edad)

        // Construir la lista de edades ingresadas
        todasLasEdades += "$edad"
        if (i < cantidadAlumnos) {
            todasLasEdades += ", "
        }
    }

    // Mostrar el resultado de las edades
    println("=== Edades ===")
    println("Máximo = $edadMaxima")
    println("Mínimo = $edadMinima")
    println("Todos = $todasLasEdades")
}
