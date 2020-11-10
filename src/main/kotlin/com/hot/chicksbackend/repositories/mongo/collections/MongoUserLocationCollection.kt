package com.hot.chicksbackend.repositories.mongo.collections

import com.hot.chicksbackend.domain.user.UserLocations
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface MongoUserLocationCollection : ReactiveMongoRepository<UserLocations, String>