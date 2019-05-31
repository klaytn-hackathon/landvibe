package com.landvibe.trustfarm

import com.landvibe.trustfarm.model.Company
import com.landvibe.trustfarm.model.Product
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.stereotype.Component
import org.springframework.web.filter.CharacterEncodingFilter
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.http.converter.HttpMessageConverter
import java.nio.charset.Charset
import javax.servlet.Filter


@SpringBootApplication
class TrustFarmApplication

fun main(args: Array<String>) {
    runApplication<TrustFarmApplication>(*args)
}

@Component
class ExposeEntityIdRestMvcConfiguration : RepositoryRestConfigurer {
    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration?) {
        config?.let {
            it.exposeIdsFor(Product::class.java)
            it.exposeIdsFor(Company::class.java)
        }
    }
}