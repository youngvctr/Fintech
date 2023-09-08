package com.zerobase.product.controller.response

import com.zerobase.domain.domain.ProductInfo

interface ProductReviewService {
    fun productReviewMain(organizationCode: String): ProductReviewDto.ProductReviewResponseDto?

    fun getProductResult(orgCode: String) : ProductInfo?
}