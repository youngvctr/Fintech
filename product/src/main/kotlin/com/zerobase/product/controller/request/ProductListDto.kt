package com.zerobase.product.controller.request;

import com.zerobase.domain.domain.ProductList

data class ProductListDto (
        val organizationCode: String,
        val productCode: String,
) {
    fun toEntityList(): ProductList =
            ProductList(
                    organizationCode,
                    productCode
            )
}
