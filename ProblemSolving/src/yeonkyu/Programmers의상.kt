package yeonkyu

fun main() {
    class Solution {
        fun solution(clothes: Array<Array<String>>): Int {
            val map = mutableMapOf<String, Int>()
            clothes.forEach { cloth ->
                val category = cloth[1]
                map[category] = map.getOrDefault(category, 0) + 1
            }

            val ans = map.values.fold(1) { accumulator, value ->
                accumulator * (value + 1)
            } - 1

            return ans
        }
    }

    val answer = Solution().solution(
        arrayOf(
            arrayOf("yellow_hat", "headgear"),
            arrayOf("blue_sunglasses", "eyewear"),
            arrayOf("green_turban", "headgear")
        )
    )

    println(answer)
}