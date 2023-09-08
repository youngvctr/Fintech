package com.zerobase.product

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.zerobase"])
@EntityScan(basePackages = ["com.zerobase.domain"])
class ProductApplication

fun main(args: Array<String>) {
    runApplication<ProductApplication>(*args)
}