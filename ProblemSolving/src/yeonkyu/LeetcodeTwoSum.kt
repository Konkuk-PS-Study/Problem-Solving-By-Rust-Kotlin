package yeonkyu

class LeetcodeTwoSum {
}
fun main() {
    val result = Solution().twoSum(
        nums = intArrayOf(2, 7, 11, 15),
        target = 9
    )
    result.forEach {
        println(it)
    }
}

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in 0..< nums.size - 1) {
            for (j in i + 1..< nums.size) {
                val a = nums[i]
                val b = nums[j]

                if (a + b == target) {
                    return intArrayOf(i, j)
                }
            }
        }

        return listOf(0, 0).toIntArray()
    }
}