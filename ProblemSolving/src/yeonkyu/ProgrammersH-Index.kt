package yeonkyu

fun main() {
    class Solution {
        fun solution(citations: IntArray): Int {
            var answer = 0
            for (hCandidate in citations.maxOrNull()!! downTo  0) {
                val canBeH = isH(citations.toList(), hCandidate)
                if (canBeH) {
                    answer = hCandidate
                    break
                }
            }

            return answer
        }

        private fun isH(citations: List<Int>, h: Int): Boolean {
            val citedCount = citations.count { it >= h }
            val unCitedCount =  citations.size - citedCount

            val condition1 = citedCount >= h
            val condition2 = unCitedCount <= h
            return condition1 && condition2
        }
    }

    val ans = Solution().solution(intArrayOf(3, 0, 6, 1, 5))
    println(ans)
}