package yeonkyu

fun main() {

    class Solution {
        fun isPalindrome(x: Int): Boolean {
            val str = x.toString()
            val length = str.length
            val mid = length / 2

            for (i in 0..< mid) {
                val start = str[i]
                val end = str[length-1-i]
                if (start != end) {
                    return false
                }
            }

            return true
        }
    }

    val answer = Solution().isPalindrome(121)
    println(answer)
}