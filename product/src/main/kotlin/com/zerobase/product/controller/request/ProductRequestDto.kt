package com.zerobase.product.controller.request

class ProductRequestDto {
    data class ProductRequestResponseDto(
            val organizationCode: String,
            val productCode: String,
            val productMinInterest: Double,
            val productMaxInterest: Double,
            val productName: String
    ){
        fun responseDto() : ProductRequestResponseDto = (
                ProductRequestResponseDto(
                        organizationCode,
                        productCode,
                        productMinInterest,
                        productMaxInterest,
                        productName
                )
        )
    }
}