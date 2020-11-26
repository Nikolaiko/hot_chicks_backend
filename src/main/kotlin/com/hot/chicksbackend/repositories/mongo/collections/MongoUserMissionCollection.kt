package com.hot.chicksbackend.repositories.mongo.collections

import com.hot.chicksbackend.domain.user.UserMissions
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface MongoUserMissionCollection : ReactiveMongoRepository<UserMissions, String>