package BJ

// https://www.acmicpc.net/problem/30802

fun main() {
    val n = readln().toInt()
    val registeredCounts = readln().split(" ").map { it.toInt() }
    val (t, p) = readln().split(" ").map { it.toInt() }
    println(registeredCounts.sumOf { count -> if (count != 0) (count - 1) / t + 1 else 0 })
    println("${n / p} ${n % p}")
}