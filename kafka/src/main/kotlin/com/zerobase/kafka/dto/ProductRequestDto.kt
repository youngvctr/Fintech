package com.zerobase.kafka.dto

data class ProductRequestDto(
        val organizationCode: String,
        val productCode: String,
        val productName: String,
        val productMinInterest: Double,
        val productMaxInterest: Double
)