package BJ

// https://www.acmicpc.net/problem/1181
fun main() {
    val set = mutableSetOf<String>()
    repeat(readln().toInt()) {
        set.add(readln()) // Set에 저장함으로써 중복 제거
    }

    // 길이 순으로 정렬하되, 길이가 같으면 사전 순으로 정렬
    set.sortedWith(compareBy({ it.length }, { it })).forEach(::println)
}