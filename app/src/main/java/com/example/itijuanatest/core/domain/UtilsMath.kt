package com.example.itijuanatest.core.domain


fun Int.isEven() = (this % 2) == 0

fun String.commonsFactorOf(): List<Int> {
    val allCommons = mutableListOf<Int>()
    for (i in 1..length) {
        for (j in length downTo 1) {
            if (i * j == length) {
                allCommons.add(i)
            }
        }
    }
    return allCommons
}