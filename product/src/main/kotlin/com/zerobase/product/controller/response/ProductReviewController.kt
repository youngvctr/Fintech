package com.zerobase.product.controller.response

import com.zerobase.product.enum.Code
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

//http://localhost:8090/swagger-ui/index.html
@RestController
@RequestMapping("/fintech/vi")
class ProductReviewController(
    private val productReviewService: ProductReviewService
) {
    @GetMapping("product/{organizationCode}")
    fun getReviewData(
            @RequestParam organizationCode: Code
    ): ResponseEntity<ProductReviewDto.ProductReviewResponseDto> {
        return ResponseEntity.ok(
                productReviewService.productReviewMain(organizationCode.orgName)
        )
    }
}