package com.landvibe.trustfarm.repository

import com.landvibe.trustfarm.model.Company
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "company", path = "company")
interface CompanyRepository : JpaRepository<Company, Long>