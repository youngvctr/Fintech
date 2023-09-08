package com.zerobase.product.controller.response

class ProductReviewDto {
    data class ProductReviewResponseDto(
            val organizationCode: String,
            val productResult: ProductResult
    )

    data class ProductResult(
            val productCode: String,
            val productMaximumInterest: Double,
            val productMinimumInterest: Double,
            val productName: String
    )
}