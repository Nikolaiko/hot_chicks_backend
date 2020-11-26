package com.hot.chicksbackend.services

import com.hot.chicksbackend.ERROR_GETTING_USER_RESOURCES
import com.hot.chicksbackend.domain.common.OperationResult
import com.hot.chicksbackend.domain.user.UserLocations
import com.hot.chicksbackend.repositories.LocationRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LocationService @Autowired constructor(
        private val locationRepository: LocationRepository
){
    suspend fun getUserLocations(userId: String) = coroutineScope<OperationResult<List<UserLocations>>> {
        val result = locationRepository.getUserLocations(userId).collectList().awaitFirstOrNull()
        when(result) {
            null -> OperationResult<List<UserLocations>>(ERROR_GETTING_USER_RESOURCES, null)
            else -> OperationResult<List<UserLocations>>("Ok", result)
        }
    }
}