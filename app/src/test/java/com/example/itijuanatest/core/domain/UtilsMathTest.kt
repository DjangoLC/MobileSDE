package com.example.itijuanatest.core.domain

import org.junit.Assert.*

import org.junit.Test

class UtilsMathTest {


    @Test
    fun commonsFactorOf26() {
        val result = "63187 Volkman Garden Suite 447".trimAll().commonsFactorOf()
        val commonsFactorOf24 = listOf(1, 2,13,26)
        assertArrayEquals(commonsFactorOf24.toTypedArray(),result.toTypedArray())
    }

    @Test
    fun commonsFactorOf24() {
        val result = "63187 Volkman Garden Suite7".trimAll().commonsFactorOf()
        val commonsFactorOf24 = listOf(1, 2, 3, 4, 6, 8, 12, 24)
        assertArrayEquals(commonsFactorOf24.toTypedArray(),result.toTypedArray())
    }

    @Test
    fun get4Vowels() {
        val result = "womeningo".getVowelsCount()
        assertEquals(4,result)
    }

    @Test
    fun get4Consonants() {
        val result = "womenino".getConsonants()
        assertEquals(4,result)
    }
}