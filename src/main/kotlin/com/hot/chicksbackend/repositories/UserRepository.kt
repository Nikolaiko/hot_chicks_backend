package com.hot.chicksbackend.repositories

import com.hot.chicksbackend.domain.user.User
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface UserRepository : ReactiveMongoRepository<User, String> {
    @Query(value = "{'name': ?0, 'password': ?1}")
    fun getUserByNameAndPassword(name: String, password: String): Mono<User>
}