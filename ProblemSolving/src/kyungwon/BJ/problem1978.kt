package BJ

// https://www.acmicpc.net/problem/1978

fun main() {
    readln().toInt()
    println(readln().split(" ").map { it.toInt() }.count { dividend ->
        if (dividend == 1) return@count false
        (2 until dividend).none { divisor -> dividend % divisor == 0 }
    })
}