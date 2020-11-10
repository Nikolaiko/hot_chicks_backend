package com.hot.chicksbackend.repositories.mongo.collections

import com.hot.chicksbackend.domain.locations.Location
import com.hot.chicksbackend.domain.user.UserResources
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface MongoUserResourcesCollection : ReactiveMongoRepository<UserResources, String>