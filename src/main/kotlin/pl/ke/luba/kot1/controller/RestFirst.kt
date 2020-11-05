package pl.ke.luba.kot1.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RestFirst {

    @GetMapping("hello")
    fun sayHello(): String = "hello222"

}