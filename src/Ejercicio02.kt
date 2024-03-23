/**
 * Este programa implementa el juego de Piedra, Papel o Tijera en Kotlin.
 * El usuario juega contra la computadora. Ambos eligen una opción entre piedra, papel o tijera,
 * y el programa determina quién gana según las reglas del juego.
 *
 * Autor: Abel Luciano Aragon Alvaro
 * Fecha de creación: 23/03/2024
 * Última modificación: 23/03/2024
 */

import kotlin.random.Random

fun main() {
    // Obtener la opción aleatoria de la computadora
    val opcionComputadora = obtenerOpcionAleatoria(Random.nextInt(0, 3))

    println("Bienvenido al juego de Piedra, Papel o Tijera.")
    println("La computadora ha elegido su opción.")

    // Solicitar al usuario que elija una opción
    println("¿Qué opción eliges? (piedra, papel, tijera): ")
    val opcionUsuario = readLine()?.trim()?.toLowerCase() ?: ""

    // Mostrar la opción elegida por la computadora
    println("La computadora eligió $opcionComputadora.")

    // Determinar el resultado del juego
    val resultado = determinarResultado(opcionUsuario, opcionComputadora)
    println(resultado)
}

/**
 * Función para obtener una opción aleatoria entre piedra, papel o tijera.
 * @param numero Número aleatorio generado para elegir la opción.
 * @return La opción aleatoria generada.
 */
fun obtenerOpcionAleatoria(numero: Int): String {
    return when (numero) {
        0 -> "piedra"
        1 -> "papel"
        else -> "tijera"
    }
}

/**
 * Función para determinar el resultado del juego.
 * @param opcionUsuario Opción elegida por el usuario.
 * @param opcionComputadora Opción elegida por la computadora.
 * @return El resultado del juego (ganar, perder o empate).
 */
fun determinarResultado(opcionUsuario: String, opcionComputadora: String): String {
    return if (opcionUsuario == opcionComputadora) {
        "¡Es un empate!"
    } else if (
        opcionUsuario == "piedra" && opcionComputadora == "tijera" ||
        opcionUsuario == "papel" && opcionComputadora == "piedra" ||
        opcionUsuario == "tijera" && opcionComputadora == "papel"
    ) {
        "¡Ganaste!"
    } else {
        "¡Perdiste!"
    }
}