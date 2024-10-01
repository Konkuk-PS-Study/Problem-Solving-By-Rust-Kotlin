package yeonkyu

private const val initialValue = -1
private const val alphabetSize = 'z' - 'a' + 1
private val visited = MutableList(alphabetSize) { initialValue }

fun main() {
    val str = readln()

    str.forEachIndexed { index, char ->
        val hasVisited = visited[char - 'a'] != initialValue
        if (hasVisited.not()) {
            visited[char - 'a'] = index
        }
    }

    println(visited.joinToString(separator = " "))
}