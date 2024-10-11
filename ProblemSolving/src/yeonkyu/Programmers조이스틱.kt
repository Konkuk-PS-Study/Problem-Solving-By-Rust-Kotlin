package yeonkyu

fun main() {
    class Solution {
        fun solution(name: String): Int {
            var answer1 = 0

            for (char in name) {
                if (char != 'A') {
                    answer1 += getUpAndDownCount(char)
                }
            }

            val answer2 = getLeftOrRightCount(name)

            return answer1 + answer2
        }

        private fun getUpAndDownCount(char: Char): Int {
            val fromA = char - 'A'
            val fromZ = 'Z' - char
            return minOf(fromA, fromZ + 1)
        }

        private fun getLeftOrRightCount(name: String): Int {
            val list = name.toList().map { it != 'A' }
            var minDistance = list.size - 1

            val size = list.size
            for (i in 0 until size) {
                val nextIndex = getNextIndex(list, i)

                val distanceFromBack = if (nextIndex == null) {
                    0 // 갈필요가 없음
                } else {
                    size - nextIndex
                }
                val distance1 = 2 * i + distanceFromBack //i 만큼 앞으로 갔다가 빽한 경우
                val distance2 = list.lastIndexOf(true).takeIf { it >= 0 } ?: 0 // 걍 앞으로만 간경우

                val distanceFromFromFront = list.subList(0, i).lastIndexOf(true).takeIf { it >= 0 } ?: 0
                val distance3 = 2 * (size - i) + distanceFromFromFront // i 만큼 뒤로 갔다가 앞으로 간 경우
                val dist = minOf(distance1, distance2, distance3)

                if (dist < minDistance) {
                    minDistance = dist
                }
            }
            return minDistance
        }

        private fun getNextIndex(list: List<Boolean>, cur: Int): Int? {
            for (i in cur + 1 until list.size) {
                if (list[i] == true) {
                    return i
                }
            }
            return null
        }
    }

    val name = "BAABBAAA"
    val answer = Solution().solution(name)
    println(answer)
}