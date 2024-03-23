/**
 * Este programa implementa el juego "Adivina el Número", donde el usuario intenta adivinar un número aleatorio generado por la computadora.
 * El usuario tiene un número limitado de intentos para adivinar el número correctamente.
 *
 * Autor: Abel Luciano Aragon Alvaro
 * Fecha de creación: 23/03/2024
 * Última modificación: 23/03/2024
 */

import kotlin.random.Random

fun main() {
    // Generar un número aleatorio entre 1 y 30
    val numeroAleatorio = Random.nextInt(1, 31)
    var intentos = 5
    var adivinado = false

    // Mostrar mensaje de bienvenida y reglas del juego
    println("Bienvenido al juego de Adivina el Número!")
    println("Tienes 5 intentos para adivinar un número entre 1 y 30.")

    // Bucle principal del juego
    while (intentos > 0 && !adivinado) {
        print("Ingresa tu número (Intentos restantes: $intentos): ")
        val intento = readLine()?.toIntOrNull()

        // Verificar si el número ingresado es válido
        if (intento == null || intento !in 1..30) {
            println("Por favor, ingresa un número válido entre 1 y 30.")
            continue
        }

        // Comprobar si el número ingresado coincide con el número aleatorio
        if (intento == numeroAleatorio) {
            println("¡Felicitaciones! ¡Has adivinado el número correctamente!")
            adivinado = true
        } else {
            // Informar al usuario si el número ingresado es mayor o menor que el número aleatorio
            if (intento < numeroAleatorio) {
                println("El número a adivinar es mayor.")
            } else {
                println("El número a adivinar es menor.")
            }
            intentos--
        }
    }

    // Mostrar mensaje de juego terminado si el usuario no adivinó el número
    if (!adivinado) {
        println("Game over. El número a adivinar era $numeroAleatorio.")
    }
}
