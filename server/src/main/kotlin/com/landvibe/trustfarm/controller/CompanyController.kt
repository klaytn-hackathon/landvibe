package com.landvibe.trustfarm.controller

import com.landvibe.trustfarm.model.Company
import com.landvibe.trustfarm.model.Product
import com.landvibe.trustfarm.repository.CompanyRepository
import com.landvibe.trustfarm.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.view.RedirectView
import java.io.File
import java.util.*

@Controller
class CompanyController {
    @Autowired
    lateinit var productRepository: ProductRepository
    @Autowired
    lateinit var companyRepository: CompanyRepository

    @GetMapping("/companies")
    fun list(): ModelAndView {
        val mav = ModelAndView("company/list")
        mav.addObject("companies", companyRepository.findAll())
        return mav
    }

    @GetMapping("/companies/{id}")
    fun detail(@PathVariable id: Long): ModelAndView {
        val mav = ModelAndView("company/detail")
        mav.addObject("company", companyRepository.findById(id).get())
        mav.addObject("products", productRepository.findAllByCompanyId(id))
        return mav
    }

    @GetMapping("/companies/{id}/products/create")
    fun createForm(@PathVariable id: Long): ModelAndView {
        val mav = ModelAndView("product/create")
        mav.addObject("companyId", id)
        return mav
    }

    @PostMapping("/companies/{id}/products")
    fun create(@PathVariable id: Long, name: String, price: Int, @RequestParam("photo") photo: MultipartFile): RedirectView {
        var product = Product(0, id, name, price, "RDA")
        product = productRepository.save(product)

        val parent = File("/home/legend/trust-farm")
        if (!parent.exists()) {
            parent.mkdirs()
        }

        val file = "/home/legend/trust-farm/${product.id}.png"
        photo.transferTo(File(file))
        return RedirectView("/companies/$id")
    }
}