package yeonkyu

fun main() {
    val t = readln().toInt()

    repeat(t) {
        val str = readln()
        val answer = str.first().toString() + str.last().toString()
        println(answer)
    }
}