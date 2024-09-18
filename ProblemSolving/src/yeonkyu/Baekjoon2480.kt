package yeonkyu

import java.util.Scanner
import kotlin.math.pow

fun main() {
    val diceList = with(Scanner(System.`in`)) {
        listOf(
            nextInt(),
            nextInt(),
            nextInt(),
        )
    }

    solve(diceList)
}

private fun solve(diceList: List<Int>) {
    val countMap = mutableMapOf<Int, Int>()

    diceList.forEach {
        val count = countMap[it]
        if (count == null) {
            countMap[it] = 1
        } else {
            countMap[it] = count + 1
        }
    }

    val diceDataList = countMap.map { (number, count) ->
        Dice(number, count)
    } // ex. Dice(3,2), Dice(6,1)

    val largestDice = diceDataList
        .sortedByDescending { it.number }
        .sortedByDescending { it.count }[0]

    val result = when {
        largestDice.count > 1 -> {
            10f.pow(largestDice.count).toInt() * (10 + largestDice.number)
        }
        else -> {
            largestDice.number * 100
        }
    }

    println(result)
}

data class Dice(
    val number: Int,
    val count: Int = 0,
)