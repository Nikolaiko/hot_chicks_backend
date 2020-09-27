package com.hot.chicksbackend.controllers

import com.hot.chicksbackend.domain.User
import com.hot.chicksbackend.repositories.UserRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class UserController(
        private val userRepository: UserRepository
) {

    @GetMapping("/api/v1/users")
    fun getAllUsers(): Flux<User> = userRepository.findAll()

    @GetMapping("/api/v1/users/{id}")
    fun getUserById(@PathVariable id: String): Mono<User> = userRepository.findById(id)
}