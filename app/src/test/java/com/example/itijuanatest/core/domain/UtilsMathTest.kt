package com.example.itijuanatest.core.domain

import org.junit.Assert.*

import org.junit.Test

class UtilsMathTest {

    private val math: UtilsMath = UtilsMath()

    @Test
    fun commonsFactorOf() {
        val result = math.commonsFactorOf(24)
        val commonsFactorOf24 = listOf(1, 2, 3, 4, 6, 8, 12, 24)
        assertArrayEquals(commonsFactorOf24.toTypedArray(),result.toTypedArray())
    }
}