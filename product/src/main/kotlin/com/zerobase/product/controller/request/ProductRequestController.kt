package com.zerobase.product.controller.request

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

//http://localhost:8090/swagger-ui/index.html
@RestController
@RequestMapping("/fintech/vi")
class ProductRequestController(
        private val productRequestService: ProductRequestService
) {
    @PostMapping("/product/information")
    fun productRequest(
            @RequestBody productInfo: ProductInfoDto
    ): ResponseEntity<ProductRequestDto.ProductRequestResponseDto?> {
        return ResponseEntity.status(HttpStatus.OK).body(productRequestService.productRequestMain(productInfo))
    }
}