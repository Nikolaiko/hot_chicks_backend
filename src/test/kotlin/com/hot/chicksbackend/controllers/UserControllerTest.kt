package com.hot.chicksbackend.controllers

import com.hot.chicksbackend.domain.user.User
import com.hot.chicksbackend.repositories.UserRepository
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

internal class UserControllerTest {
    private lateinit var userRepository: UserRepository
    private lateinit var userController: UserController
    private lateinit var webTestClient: WebTestClient

    @Before
    fun setUp() {
        userRepository = Mockito.mock(UserRepository::class.java)
        userController = UserController(userRepository)

        webTestClient = WebTestClient.bindToController(userController).build()
    }


    @Test
    fun getAllUsers() {
        BDDMockito.given(userRepository.findAll())
                .willReturn(Flux.just(
                                User(userName = "User1", userPassword = "123"),
                                User(userName = "User2", userPassword = "123")
                            )
                )

        webTestClient.get()
                .uri("/api/v1/users")
                .exchange()
                .expectBodyList(User::class.java)
                .hasSize(2)
    }

    @Test
    fun getUserById() {
        BDDMockito.given(userRepository.findById("User1"))
                .willReturn(Mono.just(User(userName = "User1", userPassword = "123")))


        webTestClient.get()
                .uri("/api/v1/users/User1")
                .exchange()
                .expectBodyList(User::class.java)
                .hasSize(1)
    }
}