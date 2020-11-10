package com.hot.chicksbackend.controllers

import com.hot.chicksbackend.USER_NOT_FOUND
import com.hot.chicksbackend.domain.network.ErrorResponseData
import com.hot.chicksbackend.domain.user.User
import com.hot.chicksbackend.domain.network.UserLoginData
import com.hot.chicksbackend.parsing.EntityParser
import com.hot.chicksbackend.repositories.UserRepository
import com.hot.chicksbackend.services.UserService
import kotlinx.coroutines.reactive.awaitFirst
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Flux

@RestController
class UserController(
        private val userService: UserService
) {
    @PostMapping("/api/v1/users/login")
    @ResponseBody
    suspend fun loginUser(data: UserLoginData): ResponseEntity<String> {
        val selectedUser = userService.loginUser(data.name, data.password)
        return when(selectedUser) {
            null -> {
                ResponseEntity<String>(
                        EntityParser.entityToString(ErrorResponseData(USER_NOT_FOUND)),
                        HttpStatus.NOT_FOUND
                )
            }
            else -> {
                ResponseEntity<String>(
                        EntityParser.entityToString(selectedUser),
                        HttpStatus.OK
                )
            }
        }
    }

    @PostMapping("/api/v1/users/register")
    @ResponseBody
    suspend fun registerNewUser(@RequestBody data: UserLoginData): ResponseEntity<String> {
        val result = userService.registerUser(data.name, data.password)
        return when(result.result) {
            null -> {
                ResponseEntity<String>(
                        EntityParser.entityToString(result.message),
                        HttpStatus.INTERNAL_SERVER_ERROR
                )
            }
            else -> {
                ResponseEntity<String>(
                        EntityParser.entityToString(result.result),
                        HttpStatus.OK
                )
            }
        }
    }
}