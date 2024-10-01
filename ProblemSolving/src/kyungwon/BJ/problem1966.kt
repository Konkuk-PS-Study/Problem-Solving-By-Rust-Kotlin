package BJ

// https://www.acmicpc.net/problem/1966

import java.util.LinkedList
import java.util.Queue

data class Tuple(val index: Int, val priority: Int)

fun main() {
    val n = readln().toInt()
    repeat(n) {
        val (quantity, targetIndex) = readln().split(" ").map { it.toInt() }
        val priorityList = readln().split(" ").map { it.toInt() }
        val queue: Queue<Tuple> = LinkedList()
        for (i in 0 until quantity) {
            queue.add(Tuple(i, priorityList[i]))
        }
        var cnt = 0
        while (queue.isNotEmpty()) {
            val out = queue.poll()
            if (queue.any { it.priority > out.priority }) {
                queue.add(out)
            } else {
                cnt++
                if (targetIndex == out.index) {
                    println(cnt)
                    break
                }
            }
        }
    }
}