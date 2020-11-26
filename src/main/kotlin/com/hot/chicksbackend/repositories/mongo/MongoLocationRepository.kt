package com.hot.chicksbackend.repositories.mongo

import com.hot.chicksbackend.domain.user.UserLocations
import com.hot.chicksbackend.repositories.LocationRepository
import com.hot.chicksbackend.repositories.mongo.collections.MongoLocationCollection
import com.hot.chicksbackend.repositories.mongo.collections.MongoUserLocationCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class MongoLocationRepository @Autowired constructor (
        private val locationCollection: MongoLocationCollection,
        private val userLocationCollection: MongoUserLocationCollection
) : LocationRepository {

        override fun getLocationByName(name: String) = locationCollection.getLocationByName(name)

        override fun addUserLocation(location: UserLocations) = userLocationCollection.insert(location)

        override fun getUserLocations(userId: String) = userLocationCollection.getUserLocations(userId)
}