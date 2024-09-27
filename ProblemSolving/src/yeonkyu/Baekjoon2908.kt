package yeonkyu

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val inputA = next()
    val inputB = next()

    val a = inputA.getReversedString().toInt()
    val b = inputB.getReversedString().toInt()

    println(maxOf(a, b))
}

private fun String.getReversedString(): String {
    val builder = StringBuilder()
    for (i in this.length - 1 downTo 0) {
        builder.append(this[i])
    }
    return builder.toString()
}