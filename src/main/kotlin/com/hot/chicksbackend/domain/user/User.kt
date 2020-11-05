package com.hot.chicksbackend.domain.user

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "user")
data class User(
        @Id
        @JsonProperty("id")
        val userId: String?,

        @Field(name = "name")
        @JsonProperty("name")
        val userName: String,

        @Field(name = "password")
        @JsonProperty("password")
        val userPassword: String
)