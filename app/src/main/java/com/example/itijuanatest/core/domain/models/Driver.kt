package com.example.itijuanatest.core.domain.models

import com.example.itijuanatest.core.domain.getConsonants
import com.example.itijuanatest.core.domain.getVowelsCount

data class Driver(
    val id: Long,
    val name: String,
    var isAvailable: Boolean = true
) {
    private fun vowelScore() = name.getVowelsCount() * 1.5
    private fun consonantScore() = name.getConsonants() * 1.0
    fun getMaxScore(isEven: Boolean): Double {
        return if (isEven) vowelScore() else consonantScore()
    }
}