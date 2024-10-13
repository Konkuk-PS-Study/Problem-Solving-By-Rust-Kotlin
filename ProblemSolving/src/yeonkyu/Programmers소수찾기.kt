package yeonkyu

import kotlin.math.sqrt

fun main() {
    class Solution {
        private val possibleNumbers = mutableSetOf<Int>()

        fun solution(numbers: String): Int {
            generatePermutations("", numbers)
            return possibleNumbers.count { isPrime(it) }
        }

        private fun generatePermutations(current: String, remaining: String) {
            if (current.isNotEmpty()) {
                possibleNumbers.add(current.toInt())
            }
            for (i in remaining.indices) {
                generatePermutations(
                    current + remaining[i],
                    remaining.removeRange(i, i + 1)
                )
            }

            remaining.forEachIndexed { index, char ->
                generatePermutations(
                    current = current + char,
                    remaining = remaining.removeRange(index, index + 1)
                )
            }
        }

        private fun isPrime(num: Int): Boolean {
            if (num < 2) return false
            for (i in 2..sqrt(num.toDouble()).toInt()) {
                if (num % i == 0) return false
            }
            return true
        }
    }

    val solution = Solution()
    val numbers = "011"
    println(solution.solution(numbers))
}