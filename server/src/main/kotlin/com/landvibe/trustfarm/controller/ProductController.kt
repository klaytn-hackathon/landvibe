package com.landvibe.trustfarm.controller

import com.landvibe.trustfarm.PhotoUtils
import com.landvibe.trustfarm.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.ModelAndView
import java.io.File
import java.util.*

@Controller
class ProductController {
    @Autowired
    lateinit var productRepository: ProductRepository

    @GetMapping("/products")
    fun list(): ModelAndView {
        val mav = ModelAndView("product/list")
        mav.addObject("products", productRepository.findAll())
        return mav
    }

    @GetMapping("/products/{id}")
    fun detail(@PathVariable id: Long): ModelAndView {
        val mav = ModelAndView("/product/detail")
        mav.addObject("product", productRepository.findById(id).get())
        return mav
    }

    @ResponseBody
    @PostMapping("/products/{id}")
    fun observe(@PathVariable id: Long, @RequestParam("photo") photo: MultipartFile, info: String): ResponseEntity<Void> {
        val product = productRepository.findById(id).get()
        val parent = File("/home/legend/trust-farm/$id")
//        val parent = File("/Users/kakao/yongdev/img-trustfarm/$id")
        if (!parent.exists()) {
            parent.mkdirs()
        }

//        val file = "/Users/kakao/yongdev/img-trustfarm/$id/${Date().time}.png"
        val file = "/home/legend/trust-farm/$id/${Date().time}.png"
        photo.transferTo(File(file))
        PhotoUtils.watermark(file, info, product.certification)

        return ResponseEntity.ok().build()
    }

    @GetMapping("/companies/{companyId}/products")
    fun listByCompany(@PathVariable companyId: Long): ModelAndView {
        val mav = ModelAndView("product/list")
        mav.addObject("products", productRepository.findAllByCompanyId(companyId))
        return mav
    }
}