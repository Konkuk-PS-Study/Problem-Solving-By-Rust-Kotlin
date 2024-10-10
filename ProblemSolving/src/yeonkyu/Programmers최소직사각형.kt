package yeonkyu

fun main() {
    class Solution {
        fun solution(sizes: Array<IntArray>): Int {
            val max = sizes.flatMap { it.toList() }
                .maxOrNull()!!

            var secondMax = 0
            for (size in sizes) {
                secondMax = maxOf(size.minOrNull()!!, secondMax)
            }

            return max * secondMax
        }
    }

    val input = arrayOf(
        intArrayOf(60, 50),
        intArrayOf(30, 70),
        intArrayOf(60, 30),
        intArrayOf(80, 40)
    )
    val answer = Solution().solution(input)
    println(answer)
}