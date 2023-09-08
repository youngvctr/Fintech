package com.zerobase.product.controller.request

import com.zerobase.domain.domain.ProductInfo
import com.zerobase.kafka.dto.ProductRequestDto

data class ProductInfoDto(
        val organizationCode: String,
        val productCode: String,
        val productName: String,
        val productMinInterest: Double,
        val productMaxInterest: Double
) {
    fun toEntity(): ProductInfo =
            ProductInfo(
                    organizationCode,
                    productCode,
                    productName,
                    productMinInterest,
                    productMaxInterest
            )

    fun toProductRequestKafkaDto() = ProductRequestDto(
            organizationCode,
            productCode,
            productName,
            productMinInterest,
            productMaxInterest
    )
}
