package com.hot.chicksbackend.repositories

import com.hot.chicksbackend.domain.locations.Location
import com.hot.chicksbackend.domain.user.User
import com.hot.chicksbackend.domain.user.UserLocations
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface LocationRepository {
    fun getLocationByName(name: String): Mono<Location>
    fun addUserLocation(location: UserLocations): Mono<UserLocations>
}