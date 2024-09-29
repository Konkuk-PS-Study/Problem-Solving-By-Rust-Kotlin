package BJ

// https://www.acmicpc.net/problem/1152

fun main() {
    val ans = readln()
        .trim() // 좌우 공백 제거
        .split(" ") // 단어 단위로 쪼개기 : Empty String도 하나의 요소로 취급되므로 주의
        .filter { it.isNotEmpty() } // Empty String은 제외
        .size
    print(ans)
}