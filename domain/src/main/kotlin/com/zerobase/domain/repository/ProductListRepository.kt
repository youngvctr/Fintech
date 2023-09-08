package com.zerobase.domain.repository

import com.zerobase.domain.domain.ProductList
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProductListRepository : JpaRepository<ProductList, Long> {
    fun findByOrganizationCode(organizationCode: String): Optional<ProductList>
}
