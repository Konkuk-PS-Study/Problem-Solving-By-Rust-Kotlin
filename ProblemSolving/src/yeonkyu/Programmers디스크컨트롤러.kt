package yeonkyu

import java.util.PriorityQueue

fun main() {
    class Solution {
        fun solution(jobs: Array<IntArray>): Int {

            val sortedJobs = jobs.sortedBy { it[0] }.toMutableList()
            val endTimes = jobs.map { 0 }.toMutableList()

            val size = sortedJobs.size

            var currentTime = 0

            for (i in 0 until size) {
                // 현재 시간 업데이트
                if (currentTime < sortedJobs[i][0]) {
                    currentTime = sortedJobs[i][0]
                }

                // 현재 시간에 작업이 가능한 리스트 추출
                val startableJobs = mutableListOf<Pair<Int, Int>>() // Pair(index, time)
                for (j in i until size) {
                    if (sortedJobs[j][0] <= currentTime) {
                        startableJobs.add(Pair(j, sortedJobs[j][1]))
                    } else {
                        break
                    }
                }
                // time이 가장 작은걸 찾아야함
                var minIndex = i
                var minValue = sortedJobs[i][1]
                for (j in i until i + startableJobs.size) {
                    if (minValue > sortedJobs[j][1]) {
                        minIndex = j
                        minValue = sortedJobs[j][1]
                    }
                }

                // time 가장 작은게 맨앞으로 오도록 swap
                val temp = sortedJobs[i]
                sortedJobs[i] = sortedJobs[minIndex]
                sortedJobs[minIndex] = temp

                // 작업을 수행한 후 마친 시간을 기록한다.
                currentTime += sortedJobs[i][1]
                endTimes[i] = currentTime
            }

            val workTimes = endTimes.mapIndexed { index, endTime ->
                endTime - sortedJobs[index][0]
            }

            return (workTimes.sum() / size)
        }
    }

    val jobs = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(2, 3),
        intArrayOf(2, 2)
    )
    val answer = Solution().solution(jobs)
    println(answer)
}