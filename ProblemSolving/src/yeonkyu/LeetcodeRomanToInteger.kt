package yeonkyu

fun main() {
    class Solution {
        fun romanToInt(s: String): Int {
            val size = s.length
            var total = 0
            var i = 0
            while (i < size) {
                val currentValue = s[i].convertToInt()
                if (i == size-1) {
                    total += currentValue
                    break
                }

                val nextValue = s[i+1].convertToInt()

                if (currentValue < nextValue) {
                    total -= currentValue
                } else {
                    total += currentValue
                }
                i++
            }

            return total
        }

        private fun Char.convertToInt(): Int {
            return when (this) {
                'I' -> 1
                'V' -> 5
                'X' -> 10
                'L' -> 50
                'C' -> 100
                'D' -> 500
                'M' -> 1000
                else -> throw Exception("no such char")
            }
        }
    }

    val answer = Solution().romanToInt("MCMXCIV")
    println(answer)

}