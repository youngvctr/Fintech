package com.zerobase.product.controller.request

import com.zerobase.domain.repository.ProductInfoRepository
import com.zerobase.domain.repository.ProductListRepository
import com.zerobase.kafka.enum.KafkaTopic
import com.zerobase.kafka.producer.ProductRequestSender
import org.springframework.stereotype.Service

@Service
class ProductRequestServiceImpl(
        private val productRequestSender: ProductRequestSender,
        private val productInfoRepository: ProductInfoRepository,
        private val productListRepository: ProductListRepository
) : ProductRequestService {

    override fun productRequestMain(
            productInfo: ProductInfoDto
    ): ProductRequestDto.ProductRequestResponseDto {
        val check = productListRepository.findByOrganizationCode(productInfo.organizationCode)
        if(!check.isEmpty) {
            throw RuntimeException("DUPLICATED")
        }

        val resultProdInfo = saveProductInfo(productInfo)
        val resultProdList = saveProductList(ProductListDto(productInfo.organizationCode, productInfo.productCode))
        if(resultProdInfo.equals(null) || resultProdList.equals(null)) throw RuntimeException("INTERNAL_SERVER_ERROR")

        productRequestReview(productInfo)

        return ProductRequestDto.ProductRequestResponseDto(productInfo.organizationCode, resultProdInfo.productCode,
                resultProdInfo.productMinInterest, resultProdInfo.productMaxInterest, resultProdInfo.productName).responseDto()
    }

    override fun saveProductInfo(productInfo: ProductInfoDto) =
            productInfoRepository.save(productInfo.toEntity())

    override fun saveProductList(productList: ProductListDto) =
            productListRepository.save(productList.toEntityList())

    override fun productRequestReview(productInfoDto: ProductInfoDto) {
        productRequestSender.sendMessage(
                KafkaTopic.PRODUCT_REQUEST,
                productInfoDto.toProductRequestKafkaDto()
        )
    }
}