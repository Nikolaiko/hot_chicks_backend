package com.hot.chicksbackend.services

import com.hot.chicksbackend.ERROR_GETTING_USER_LOCATIONS
import com.hot.chicksbackend.domain.common.OperationResult
import com.hot.chicksbackend.domain.user.UserLocations
import com.hot.chicksbackend.domain.user.UserResources
import com.hot.chicksbackend.repositories.ResourcesRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.coroutines.coroutineContext

@Service
class ResourceService @Autowired constructor(
        private val resourcesRepository: ResourcesRepository
){
    suspend fun getUserResources(userId: String) = coroutineScope<OperationResult<UserResources>> {
        val resources = resourcesRepository.getUserResources(userId).awaitFirstOrNull()
        when(resources) {
            null -> OperationResult<UserResources>(ERROR_GETTING_USER_LOCATIONS, null)
            else -> OperationResult<UserResources>("Ok", resources)
        }
    }
}