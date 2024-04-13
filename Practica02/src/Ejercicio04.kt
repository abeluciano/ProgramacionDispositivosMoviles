/**Cree una clase abstracta “shape” la cual contenga las propiedades área,
 * perímetro y las funciones para calcular estos valores e imprimir el
 * resultado de cada operación. Adicional crea tres subclases cuadrado,
 * círculo y rectángulo que reciban los valores de sus lados, el radio
 * en el caso del círculo con constructores secundarios y heredando la
 * clase “shape” y sus métodos. Crear instancias de las subclases y ejecutar
 * las operaciones de área y perímetro para cada instancia.
 *  @author: Abel Luciano Aragon ALvaro
 *  @Fecha de Creación:26/03/2024
 *  @Ultima modificación:26/03/2024
 *  */
import kotlin.math.PI

// Definición de la clase abstracta Shape
abstract class Shape {
    // Propiedades abstractas para el área y el perímetro
    abstract val area: Double
    abstract val perimeter: Double

    // Métodos abstractos para calcular el área y el perímetro
    abstract fun calculateArea()
    abstract fun calculatePerimeter()

    // Método para imprimir el área de la forma
    fun printArea() {
        println("Área: $area")
    }

    // Método para imprimir el perímetro de la forma
    fun printPerimeter() {
        println("Perímetro: $perimeter")
    }
}

// Definición de la clase Square que representa un cuadrado
class Square(private val sideLength: Double) : Shape() {
    // Propiedades para el área y el perímetro del cuadrado
    override var area: Double = 0.0
    override var perimeter: Double = 0.0

    // Inicializador que calcula el área y el perímetro del cuadrado
    init {
        calculateArea()
        calculatePerimeter()
    }

    // Implementación del método para calcular el área del cuadrado
    override fun calculateArea() {
        area = sideLength * sideLength
    }

    // Implementación del método para calcular el perímetro del cuadrado
    override fun calculatePerimeter() {
        perimeter = 4 * sideLength
    }
}

// Definición de la clase Circle que representa un círculo
class Circle(private val radius: Double) : Shape() {
    // Propiedades para el área y el perímetro del círculo
    override var area: Double = 0.0
    override var perimeter: Double = 0.0

    // Inicializador que calcula el área y el perímetro del círculo
    init {
        calculateArea()
        calculatePerimeter()
    }

    // Implementación del método para calcular el área del círculo
    override fun calculateArea() {
        area = PI * radius * radius
    }

    // Implementación del método para calcular el perímetro del círculo
    override fun calculatePerimeter() {
        perimeter = 2 * PI * radius
    }
}

// Definición de la clase Rectangle que representa un rectángulo
class Rectangle(private val length: Double, private val width: Double) : Shape() {
    // Propiedades para el área y el perímetro del rectángulo
    override var area: Double = 0.0
    override var perimeter: Double = 0.0

    // Inicializador que calcula el área y el perímetro del rectángulo
    init {
        calculateArea()
        calculatePerimeter()
    }

    // Implementación del método para calcular el área del rectángulo
    override fun calculateArea() {
        area = length * width
    }

    // Implementación del método para calcular el perímetro del rectángulo
    override fun calculatePerimeter() {
        perimeter = 2 * (length + width)
    }
}

// Función principal del programa
fun main() {
    // Creación de un cuadrado con un lado de longitud 5
    val square = Square(5.0)
    println("Cuadrado:")
    square.printArea() // Imprime el área del cuadrado
    square.printPerimeter() // Imprime el perímetro del cuadrado

    // Creación de un círculo con un radio de longitud 3
    val circle = Circle(3.0)
    println("\nCírculo:")
    circle.printArea() // Imprime el área del círculo
    circle.printPerimeter() // Imprime el perímetro del círculo

    // Creación de un rectángulo con longitudes de lados 4 y 6
    val rectangle = Rectangle(4.0, 6.0)
    println("\nRectángulo:")
    rectangle.printArea() // Imprime el área del rectángulo
    rectangle.printPerimeter() // Imprime el perímetro del rectángulo
}
