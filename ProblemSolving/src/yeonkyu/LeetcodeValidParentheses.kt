package yeonkyu

fun main() {
    class Solution {
        fun isValid(s: String): Boolean {
            val stack = mutableListOf<Char>()

            val matchingPairs = mapOf(
                ')' to '(',
                '}' to '{',
                ']' to '['
            )

            s.forEach { char ->
                when (char) {
                    '(', '{', '[' -> {
                        stack.add(char)
                    }
                    ')', '}', ']' -> {
                        if (stack.isEmpty()) {
                            return false
                        }
                        if (stack.removeLast() != matchingPairs[char]) {
                            return false
                        }
                    }
                }
            }

            return stack.isEmpty()
        }
    }

    val inputs = "()[]{}"
    val answer = Solution().isValid(inputs)
    println("answer : $answer")

    val inputs2 = "(]"
    val answer2 = Solution().isValid(inputs2)
    println("answer2 : $answer2")

    val inputs3 = "([])"
    val answer3 = Solution().isValid(inputs3)
    println("answer3 : $answer3")
}