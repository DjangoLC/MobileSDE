package com.example.itijuanatest.core.domain


private val vowels = listOf('a', 'e', 'i', 'o', 'u')

fun String.getVowelsCount(): Int {
    val clearString = this.lowercase().trim()
    return clearString.filter { vowels.contains(it) }.length
}

fun String.getConsonants(): Int {
    val clearString = this.lowercase().trim().toCharArray()
    val result = clearString.distinctBy { vowels.contains(it) }
    return result.count()
}
