package com.hot.chicksbackend.repositories

import com.hot.chicksbackend.domain.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface UserRepository : ReactiveMongoRepository<User, String> {
}