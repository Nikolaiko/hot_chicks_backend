package com.hot.chicksbackend.controllers

import com.hot.chicksbackend.ERROR_GETTING_USER_RESOURCES
import com.hot.chicksbackend.domain.user.UserLocations
import com.hot.chicksbackend.domain.user.UserResources
import com.hot.chicksbackend.services.ResourceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class ResourcesController @Autowired constructor(
        private val resourceService: ResourceService
) {
    @GetMapping("/api/v1/resources/{user_id}")
    @ResponseBody
    suspend fun getUserResources(@PathVariable("user_id") userId: String): ResponseEntity<UserResources> {
        val resource = resourceService.getUserResources(userId)
        return when(resource.result) {
            null -> {
                ResponseEntity<UserResources>(
                        UserResources(null, "", ""),
                        HttpStatus.INTERNAL_SERVER_ERROR
                )
            }
            else -> {
                ResponseEntity<UserResources>(
                        resource.result,
                        HttpStatus.OK
                )
            }
        }
    }
}