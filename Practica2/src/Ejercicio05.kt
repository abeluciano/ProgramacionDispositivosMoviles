/** Diseña un sistema de gestión de biblioteca que incluya las siguientes clases e interfaces:
 * Material: Una clase base abstracta que tiene propiedades como titulo,
 * autor, anioPublicacion,  y un método abstracto para mostrarDetalles().
 * Libro: Una subclase de Material que tiene propiedades adicionales como
 * género, número páginas y un método para mostrar los detalles del libro.
 * Revista: Una subclase de Material que tiene propiedades como issn, volumen,
 * número, editorial y un método para mostrar los detalles de la revista.
 * Usuario: Una clase que tiene propiedades como nombre, apellido, edad y
 * métodos para reservar y devolver materiales.
 * Biblioteca: Una clase que gestiona los materiales disponibles, los usuarios
 * registrados y las operaciones de préstamo y devolución.
 * Crear instancias de las subclases y ejecutar las operaciones de área y perímetro para cada instancia.
 *  @author: Abel Luciano Aragon ALvaro
 *  @Fecha de Creación:26/03/2024
 *  @Ultima modificación:26/03/2024
 *  */
// Definición de la clase abstracta Material
abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int
) {
    // Método abstracto para mostrar los detalles del material
    abstract fun mostrarDetalles()
}

// Definición de la clase Libro que hereda de Material
class Libro(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val genero: String,
    val numeroPaginas: Int
) : Material(titulo, autor, anioPublicacion) {
    // Implementación del método para mostrar los detalles del libro
    override fun mostrarDetalles() {
        println("Libro: $titulo")
        println("Autor: $autor")
        println("Año de Publicación: $anioPublicacion")
        println("Género: $genero")
        println("Número de Páginas: $numeroPaginas")
    }
}

// Definición de la clase Revista que hereda de Material
class Revista(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String
) : Material(titulo, autor, anioPublicacion) {
    // Implementación del método para mostrar los detalles de la revista
    override fun mostrarDetalles() {
        println("Revista: $titulo")
        println("Autor: $autor")
        println("Año de Publicación: $anioPublicacion")
        println("ISSN: $issn")
        println("Volumen: $volumen")
        println("Número: $numero")
        println("Editorial: $editorial")
    }
}

// Definición de la clase Usuario
class Usuario(
    val nombre: String,
    val apellido: String,
    val edad: Int
) {
    // Método para reservar un material
    fun reservarMaterial(material: Material) {
        println("$nombre $apellido ha reservado el material: ${material.titulo}")
    }

    // Método para devolver un material
    fun devolverMaterial(material: Material) {
        println("$nombre $apellido ha devuelto el material: ${material.titulo}")
    }
}

// Definición de la clase Biblioteca
class Biblioteca {
    // Lista mutable para almacenar los materiales disponibles
    private val materialesDisponibles = mutableListOf<Material>()
    // Lista mutable para almacenar los usuarios registrados
    private val usuariosRegistrados = mutableListOf<Usuario>()

    // Método para agregar un material a la biblioteca
    fun agregarMaterial(material: Material) {
        materialesDisponibles.add(material)
    }

    // Método para registrar un usuario en la biblioteca
    fun registrarUsuario(usuario: Usuario) {
        usuariosRegistrados.add(usuario)
    }

    // Método para prestar un material a un usuario
    fun prestarMaterial(material: Material, usuario: Usuario) {
        // Verifica si el material está disponible y el usuario está registrado
        if (materialesDisponibles.contains(material) && usuariosRegistrados.contains(usuario)) {
            println("Se ha prestado el material: ${material.titulo} a ${usuario.nombre} ${usuario.apellido}")
            materialesDisponibles.remove(material) // Elimina el material prestado de la lista de disponibles
        } else {
            println("No se puede prestar el material o el usuario no está registrado.")
        }
    }

    // Método para recibir la devolución de un material por parte de un usuario
    fun recibirDevolucion(material: Material, usuario: Usuario) {
        println("Se ha recibido la devolución del material: ${material.titulo} de ${usuario.nombre} ${usuario.apellido}")
        materialesDisponibles.add(material) // Agrega el material devuelto a la lista de disponibles
    }
}

// Función principal del programa
fun main() {
    // Creación de un libro y una revista
    val libro = Libro("El señor de los anillos", "J.R.R. Tolkien", 1954, "Fantasía", 1000)
    val revista = Revista("National Geographic", "Varios", 2021, "1234-5678", 100, 1, "National Geographic Society")

    // Creación de un usuario
    val usuario = Usuario("Juan", "Perez", 30)

    // Creación de una biblioteca
    val biblioteca = Biblioteca()

    // Agregar el libro y la revista a la biblioteca
    biblioteca.agregarMaterial(libro)
    biblioteca.agregarMaterial(revista)

    // Registrar al usuario en la biblioteca
    biblioteca.registrarUsuario(usuario)

    // Mostrar detalles del libro y la revista
    println("Detalles del libro:")
    libro.mostrarDetalles()

    println("\nDetalles de la revista:")
    revista.mostrarDetalles()

    // Operaciones de préstamo y devolución
    println("\nOperaciones de préstamo y devolución:")
    biblioteca.prestarMaterial(libro, usuario) // Préstamo del libro al usuario
    biblioteca.recibirDevolucion(libro, usuario) // Devolución del libro por el usuario
}
