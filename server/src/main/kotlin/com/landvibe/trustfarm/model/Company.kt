package com.landvibe.trustfarm.model

import javax.persistence.*

@Entity
data class Company(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long,
        val name: String
)