package BJ

// https://www.acmicpc.net/problem/10814

data class Member(val age: Int, val name: String)

fun main() {
    val n = readln().toInt()
    val list = mutableListOf<Member>()
    for (i in 0 until n) {
        val (age, name) = readln().split(" ")
        list.add(Member(age.toInt(), name))
    }
    list.sortedBy { it.age }.forEach {
        println("${it.age} ${it.name}")
    }
}