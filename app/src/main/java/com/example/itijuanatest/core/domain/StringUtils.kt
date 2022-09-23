package com.example.itijuanatest.core.domain

class StringUtils {

    private val vowels = arrayOf('a','e','i', 'o', 'u')

    fun getVowelsCount(str: String): Int{
        val clearString = str.lowercase().trim()
        return clearString.filter { vowels.contains(it) }.length
    }

    fun getConsonants() {

    }

}