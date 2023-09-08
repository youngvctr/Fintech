package com.zerobase.product.controller.request

import com.zerobase.domain.domain.ProductInfo
import com.zerobase.domain.domain.ProductList


interface ProductRequestService {
    fun productRequestMain(
            productInfo:ProductInfoDto
    ): ProductRequestDto.ProductRequestResponseDto

    fun saveProductInfo(
            productInfo: ProductInfoDto
    ): ProductInfo

    fun saveProductList(
            productList: ProductListDto
    ): ProductList

    fun productRequestReview(productInfoDto: ProductInfoDto)
}