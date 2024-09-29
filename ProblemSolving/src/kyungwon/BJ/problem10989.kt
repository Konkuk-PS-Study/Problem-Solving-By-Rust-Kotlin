package BJ

// https://www.acmicpc.net/problem/10989

fun main() {
    val n = readln().toInt() // (1 ≤ n ≤ 10,000,000)
    val size = 10_000_000
    val arr = IntArray(size + 1)
    repeat(n) {
        arr[readln().toInt()]++
    }

    val sb = StringBuilder()
    for (i in 1..size) {
        repeat(arr[i]) {
            sb.append(i).append('\n')
        }
    }
    print(sb.toString())
}