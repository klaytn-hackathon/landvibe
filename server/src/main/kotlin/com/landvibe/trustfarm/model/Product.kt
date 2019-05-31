package com.landvibe.trustfarm.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Product(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long,
        val companyId: Long,
        val name: String,
        val price: Int,
        var certification: String
)