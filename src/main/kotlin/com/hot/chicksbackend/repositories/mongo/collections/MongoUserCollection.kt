package com.hot.chicksbackend.repositories.mongo.collections

import com.hot.chicksbackend.db.USER_NAME_FIELD_NAME
import com.hot.chicksbackend.db.USER_PASSWORD_FIELD_NAME
import com.hot.chicksbackend.domain.user.User
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface MongoUserCollection : ReactiveMongoRepository<User, String> {

    @Query(value = "{ $USER_NAME_FIELD_NAME : ?0, $USER_PASSWORD_FIELD_NAME : ?1 }")
    fun getUserByNameAndPassword(name: String, password: String): Mono<User>
}