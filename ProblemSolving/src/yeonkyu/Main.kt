package yeonkyu

fun main() {
    // 배열 생성
    println("---배열 생성---")
    // 100개짜리 배열 생성. default value는 0
    val a1 = IntArray(100)
    println(a1[99])
    // 100개짜리 배열 생성 후 1로 초기화
    val a2 = IntArray(100) { 1 }
    println(a2[99])


    // 2차원 배열 생성
    // 100 * 100 배열 생성
    val b1 = Array(100) { IntArray(100) }
    println(b1[99][99])
    // 100 * 100 배열 생성 후 2로 초기화
    val b2 = Array(100) { IntArray(100) { 2 } }
    println(b2[99][99])

    println("---정렬---")
    // 숫자의 정렬
    val list = listOf(3, 5, 4)
    println("심플하게 쓰기" + list.sorted())

    // sortedWith() 와 sortWith()의 차이 : sortedWith()는 immutable list에 사용, sortWith()는 mutable list에 사용
    // sortedBy(), sortBy()도 마찬가지.
    // 그냥 심플하게 immutable만 쓰는 ~ed() 패턴으로 가자

    // sortedWith() 와 sortedBy() 차이 : 정렬 기준이 1개면 sortedBy, 정렬 기준이 2개 이상이면 sortedWith
    println("sortedBy " + list.sortedBy { it })

    val list2 = listOf(Pair(3, 5), Pair(3, 4))
    val comparator2 = compareBy<Pair<Int, Int>> { // 앞에거 first 로 먼저 정렬 후, 같은건 second 로 역순으로 비교
        it.first
    }.thenByDescending {
        it.second
    }
    println("sortedWith" + list2.sortedWith(comparator2))

    val list3 = listOf(Pair("A", 4), Pair("A", 5))
    val sortedList3 = list3.sortedWith { a, b ->
        if (a.first > b.first) {
            return@sortedWith a.first.compareTo(b.first)
        } else {
            return@sortedWith a.second.compareTo(b.second) // - 붙이면 역순 가능
        }
    }
    println("sortedWith 방법 2" + sortedList3) // 기본적으로 sortedWith 상위호환이라 다 커버 가능하네

}