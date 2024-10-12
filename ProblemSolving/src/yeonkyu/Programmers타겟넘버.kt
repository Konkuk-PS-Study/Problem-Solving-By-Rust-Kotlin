package yeonkyu

fun main() {
    class Solution {
        private lateinit var numbers: IntArray
        private var target: Int = 0

        fun solution(numbers: IntArray, target: Int): Int {
            this.numbers = numbers
            this.target = target

            val answer = getTotalCountByDfs(0, 0)
            return answer
        }

        private fun getTotalCountByDfs(index: Int, currentSum: Int): Int {
            if (index == numbers.size) {
                return if (currentSum == target) 1 else 0
            }

            val plusCase = getTotalCountByDfs(index + 1, currentSum + numbers[index])
            val minusCase = getTotalCountByDfs(index + 1, currentSum - numbers[index])
            return plusCase + minusCase
        }
    }

    val answer = Solution().solution(intArrayOf(1,1,1,1,1), 3)
    println(answer)
}