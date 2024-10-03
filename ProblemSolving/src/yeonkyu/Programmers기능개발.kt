package yeonkyu

import kotlin.math.ceil

fun main() {
    class Solution {
        fun solution(progresses: IntArray, speeds: IntArray): IntArray {

            val timeToFinish = MutableList(progresses.size) { 0 }

            for (i in progresses.indices) {
                val progress = progresses[i]
                val speed = speeds[i]
                timeToFinish[i] = ceil((100 - progress) / speed.toDouble()).toInt()
            }

            val answer = mutableListOf<Int>()

            var index = 0
            while (index < timeToFinish.size) {
                val lastIndex = findFirstBiggerIndex(index, timeToFinish)
                answer.add(lastIndex - index)
                index = lastIndex
            }

            return answer.toIntArray()
        }

        private fun findFirstBiggerIndex(index: Int, timeToFinish: List<Int>): Int {
            val time = timeToFinish[index]
            var cur = index
            while (cur < timeToFinish.size) {
                if (time >= timeToFinish[cur]) {
                    cur++
                } else {
                    break
                }
            }
            return cur
        }
    }

    val progresses = intArrayOf(95, 90, 99, 99, 80, 99)
    val speeds = intArrayOf(1, 1, 1, 1, 1, 1)
    val ans = Solution().solution(progresses, speeds)
    println(ans.toList().toString())
}