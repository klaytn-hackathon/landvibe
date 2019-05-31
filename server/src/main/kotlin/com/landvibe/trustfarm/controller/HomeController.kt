package com.landvibe.trustfarm.controller

import com.landvibe.trustfarm.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.servlet.ModelAndView

@Controller
class HomeController {
    @GetMapping("")
    fun detail(): ModelAndView {
        return ModelAndView("home")
    }
}