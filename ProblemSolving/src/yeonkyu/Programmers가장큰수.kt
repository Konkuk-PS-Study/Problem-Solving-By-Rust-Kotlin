package yeonkyu

fun main() {
    class Solution {
        fun solution(numbers: IntArray): String {
            val numberList = numbers.toList().map {
                it.toString()
            }

            val sortedList = numberList.sortedWith { a, b -> // 6 > 61
                val first = (a + b).toInt() // 661
                val second = (b + a).toInt() // 616
                - (first - second) // 내림차순
            }

            val ans = StringBuilder()

            sortedList.forEach {
                ans.append(it)
            }
            val answer = ans.toString()

            return if (answer.startsWith("0")) "0" else answer
        }
    }

    val answer = Solution().solution(intArrayOf(6, 10, 2))
    println(answer)
}