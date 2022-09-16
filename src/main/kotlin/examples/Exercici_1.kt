package examples

import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

fun main(args: Array<String>) {
    var f: File = File.listRoots()[0]
    var indice: Int = 0

    do {
        llistaDirectori(f)
        val lista = f.listFiles().sorted()
        println("Introduce un numero: ")
        val ent = BufferedReader(InputStreamReader(System.`in`)).readLine()
        indice = ent.toInt()
        if (indice > lista.size) {
            println("Este directorio no esta")
        } else if (indice == 0) {
            if (f.parent != null) {
                f = f.parentFile
            }
        } else if (!f.canRead()) {
            println("No tienes permisos")
        } else if (!f.isDirectory) {
            println("No es un directorio")
        } else if (indice > 0) {            //Comprueba si el indice es mayor a 0, f sera el indice de la lista -1
            f = lista[indice - 1]
        }
    } while (indice != -1)
}

fun llistaDirectori(f: File) {
    var contador: Int = 1
    val s = "Lista de ficheros y directorios del directorio " + f.getCanonicalPath()
    println(s)
    println("-".repeat(s.length))
    println("0 Directorio padre")
    for (e in f.listFiles().sorted()) {
        if (e.isFile())
            println("$contador " + e.getName() + "\t " + e.length())
        if (e.isDirectory())
            println("$contador " + e.getName() + "\t <Directori>")
        contador++
    }
}