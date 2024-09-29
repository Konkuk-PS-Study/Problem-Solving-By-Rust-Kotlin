package BJ

// https://www.acmicpc.net/problem/11650

data class Dot(val x: Int, val y: Int)

fun main() {
    val n = readln().toInt()
    val list = mutableListOf<Dot>()
    repeat(n) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        list.add(Dot(x, y))
    }
    list.sortWith(compareBy<Dot> { it.x }.thenBy { it.y })
    list.forEach { println("${it.x} ${it.y}") }
}

