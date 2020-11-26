package com.hot.chicksbackend.controllers

import com.hot.chicksbackend.USER_NOT_FOUND
import com.hot.chicksbackend.domain.network.ErrorResponseData
import com.hot.chicksbackend.domain.network.UserLoginData
import com.hot.chicksbackend.domain.user.User
import com.hot.chicksbackend.domain.user.UserLocations
import com.hot.chicksbackend.parsing.EntityParser
import com.hot.chicksbackend.services.LocationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class LocationsController @Autowired constructor(
        private val locationService: LocationService
) {

    @GetMapping("/api/v1/locations/{user_id}")
    @ResponseBody
    suspend fun getUserLocations(@PathVariable("user_id") userId: String): ResponseEntity<List<UserLocations>> {
        val locations = locationService.getUserLocations(userId)
        return when(locations.result) {
            null -> {
                ResponseEntity<List<UserLocations>>(
                        emptyList(),
                        HttpStatus.INTERNAL_SERVER_ERROR
                )
            }
            else -> {
                ResponseEntity<List<UserLocations>>(
                        locations.result,
                        HttpStatus.OK
                )
            }
        }
    }
}