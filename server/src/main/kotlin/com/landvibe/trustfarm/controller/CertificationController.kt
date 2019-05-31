package com.landvibe.trustfarm.controller

import com.landvibe.trustfarm.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.view.RedirectView

@Controller
class CertificationController {
    @Autowired
    lateinit var productRepository: ProductRepository

    @GetMapping("/certification/products")
    fun list(): ModelAndView {
        val mav = ModelAndView("certification/list")
        mav.addObject("products", productRepository.findAll())
        return mav
    }

    @GetMapping("/certification/products/{id}")
    fun detail(@PathVariable id: Long): ModelAndView {
        val mav = ModelAndView("certification/detail")
        mav.addObject("product", productRepository.findById(id).get())
        return mav
    }

    @GetMapping("/certification/products/{id}/certify")
    fun certify(@PathVariable id: Long): ModelAndView {
        val mav = ModelAndView("certification/detail")
        val product = productRepository.findById(id).get()
        if (!product.certification.contains("Klaytn")) {
            product.certification = product.certification + ",Klaytn"
            productRepository.save(product)
        }
        return mav
    }
}