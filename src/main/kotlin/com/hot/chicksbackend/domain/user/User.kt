package com.hot.chicksbackend.domain.user

import com.fasterxml.jackson.annotation.JsonProperty
import com.hot.chicksbackend.db.USER_COLLECTION_NAME
import com.hot.chicksbackend.db.USER_NAME_FIELD_NAME
import com.hot.chicksbackend.db.USER_PASSWORD_FIELD_NAME
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = USER_COLLECTION_NAME)
data class User(
        @Id
        @JsonProperty("id")
        val userId: String?,

        @Field(name = USER_NAME_FIELD_NAME)
        @JsonProperty("name")
        val userName: String,

        @Field(name = USER_PASSWORD_FIELD_NAME)
        @JsonProperty("password")
        val userPassword: String
)