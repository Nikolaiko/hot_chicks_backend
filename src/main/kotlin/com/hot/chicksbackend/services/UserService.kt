package com.hot.chicksbackend.services

import com.hot.chicksbackend.ERROR_ADDING_USER
import com.hot.chicksbackend.INITIAL_LOCATION_NAME
import com.hot.chicksbackend.TOKENS_INITIAL_VALUE
import com.hot.chicksbackend.USER_ALREADY_EXISTS
import com.hot.chicksbackend.domain.common.OperationResult
import com.hot.chicksbackend.domain.user.User
import com.hot.chicksbackend.domain.user.UserLocations
import com.hot.chicksbackend.domain.user.UserResources
import com.hot.chicksbackend.repositories.LocationRepository
import com.hot.chicksbackend.repositories.ResourcesRepository
import com.hot.chicksbackend.repositories.UserRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
        private val userRepository: UserRepository,
        private val locationRepository: LocationRepository,
        private val resourcesRepository: ResourcesRepository
) {
    suspend fun loginUser(name: String, password: String) = coroutineScope<User?> {
        userRepository.getUserByNameAndPassword(name, password).awaitFirstOrNull()
    }

    suspend fun registerUser(name: String, password: String) = coroutineScope<OperationResult<User>> {
        val existingUser = userRepository.getUserByNameAndPassword(name, password).awaitFirstOrNull()
        when(existingUser) {
            null -> {
                val insertedUser = userRepository.addUser(User(null, name, password)).awaitFirstOrNull()
                if (insertedUser == null) {
                    OperationResult<User>(ERROR_ADDING_USER, null)
                } else {
                    val startUpLocation = locationRepository.getLocationByName(INITIAL_LOCATION_NAME).awaitFirstOrNull()

                    val userLocations = UserLocations(null, startUpLocation?.locationId!!, insertedUser.userId!!)
                    locationRepository.addUserLocation(userLocations).awaitFirstOrNull()

                    val resources = UserResources(null, TOKENS_INITIAL_VALUE, insertedUser.userId)
                    resourcesRepository.initUserResources(resources).awaitFirstOrNull()

                    

                    OperationResult<User>("OK", insertedUser)
                }
            }
            else -> {
                OperationResult<User>(USER_ALREADY_EXISTS, null)
            }
        }
    }
}