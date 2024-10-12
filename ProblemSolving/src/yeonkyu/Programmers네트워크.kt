package yeonkyu

fun main() {
    class Solution {
        private lateinit var node: Array<Array<Boolean>>
        private lateinit var parent: IntArray
        private var size: Int = 0
        private lateinit var visited: BooleanArray

        fun solution(n: Int, computers: Array<IntArray>): Int {
            node = Array(n) { Array(n) { false } }
            size = n
            parent = IntArray(size)

            for (i in 0 until computers.size) {
                for (j in 0 until computers[0].size) {
                    node[i][j] = computers[i][j] == 1
                }
            }

            for (i in 0 until n) {
                parent[i] = i
            }

            for (i in 0 until n) {
                initParent(i)
            }

            val parentSet = mutableSetOf<Int>()
            for (i in 0 until n) {
                parentSet.add(parent[i])
            }

            return parentSet.size
        }

        private fun initParent(current: Int) {
            visited = BooleanArray(size) { false }
            dfs(current, current)
        }

        private fun dfs(parentNumber: Int, current: Int) {
            visited[current] = true
            if (parent[current] > parentNumber) {
                parent[current] = parentNumber
            }

            for (i in 0 until size) {
                if (current != i && node[current][i] && visited[i].not()) {
                    dfs(parentNumber, i)
                }
            }
        }
    }

    val n = 3
    val computers = arrayOf(
        intArrayOf(1,1,0),
        intArrayOf(1,1,0),
        intArrayOf(0,0,1)
    )
    val answer = Solution().solution(n, computers)
    println(answer)

}