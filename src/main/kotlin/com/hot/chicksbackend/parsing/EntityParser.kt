package com.hot.chicksbackend.parsing

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.hot.chicksbackend.domain.user.User

object EntityParser {
    private val mapper = ObjectMapper().registerKotlinModule()

    fun <T>entityToString(entity: T): String {
        return mapper.writeValueAsString(entity)
    }

    fun <T>listOfEntitiesToString(list: List<T>): String {
        return mapper.writeValueAsString(list)
    }
}