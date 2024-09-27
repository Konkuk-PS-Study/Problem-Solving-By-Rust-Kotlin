package yeonkyu

import java.util.*

fun main() {
    val string = with(Scanner(System.`in`)) {
        readLine()
    }!!

    val split = string.split(" ")

    val decrementIfFirstEmpty = if (split.first().isEmpty()) -1 else 0
    val decrementIfLastEmpty = if (split.last().isEmpty()) -1 else 0

    println(split.size + decrementIfFirstEmpty + decrementIfLastEmpty)
}
