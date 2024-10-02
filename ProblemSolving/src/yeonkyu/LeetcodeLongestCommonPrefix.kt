package yeonkyu

fun main() {
    class Solution {
        fun longestCommonPrefix(strs: Array<String>): String {
            var lastCommonIndex = -1

            val minLength = strs.minOf { it.length }
            for (idx in 0..< minLength) {
                var stop = false

                val char = strs[0][idx]
                for (i in 1..< strs.size) {
                    if (strs[i][idx] == char) {
                        // 통과
                    } else {
                        stop = true
                        break
                    }
                }

                if (stop) {
                    break
                } else {
                    lastCommonIndex = idx
                }
            }

            return if (lastCommonIndex == -1) {
                ""
            } else {
                strs[0].substring(0, lastCommonIndex + 1)
            }
        }
    }

    val inputs = arrayOf("flower","flow","flight")
    val answer = Solution().longestCommonPrefix(inputs)
    println("answer : $answer")
}