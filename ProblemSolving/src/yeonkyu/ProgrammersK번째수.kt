package yeonkyu

fun main () {
    class Solution {
        fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
            val answer = mutableListOf<Int>()
            for (command in commands) {
                answer.add(getPieceAnswer(array.toMutableList(), command))
            }
            return answer.toIntArray()
        }

        private fun getPieceAnswer(list: MutableList<Int>, command: IntArray): Int {
            val notSortedArray = list.subList(command[0]-1, command[1])
            val sortedArray = notSortedArray.sortedBy { it }
            return sortedArray[command[2]-1]
        }
    }

    val ans = Solution().solution(intArrayOf(1,5,2,6,3,7,4), arrayOf(intArrayOf(2,5,3), intArrayOf(4,4,1), intArrayOf(1,7,3)))
    println(ans.toList())

}