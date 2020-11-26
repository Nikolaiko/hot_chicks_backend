package com.hot.chicksbackend.repositories.mongo.collections

import com.hot.chicksbackend.db.USER_ID_FIELD_NAME
import com.hot.chicksbackend.domain.user.UserLocations
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux

interface MongoUserLocationCollection : ReactiveMongoRepository<UserLocations, String> {

    @Query(value = "{ $USER_ID_FIELD_NAME : ?0 }")
    fun getUserLocations(userId: String): Flux<UserLocations>
}