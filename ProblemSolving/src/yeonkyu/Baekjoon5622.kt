package yeonkyu

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val num = next()

    val count = num.sumOf { getCharacterCount(it) }

    println(count)
}

private fun getCharacterCount(char: Char): Int {
    return when (char) {
        in 'A'..'C' -> 3
        in 'D' .. 'F' -> 4
        in 'G'..'I' -> 5
        in 'J'..'L' -> 6
        in 'M'..'O' -> 7
        in 'P'..'S' -> 8
        in 'T'..'V' -> 9
        in 'W'..'Z' -> 10
        else -> 0
    }
}