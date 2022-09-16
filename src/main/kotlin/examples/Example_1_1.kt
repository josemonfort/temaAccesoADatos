package examples


import java.io.File

fun main(args: Array<String>) {
    val f = File(".")
    println("Llista de fitxers i directoris del directori actual")
    println("---------------------------------------------------")
    for (e in f.list())
        println(e);
}