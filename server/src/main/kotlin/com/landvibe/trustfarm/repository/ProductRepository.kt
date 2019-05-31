package com.landvibe.trustfarm.repository

import com.landvibe.trustfarm.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "product", path = "product")
interface ProductRepository : JpaRepository<Product, Long> {
    fun findAllByCompanyId(@Param("companyId") companyId: Long): List<Product>
}