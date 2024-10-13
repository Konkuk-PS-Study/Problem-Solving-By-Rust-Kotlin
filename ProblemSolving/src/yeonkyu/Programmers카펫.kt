package yeonkyu

import kotlin.math.sqrt

fun main() {
    class Solution {
        fun solution(brown: Int, yellow: Int): IntArray {
            val pairs = mutableListOf<Pair<Int, Int>>()

            val total = brown + yellow
            for (i in 3 .. sqrt(total.toDouble()).toInt()) {
                if (total % i == 0) {
                    pairs.add(Pair((total.toDouble() / i).toInt(), i))
                }
            }

            var answer = intArrayOf()

            pairs.forEach {
                val a = it.first // 긴줄 크기
                val b = it.second // 짧은줄 크기

                val yellowCount = (a-2) * (b-2)
                if (yellowCount == yellow) {
                    answer = intArrayOf(a, b)
                    return@forEach
                }
            }

            return answer
        }
    }

    val ans = Solution().solution(brown = 24, yellow = 24)
    println(ans.toList())
}