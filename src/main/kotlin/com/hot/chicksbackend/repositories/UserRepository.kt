package com.hot.chicksbackend.repositories

import com.hot.chicksbackend.domain.locations.Location
import com.hot.chicksbackend.domain.user.User
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface UserRepository {
    fun isUserExists(user: User): Mono<Boolean>
    fun addUser(user: User): Mono<User>
    fun getUserByNameAndPassword(name: String, password: String): Mono<User>
}