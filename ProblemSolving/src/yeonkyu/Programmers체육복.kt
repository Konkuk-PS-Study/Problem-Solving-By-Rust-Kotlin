package yeonkyu

fun main() {
    class Solution {
        fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
            val visit = IntArray(n) { 0 }
            lost.forEach {
                visit[it - 1] -= 1
            }
            reserve.forEach {
                visit[it - 1] += 1
            }

            for (i in 0 until n) {
                if (visit[i] == -1) {
                    if (i-1 >= 0 && visit[i-1] == 1) { // 왼쪽 먼저 보기
                        visit[i] += 1
                        visit[i-1] -= 1
                    } else if (i+1 < n && visit[i+1] == 1) { // 오른쪽 보기
                        visit[i] += 1
                        visit[i+1] -= 1
                    }
                }
            }

            return visit.count { it >= 0 }
        }
    }

    val n = 3
    val lost = intArrayOf(3)
    val reserve = intArrayOf(1)

    val answer = Solution().solution(n, lost, reserve)
    println(answer)

}