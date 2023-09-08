package com.zerobase.product.controller.response

import com.zerobase.domain.domain.ProductInfo
import com.zerobase.domain.repository.ProductInfoRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class ProductReviewServiceImpl(
        private val productInfoRepository: ProductInfoRepository
) : ProductReviewService {
    override fun productReviewMain(
            organizationCode: String
    ): ProductReviewDto.ProductReviewResponseDto {
        return ProductReviewDto.ProductReviewResponseDto(
                organizationCode = organizationCode,
                productResult = getProductResult(organizationCode)?.toResponseDto()
                        ?: throw RuntimeException("RESULT_NOT_FOUND")
        )
    }

    @Cacheable(value = ["REVIEW"], key = "#organizationCode", cacheManager = "redisCacheManager")
    override fun getProductResult(organizationCode: String) =
            productInfoRepository.findByOrganizationCode(organizationCode)

    private fun ProductInfo.toResponseDto() =
            ProductReviewDto.ProductResult(
                    productCode = this.productCode,
                    productName = this.productName,
                    productMinimumInterest = this.productMinInterest,
                    productMaximumInterest = this.productMaxInterest
            )
}