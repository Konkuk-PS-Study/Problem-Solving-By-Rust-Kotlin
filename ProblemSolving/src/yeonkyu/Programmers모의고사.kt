package yeonkyu

fun main() {
    class Solution {
        val patterns = listOf(
            listOf(1, 2, 3, 4, 5),
            listOf(2, 1, 2, 3, 2, 4, 2, 5),
            listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        )

        fun solution(answers: IntArray): IntArray {
            val counts = patterns.map { pattern ->
                getCount(answers, pattern)
            }

            val max = counts.maxOrNull()!!
            val answer = counts.mapIndexedNotNull { index, value ->
                if (max == value) {
                    index + 1
                } else {
                    null
                }
            }

            return answer.toIntArray()
        }

        private fun getCount(answers: IntArray, pattern: List<Int>): Int {
            var count = 0
            answers.forEachIndexed { index, value ->
                val pick = pattern[index % (pattern.size)]
                count += if (pick == value) 1 else 0
            }
            return count
        }
    }

    val answer = Solution().solution(intArrayOf(1,2,3,4,5))
    println(answer.toList())
}