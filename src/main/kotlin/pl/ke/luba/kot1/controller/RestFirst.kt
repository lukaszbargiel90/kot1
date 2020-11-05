package pl.ke.luba.kot1.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import pl.ke.luba.kot1.model.User
import pl.ke.luba.kot1.repository.UserRepository

@RestController
class RestFirst {

    @Autowired
    lateinit var userRepository: UserRepository

    @GetMapping("/hello")
    fun sayHello(): String = "hello222"

    @GetMapping("/users")
    fun allUsers(): List<User> {
        return userRepository.findAll()
    }
}