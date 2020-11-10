package com.hot.chicksbackend.repositories.mongo.collections

import com.hot.chicksbackend.db.LOCATION_NAME_FIELD_NAME
import com.hot.chicksbackend.db.USER_NAME_FIELD_NAME
import com.hot.chicksbackend.db.USER_PASSWORD_FIELD_NAME
import com.hot.chicksbackend.domain.locations.Location
import com.hot.chicksbackend.domain.user.User
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface MongoLocationCollection : ReactiveMongoRepository<Location, String> {
    @Query(value = "{ $LOCATION_NAME_FIELD_NAME : ?0}")
    fun getLocationByName(name: String): Mono<Location>
}